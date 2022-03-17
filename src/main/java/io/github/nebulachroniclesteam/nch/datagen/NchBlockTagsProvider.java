package io.github.nebulachroniclesteam.nch.datagen;

import io.github.nebulachroniclesteam.nch.NebulaChronicles;
import io.github.nebulachroniclesteam.nch.register.NchBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class NchBlockTagsProvider extends BlockTagsProvider {

    public NchBlockTagsProvider(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, NebulaChronicles.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(NchBlocks.COSMIC_SAND.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                NchBlocks.COSMIC_SANDSTONE.get(),
                NchBlocks.SILVERBLANC_STONE.get(),
                NchBlocks.MOSS_SILVERBLANC_STONE.get(),
                NchBlocks.SILVERBLANC_STONE_BRICKS.get(),
                NchBlocks.CHISELED_SILVERBLANC_STONE_BRICKS.get(),
                NchBlocks.SILVERBLANC_IRON_ORE.get(),
                NchBlocks.SILVERBLANC_GOLD_ORE.get(),
                NchBlocks.SILVERBLANC_BLACK_TUNGSTEN_ORE.get(),
                NchBlocks.SILVERBLANC_BEDROCK_DIAMOND_ORE.get(),
                NchBlocks.SILVERBLANC_BEDROCK.get(),
                NchBlocks.SILVERBLANC_BEDROCK_IRON_ORE.get(),
                NchBlocks.SILVERBLANC_BEDROCK_GOLD_ORE.get(),
                NchBlocks.SILVERBLANC_BEDROCK_BLACK_TUNGSTEN_ORE.get(),
                NchBlocks.SILVERBLANC_STONE_BRICKS_STAIRS.get(),
                NchBlocks.SILVERBLANC_STONE_BRICKS_SLAB.get());
        tag(BlockTags.MINEABLE_WITH_HOE).add(NchBlocks.WHITE_BUD_LEAF_BLOCK.get());
        tag(BlockTags.MINEABLE_WITH_AXE).add(
                NchBlocks.COARSE_CACTUS.get(),
                NchBlocks.COARSE_CACTUS_PLANKS.get(),
                NchBlocks.COARSE_CACTUS_STAIRS.get(),
                NchBlocks.COARSE_CACTUS_SLABS.get(),
                NchBlocks.COARSE_CACTUS_FENCE.get(),
                NchBlocks.COARSE_CACTUS_FENCE_GATE.get(),
                NchBlocks.COARSE_CACTUS_TRAPDOOR.get(),
                NchBlocks.COARSE_CACTUS_DOOR.get());
        tag(BlockTags.NEEDS_STONE_TOOL).add(
                NchBlocks.COSMIC_SANDSTONE.get(),
                NchBlocks.SILVERBLANC_STONE.get(),
                NchBlocks.MOSS_SILVERBLANC_STONE.get(),
                NchBlocks.SILVERBLANC_STONE_BRICKS.get(),
                NchBlocks.CHISELED_SILVERBLANC_STONE_BRICKS.get(),
                NchBlocks.SILVERBLANC_IRON_ORE.get(),
                NchBlocks.SILVERBLANC_BEDROCK.get(),
                NchBlocks.SILVERBLANC_BEDROCK_IRON_ORE.get(),
                NchBlocks.SILVERBLANC_BEDROCK_GOLD_ORE.get(),
                NchBlocks.SILVERBLANC_BEDROCK_BLACK_TUNGSTEN_ORE.get(),
                NchBlocks.SILVERBLANC_STONE_BRICKS_STAIRS.get(),
                NchBlocks.SILVERBLANC_STONE_BRICKS_SLAB.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(
                NchBlocks.SILVERBLANC_BLACK_TUNGSTEN_ORE.get(),
                NchBlocks.SILVERBLANC_GOLD_ORE.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL).add(NchBlocks.SILVERBLANC_BEDROCK_DIAMOND_ORE.get());
        tag(BlockTags.WOODEN_DOORS).add(NchBlocks.COARSE_CACTUS_DOOR.get());
        tag(BlockTags.WOODEN_FENCES).add(NchBlocks.COARSE_CACTUS_FENCE.get());
        tag(BlockTags.WOODEN_SLABS).add(NchBlocks.COARSE_CACTUS_SLABS.get());
        tag(BlockTags.WOODEN_STAIRS).add(NchBlocks.COARSE_CACTUS_STAIRS.get());
        tag(BlockTags.WOODEN_TRAPDOORS).add(NchBlocks.COARSE_CACTUS_TRAPDOOR.get());
        tag(BlockTags.STONE_BRICKS).add(NchBlocks.SILVERBLANC_STONE_BRICKS.get());
        tag(BlockTags.SLABS).add(NchBlocks.SILVERBLANC_STONE_BRICKS_SLAB.get());
        tag(BlockTags.STAIRS).add(NchBlocks.SILVERBLANC_STONE_BRICKS_STAIRS.get());
        tag(BlockTags.FENCE_GATES).add(NchBlocks.COARSE_CACTUS_FENCE_GATE.get());
        tag(BlockTags.PLANKS).add(NchBlocks.COARSE_CACTUS_PLANKS.get());
        tag(BlockTags.SMALL_FLOWERS).add(NchBlocks.BLUE_KODOKU_FLOWER.get(),
                NchBlocks.WHITE_KODOKU_FLOWER.get(),
                NchBlocks.PURPLE_KODOKU_FLOWER.get());
        tag(BlockTags.FLOWER_POTS).add(NchBlocks.POTTED_BLUE_KODOKU_FLOWER.get(),
                NchBlocks.POTTED_WHITE_KODOKU_FLOWER.get(),
                NchBlocks.POTTED_PURPLE_KODOKU_FLOWER.get());
    }
}
