package io.github.nebulachroniclesteam.nch.codegen;

import com.github.javaparser_new.StaticJavaParser;
import com.github.javaparser_new.ast.CompilationUnit;
import com.github.javaparser_new.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser_new.ast.body.TypeDeclaration;
import lq2007.plugins.gradle_plugin.support.PluginHelper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static io.github.nebulachroniclesteam.nch.codegen.Templates.*;

public class Classes {

    private static final String PATH_NCH_ITEMS = "io.github.nebulachroniclesteam.nch.register.NchItems";
    private static final String PATH_NCH_LANG_EN = "io.github.nebulachroniclesteam.nch.datagen.NchLangProviderEn";
    private static final String PATH_NCH_LANG_ZH = "io.github.nebulachroniclesteam.nch.datagen.NchLangProviderZh";

    private static CompilationUnit NCH_ITEMS = null;

    public static CompilationUnit items(PluginHelper helper) throws IOException {
        if (NCH_ITEMS == null) {
            NCH_ITEMS = getOrCreate(NCH_ITEMS, helper, PATH_NCH_ITEMS);
            ClassOrInterfaceDeclaration c = clazz(NCH_ITEMS);
            if (c.getFieldByName("ITEMS").isEmpty()) {
                NCH_ITEMS.addImport(MOD_IMPORT);
                NCH_ITEMS.addImport(ITEM_IMPORT);
                NCH_ITEMS.addImport(REG_FIELD_IMPORT);
                c.addMember(regField("Item", "ITEMS"));
            }

            NCH_ITEMS.addImport(TABS_IMPORT);
        }
        return NCH_ITEMS;
    }

    public static CompilationUnit langEn(PluginHelper helper) throws IOException {
        return getOrCreate(null, helper, PATH_NCH_LANG_EN);
    }

    public static CompilationUnit langZh(PluginHelper helper) throws IOException {
        return getOrCreate(null, helper, PATH_NCH_LANG_ZH);
    }

    private static CompilationUnit getOrCreate(CompilationUnit unit, PluginHelper helper, String path) throws IOException {
        if (unit == null) {
            Path file = helper.srcPath().resolve(path.replace('.', '/') + ".java");
            if (Files.isRegularFile(file)) {
                unit = StaticJavaParser.parse(file);
            } else {
                int i = PATH_NCH_ITEMS.lastIndexOf(".");
                String packageName = PATH_NCH_ITEMS.substring(0, i);
                String className = PATH_NCH_ITEMS.substring(i + 1);
                unit = new CompilationUnit(packageName);
                unit.setStorage(file);
                unit.addClass(className);
            }
        }
        return unit;
    }

    public static ClassOrInterfaceDeclaration clazz(CompilationUnit unit) {
        return unit.getPrimaryType()
                .filter(TypeDeclaration::isClassOrInterfaceDeclaration)
                .map(TypeDeclaration::asClassOrInterfaceDeclaration)
                .orElseThrow();
    }
}
