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
                NchBlocks.SILVERBLANC_BEDROCK_DIAMOND_ORE.get());
        tag(BlockTags.NEEDS_STONE_TOOL).add(
                NchBlocks.COSMIC_SANDSTONE.get(),
                NchBlocks.SILVERBLANC_STONE.get(),
                NchBlocks.MOSS_SILVERBLANC_STONE.get(),
                NchBlocks.SILVERBLANC_STONE_BRICKS.get(),
                NchBlocks.CHISELED_SILVERBLANC_STONE_BRICKS.get(),
                NchBlocks.SILVERBLANC_IRON_ORE.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(
                NchBlocks.SILVERBLANC_BLACK_TUNGSTEN_ORE.get(),
                NchBlocks.SILVERBLANC_GOLD_ORE.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL).add(NchBlocks.SILVERBLANC_BEDROCK_DIAMOND_ORE.get());
    }
}
