package io.github.nebulachroniclesteam.nch.codegen;

import com.github.javaparser_new.ast.CompilationUnit;
import com.github.javaparser_new.ast.NodeList;
import com.github.javaparser_new.ast.body.FieldDeclaration;
import com.github.javaparser_new.ast.body.VariableDeclarator;
import com.github.javaparser_new.ast.expr.Expression;
import com.github.javaparser_new.ast.expr.StringLiteralExpr;
import com.github.javaparser_new.ast.stmt.ExpressionStmt;
import com.github.javaparser_new.ast.stmt.Statement;
import lq2007.plugins.gradle_plugin.support.EnumLoopResult;
import lq2007.plugins.gradle_plugin.support.ISourcePlugin;
import lq2007.plugins.gradle_plugin.support.PluginContext;
import lq2007.plugins.gradle_plugin.support.PluginHelper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static io.github.nebulachroniclesteam.nch.codegen.Templates.stmt;

public class GenItemLanguages implements ISourcePlugin {

    private CompilationUnit items, en, zh;
    private boolean run = false;

    @Override
    public void begin(PluginContext context, PluginHelper helper) throws Exception {
        items = Classes.items(helper);
        en = Classes.langEn(helper);
        zh = Classes.langZh(helper);
    }

    @Override
    public void each(Path file, PluginContext context, PluginHelper helper) throws Exception {
        run = true;

        List<Map<String, LanguageEntry>> languages = readLanguages(file);
        Map<String, LanguageEntry> enLanguages = languages.get(0);
        Map<String, LanguageEntry> zhLanguages = languages.get(1);

        List<String> miss = new LinkedList<>();

        Map<String, LanguageEntry> relEnLanguages = new HashMap<>();
        Map<String, LanguageEntry> relZhLanguages = new HashMap<>();
        for (FieldDeclaration field : Classes.clazz(items).getFields()) {
            for (VariableDeclarator variable : field.getVariables()) {
                String relName = variable.getNameAsString();
                String name = relName.toLowerCase(Locale.ROOT);
                LanguageEntry enEntry = enLanguages.get(name);
                if (enEntry == null) {
                    miss.add(relName);
                } else {
                    relEnLanguages.put(relName, enEntry);
                    LanguageEntry zhEntry = zhLanguages.get(name);
                    if (zhEntry != null) {
                        relZhLanguages.put(relName, zhEntry);
                    }
                }
            }
        }
        miss.remove("ITEMS");

        NodeList<Statement> enStmt = Classes.clazz(en).getMethodsByName("addTranslations").get(0).getBody().orElseThrow().getStatements();
        NodeList<Statement> zhStmt = Classes.clazz(zh).getMethodsByName("addTranslations").get(0).getBody().orElseThrow().getStatements();

        addLanguages(enStmt, relEnLanguages, true);
        addLanguages(zhStmt, relZhLanguages, false);

        en.getStorage().orElseThrow().save();
        zh.getStorage().orElseThrow().save();

        if (!miss.isEmpty()) {
            updateLanguages(file, miss);
        }
    }

    private void addLanguages(NodeList<Statement> statements, Map<String, LanguageEntry> languages, boolean allowNull) {
        statements.stream()
                .filter(Statement::isExpressionStmt)
                .map(Statement::asExpressionStmt)
                .map(ExpressionStmt::getExpression)
                .filter(Expression::isMethodCallExpr)
                .map(Expression::asMethodCallExpr)
                .filter(mce -> "addItem".equals(mce.getNameAsString()))
                .forEach(mce -> {
                    String name = mce.getArgument(0).asFieldAccessExpr().getNameAsString();
                    LanguageEntry lang = languages.get(name);
                    if (lang != null) {
                        if (lang.lang != null) {
                            if (mce.getArguments().size() == 2) {
                                if (!mce.getArgument(1).asStringLiteralExpr().getValue().equals(lang.lang)) {
                                    mce.setArgument(1, new StringLiteralExpr(lang.lang));
                                }
                            } else {
                                mce.addArgument(new StringLiteralExpr(lang.lang));
                            }
                        }
                        lang.exist = true;
                    }
                });
        languages.forEach((name, lang) -> {
            if (!lang.exist) {
                if (lang.lang == null) {
                    if (allowNull) {
                        statements.add(stmt("addItem(NchItems.%s);", name));
                    }
                } else {
                    statements.add(stmt("addItem(NchItems.%s, \"%s\");", name, lang.lang));
                }
            }
        });
    }

    @Override
    public EnumLoopResult finished(PluginContext context, PluginHelper helper) {
        return run ? EnumLoopResult.FINISHED : EnumLoopResult.CONTINUE;
    }

    // name -> en, zh
    private List<Map<String, LanguageEntry>> readLanguages(Path file) throws Exception {
        Map<String, LanguageEntry> langEn = new HashMap<>();
        Map<String, LanguageEntry> langZh = new HashMap<>();
        XSSFWorkbook workbook;

        try (InputStream is = Files.newInputStream(file)) {
            workbook = new XSSFWorkbook(is);
        }
        try (workbook) {
            XSSFSheet sheet = workbook.getSheet("Languages");
            Iterator<Row> iterator = sheet.rowIterator();
            while (iterator.hasNext()) {
                Row row = iterator.next();
                if (row.getRowNum() == 0) {
                    continue;
                }
                short count = row.getLastCellNum();
                if (count == 0) {
                    continue;
                }
                String name = row.getCell(0).getStringCellValue().toLowerCase(Locale.ROOT);
                if (count == 1) {
                    langEn.put(name, new LanguageEntry(null));
                } else if (count == 2) {
                    Cell cell = row.getCell(1);
                    if (cell.getCellType() == CellType.STRING)
                        langEn.put(name, new LanguageEntry(cell.getStringCellValue()));
                    else
                        langEn.put(name, new LanguageEntry(null));
                } else if (count >= 3) {
                    Cell cell = row.getCell(1);
                    if (cell != null && cell.getCellType() == CellType.STRING)
                        langEn.put(name, new LanguageEntry(cell.getStringCellValue()));
                    else
                        langEn.put(name, new LanguageEntry(null));
                    cell = row.getCell(2);
                    if (cell != null && cell.getCellType() == CellType.STRING)
                        langZh.put(name, new LanguageEntry(cell.getStringCellValue()));
                }
            }
        }
        return List.of(langEn, langZh);
    }

    private void updateLanguages(Path file, List<String> miss) throws IOException {
        if (miss.isEmpty()) return;
        XSSFWorkbook workbook;
        try (InputStream is = Files.newInputStream(file)) {
            workbook = new XSSFWorkbook(is);
        }
        try (workbook) {
            XSSFSheet sheet = workbook.getSheet("Languages");
            int i = sheet.getLastRowNum();
            for (String s : miss) {
                XSSFRow row = sheet.createRow(++i);
                row.createCell(0, CellType.STRING);
                row.getCell(0).setCellValue(s);
            }
            try (OutputStream os = Files.newOutputStream(file)) {
                workbook.write(os);
            }
        }
    }

    @Override
    public Path getLoopRoot(PluginHelper helper) {
        if (GenItemFromResource.finished) {
            return helper.assetsPath().resolve("nch/Languages.xlsx");
        }
        return null;
    }

    static class LanguageEntry {
        final String lang;
        boolean exist = false;

        public LanguageEntry(String lang) {
            this.lang = lang;
        }

        @Override
        public String toString() {
            return "LanguageEntry{" +
                    "lang='" + lang + '\'' +
                    ", exist=" + exist +
                    '}';
        }
    }
}
