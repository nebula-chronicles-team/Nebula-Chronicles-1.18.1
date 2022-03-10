package io.github.nebulachroniclesteam.nch.datagen;

import io.github.nebulachroniclesteam.nch.NebulaChronicles;
import io.github.nebulachroniclesteam.nch.register.NchItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class NchItemModelProvider extends ItemModelProvider {

    private final ResourceLocation generated = mcLoc(ITEM_FOLDER + "/generated");

    public NchItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, NebulaChronicles.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        singleTexture(name(NchItems.BUG_FLESH), generated, "layer0", texture("bug_flesh"));
        singleTexture(name(NchItems.LANTERN_BERRIES), generated, "layer0", texture("lantern_berries"));
        singleTexture(name(NchItems.WHITE_BUD_STEW), generated, "layer0", texture("white_bud_stew"));
        singleTexture(name(NchItems.WHITE_BUD_LEAVES), generated, "layer0", texture("white_bud_leaves"));

        singleTexture(name(NchItems.RAW_BLACK_TUNGSTEN), generated, "layer0", metal("raw_black_tungsten"));
        singleTexture(name(NchItems.BLACK_TUNGSTEN_DUST), generated, "layer0", metal("black_tungsten_dust"));
        singleTexture(name(NchItems.BLACK_TUNGSTEN_INGOT), generated, "layer0", metal("black_tungsten_ingot"));
        singleTexture(name(NchItems.BLACK_TUNGSTEN_NUGGET), generated, "layer0", metal("black_tungsten_nugget"));
    }

    private String name(RegistryObject<?> obj) {
        return obj.getId().getPath();
    }

    private ResourceLocation texture(String name) {
        return modLoc("item/" + name);
    }

    private ResourceLocation metal(String name) {
        return modLoc("item/metal/" + name);
    }
}
