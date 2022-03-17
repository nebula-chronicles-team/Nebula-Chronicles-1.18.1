package io.github.nebulachroniclesteam.nch.datagen;

import io.github.nebulachroniclesteam.nch.NebulaChronicles;
import io.github.nebulachroniclesteam.nch.register.NchBlocks;
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
        item(NchItems.BUG_FLESH);
        item(NchItems.LANTERN_BERRIES);
        item(NchItems.WHITE_BUD_STEW);
        item(NchItems.WHITE_BUD_LEAVES);
        itemBlock(NchItems.WHITE_BUD);
        block(NchItems.WHITE_BUD);
        metal(NchItems.RAW_BLACK_TUNGSTEN);
        metal(NchItems.BLACK_TUNGSTEN_DUST);
        metal(NchItems.BLACK_TUNGSTEN_INGOT);
        metal(NchItems.BLACK_TUNGSTEN_NUGGET);
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
        block(NchBlocks.WHITE_BUD_LEAF_BLOCK);
        block(NchBlocks.STRANGE_FERN);
        itemBlock(NchItems.LANTERN_BERRIES_PLANT);
        item(NchBlocks.COARSE_CACTUS);
        block(NchBlocks.COARSE_CACTUS_PLANKS);
        block(NchBlocks.COARSE_CACTUS_STAIRS);
        block(NchBlocks.COARSE_CACTUS_SLABS);
        block(NchBlocks.COARSE_CACTUS_FENCE, "inventory");
        block(NchBlocks.COARSE_CACTUS_FENCE_GATE);
        block(NchBlocks.COARSE_CACTUS_TRAPDOOR, "bottom");
        item(NchBlocks.COARSE_CACTUS_DOOR);
        block(NchBlocks.BLUE_KODOKU_FLOWER);
        block(NchBlocks.PURPLE_KODOKU_FLOWER);
        block(NchBlocks.WHITE_KODOKU_FLOWER);
        block(NchBlocks.SILVERBLANC_BEDROCK);
        block(NchBlocks.SILVERBLANC_BEDROCK_IRON_ORE);
        block(NchBlocks.SILVERBLANC_BEDROCK_GOLD_ORE);
        block(NchBlocks.SILVERBLANC_BEDROCK_BLACK_TUNGSTEN_ORE);
        block(NchBlocks.SILVERBLANC_STONE_BRICKS_STAIRS);
        block(NchBlocks.SILVERBLANC_STONE_BRICKS_SLAB);
    }

    private String name(RegistryObject<?> obj) {
        return obj.getId().getPath();
    }

    private void item(RegistryObject<?> item) {
        String name = name(item);
        singleTexture(name, generated, "layer0", modLoc("item/" + name));
    }

    private void metal(RegistryObject<?> item) {
        String name = name(item);
        singleTexture(name, generated, "layer0", modLoc("item/metal/" + name));
    }

    private void itemBlock(RegistryObject<?> block) {
        String name = name(block);
        singleTexture(name, generated, "layer0", modLoc("block/" + name));
    }

    private void block(RegistryObject<?> block) {
        withExistingParent(name(block), modLoc(BLOCK_FOLDER + "/" + name(block)));
    }

    private void block(RegistryObject<?> block, String postfix) {
        String name = name(block);
        withExistingParent(name, modLoc(BLOCK_FOLDER + "/" + name + "_" + postfix));
    }
}
