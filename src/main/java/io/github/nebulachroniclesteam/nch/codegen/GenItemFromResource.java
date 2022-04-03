package io.github.nebulachroniclesteam.nch.codegen;

import com.github.javaparser_new.StaticJavaParser;
import com.github.javaparser_new.ast.CompilationUnit;
import com.github.javaparser_new.ast.body.BodyDeclaration;
import com.github.javaparser_new.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser_new.ast.body.TypeDeclaration;
import com.github.javaparser_new.ast.comments.Comment;
import com.github.javaparser_new.ast.comments.LineComment;
import lq2007.plugins.gradle_plugin.support.EnumLoopResult;
import lq2007.plugins.gradle_plugin.support.PluginContext;
import lq2007.plugins.gradle_plugin.support.PluginHelper;
import lq2007.plugins.gradle_plugin.support.SimpleSourcePlugin;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static io.github.nebulachroniclesteam.nch.codegen.Templates.*;

public class GenItemFromResource extends SimpleSourcePlugin {

    private static final String PATH = "io.github.nebulachroniclesteam.nch.register.NchItems";
    private static final String RESOURCE = "nch/textures/item/metal";

    CompilationUnit unit;
    ClassOrInterfaceDeclaration declaration;
    boolean changed = false;
    final Map<String, BodyDeclaration<?>> fields = new HashMap<>();

    @Override
    public void begin(PluginContext context, PluginHelper helper) throws Exception {
        Path file = helper.srcPath().resolve(PATH.replace('.', '/') + ".java");
        if (Files.isRegularFile(file)) {
            unit = StaticJavaParser.parse(file);
            declaration = unit.getPrimaryType()
                    .filter(TypeDeclaration::isClassOrInterfaceDeclaration)
                    .map(TypeDeclaration::asClassOrInterfaceDeclaration)
                    .orElseThrow();
            declaration.getFields().stream()
                    .filter(field -> field.isStatic() && field.isFinal())
                    .forEach(field -> field.getComment()
                            .filter(Comment::isLineComment)
                            .map(Comment::asLineComment)
                            .map(LineComment::getContent)
                            .map(String::trim)
                            .filter(s -> s.startsWith("resource "))
                            .map(s -> s.substring(9))
                            .ifPresent(s -> fields.put(s, field)));
        } else {
            int i = PATH.lastIndexOf(".");
            String packageName = PATH.substring(0, i);
            String className = PATH.substring(i + 1);
            unit = new CompilationUnit(packageName);
            unit.setStorage(file);
            unit.addClass(className);
        }

        if (declaration.getFieldByName("ITEMS").isEmpty()) {
            unit.addImport(MOD_IMPORT);
            unit.addImport(ITEM_IMPORT);
            unit.addImport(REG_FIELD_IMPORT);
            declaration.addMember(regField("Item", "ITEMS"));
        }

        unit.addImport(TABS_IMPORT);
    }

    @Override
    public void each(Path file, PluginContext context, PluginHelper helper) {
        String fileName = file.getFileName().toString();
        if (fileName.endsWith(".png")) {
            if (fields.remove(fileName) == null) {
                String registryName = fileName.substring(0, fileName.length() - 4);
                String fieldName = registryName.toUpperCase(Locale.ROOT);
                declaration.addMember(item(fileName, fieldName, registryName, "NCH_INDUSTRIAL_ITEMS"));
                changed = true;
            }
        }
    }

    @Override
    public EnumLoopResult finished(PluginContext context, PluginHelper helper) {
        for (BodyDeclaration<?> value : fields.values()) {
            if (declaration.remove(value)) {
                changed = true;
            }
        }

        if (changed) {
            unit.getStorage().orElseThrow().save();
        }

        return EnumLoopResult.FINISHED;
    }

    @Override
    public Path getLoopRoot(PluginHelper helper) {
        Path resolve = helper.assetsPath().resolve(RESOURCE);
        System.out.println(resolve);
        return resolve;
    }
}
