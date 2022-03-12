package io.github.nebulachroniclesteam.nch.datagen;

import io.github.nebulachroniclesteam.nch.NebulaChronicles;
import io.github.nebulachroniclesteam.nch.register.NchBlocks;
import io.github.nebulachroniclesteam.nch.register.NchItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
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
        singleTexture(name(NchItems.WHITE_BUD), generated, "layer0", modLoc("block/" + name(NchItems.WHITE_BUD)));

        singleTexture(name(NchItems.RAW_BLACK_TUNGSTEN), generated, "layer0", metal("raw_black_tungsten"));
        singleTexture(name(NchItems.BLACK_TUNGSTEN_DUST), generated, "layer0", metal("black_tungsten_dust"));
        singleTexture(name(NchItems.BLACK_TUNGSTEN_INGOT), generated, "layer0", metal("black_tungsten_ingot"));
        singleTexture(name(NchItems.BLACK_TUNGSTEN_NUGGET), generated, "layer0", metal("black_tungsten_nugget"));

        block(NchBlocks.COSMIC_SAND);
        block(NchBlocks.COSMIC_SANDSTONE);
        block(NchBlocks.SILVERBLANC_STONE);
        withExistingParent(name(NchBlocks.MOSS_SILVERBLANC_STONE), modLoc(BLOCK_FOLDER + "/" + name(NchBlocks.MOSS_SILVERBLANC_STONE) + "_1"));
        block(NchBlocks.SILVERBLANC_STONE_BRICKS);
        block(NchBlocks.CHISELED_SILVERBLANC_STONE_BRICKS);
        block(NchBlocks.SILVERBLANC_IRON_ORE);
        block(NchBlocks.SILVERBLANC_GOLD_ORE);
        block(NchBlocks.SILVERBLANC_BLACK_TUNGSTEN_ORE);
        block(NchBlocks.SILVERBLANC_BEDROCK_DIAMOND_ORE);
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

    private <T extends Block> void block(RegistryObject<T> block) {
        withExistingParent(name(block), modLoc(BLOCK_FOLDER + "/" + name(block)));
    }
}
