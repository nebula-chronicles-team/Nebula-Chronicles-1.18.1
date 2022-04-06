package io.github.nebulachroniclesteam.nch.codegen;

import com.github.javaparser_new.ast.CompilationUnit;
import com.github.javaparser_new.ast.body.BodyDeclaration;
import com.github.javaparser_new.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser_new.ast.comments.Comment;
import com.github.javaparser_new.ast.comments.LineComment;
import lq2007.plugins.gradle_plugin.support.EnumLoopResult;
import lq2007.plugins.gradle_plugin.support.ISourcePlugin;
import lq2007.plugins.gradle_plugin.support.PluginContext;
import lq2007.plugins.gradle_plugin.support.PluginHelper;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static io.github.nebulachroniclesteam.nch.codegen.Templates.*;

public class GenItemFromResource implements ISourcePlugin {

    private static final String RESOURCE = "nch/textures/item/metal";
    public static boolean finished = false;

    CompilationUnit unit;
    ClassOrInterfaceDeclaration declaration;
    boolean changed = false;
    final Map<String, BodyDeclaration<?>> fields = new HashMap<>();

    @Override
    public void begin(PluginContext context, PluginHelper helper) throws Exception {
        unit = Classes.items(helper);
        declaration = Classes.clazz(unit);
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

        finished = true;
        return EnumLoopResult.FINISHED;
    }

    @Override
    public Path getLoopRoot(PluginHelper helper) {
        Path resolve = helper.assetsPath().resolve(RESOURCE);
        System.out.println(resolve);
        return resolve;
    }
}
