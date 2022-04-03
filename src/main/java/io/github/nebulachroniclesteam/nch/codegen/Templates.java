package io.github.nebulachroniclesteam.nch.codegen;

import com.github.javaparser_new.StaticJavaParser;
import com.github.javaparser_new.ast.ImportDeclaration;
import com.github.javaparser_new.ast.body.BodyDeclaration;

public class Templates {

    private static final String MOD_ID = "NebulaChronicles.MOD_ID";

    public static final ImportDeclaration MOD_IMPORT = StaticJavaParser.parseImport("import io.github.nebulachroniclesteam.nch.NebulaChronicles;");

    public static final ImportDeclaration ITEM_IMPORT = StaticJavaParser.parseImport("import net.minecraft.world.item.*;");

    public static final ImportDeclaration REG_FIELD_IMPORT = StaticJavaParser.parseImport("import net.minecraftforge.registries.*;");

    public static final ImportDeclaration TABS_IMPORT = StaticJavaParser.parseImport("import static io.github.nebulachroniclesteam.nch.register.NchCreativeModeTab.*;");

    public static BodyDeclaration<?> regField(String type, String name) {
        return body("public static final DeferredRegister<%1$s> %2$s = DeferredRegister.create(ForgeRegistries.%2$s, %3$s);",
                type, name, MOD_ID);
    }

    public static BodyDeclaration<?> item(String resourceName, String fieldName, String registryName, String tab) {
        return body("// resource %s\n" +
                        "public static final RegistryObject<Item> %s = ITEMS.register(\"%s\", () -> new Item(new Item.Properties().tab(%s)));",
                resourceName, fieldName, registryName, tab);
    }

    private static BodyDeclaration<?> body(String code, String... params) {
        return StaticJavaParser.parseBodyDeclaration(String.format(code, (Object[]) params));
    }
}
