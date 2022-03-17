package io.github.nebulachroniclesteam.nch.datagen;

import io.github.nebulachroniclesteam.nch.NebulaChronicles;
import io.github.nebulachroniclesteam.nch.block.WhiteBudBush;
import io.github.nebulachroniclesteam.nch.register.NchBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class NchBlockStateProvider extends BlockStateProvider {
    private final ResourceLocation tintedCross = mcLoc(ModelProvider.BLOCK_FOLDER + "/tinted_cross");
    private final ResourceLocation pot = mcLoc(ModelProvider.BLOCK_FOLDER + "/flower_pot_cross");

    public NchBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, NebulaChronicles.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        getVariantBuilder(NchBlocks.WHITE_BUD_BUSH.get())
                .partialState().with(WhiteBudBush.AGE, 0).modelForState()
                .modelFile(tintedCross(name(NchBlocks.WHITE_BUD_BUSH, 0), "white_bud_bush_0")).addModel()
                .partialState().with(WhiteBudBush.AGE, 1).modelForState()
                .modelFile(tintedCross(name(NchBlocks.WHITE_BUD_BUSH, 0), "white_bud_bush_0")).addModel()
                .partialState().with(WhiteBudBush.AGE, 2).modelForState()
                .modelFile(tintedCross(name(NchBlocks.WHITE_BUD_BUSH, 1), "white_bud_bush_1")).addModel();
        tintedCross(NchBlocks.WHITE_BUD);
        cubeAll(NchBlocks.COSMIC_SAND);
        column(NchBlocks.COSMIC_SANDSTONE);
        cubeAll(NchBlocks.SILVERBLANC_STONE);
        cubeAll(NchBlocks.SILVERBLANC_STONE_BRICKS);
        cubeAll(NchBlocks.CHISELED_SILVERBLANC_STONE_BRICKS);
        cubeAll(NchBlocks.SILVERBLANC_IRON_ORE);
        cubeAll(NchBlocks.SILVERBLANC_GOLD_ORE);
        cubeAll(NchBlocks.SILVERBLANC_BLACK_TUNGSTEN_ORE);
        cubeAll(NchBlocks.SILVERBLANC_BEDROCK_DIAMOND_ORE);
        simpleBlock(NchBlocks.MOSS_SILVERBLANC_STONE.get(),
                new ConfiguredModel(models().cubeBottomTop(name(NchBlocks.MOSS_SILVERBLANC_STONE, 1),
                        tex(NchBlocks.MOSS_SILVERBLANC_STONE, "side"),
                        tex(NchBlocks.MOSS_SILVERBLANC_STONE, "bottom"),
                        tex(NchBlocks.MOSS_SILVERBLANC_STONE, "top1"))),
                new ConfiguredModel(models().cubeBottomTop(name(NchBlocks.MOSS_SILVERBLANC_STONE, 2),
                        tex(NchBlocks.MOSS_SILVERBLANC_STONE, "side"),
                        tex(NchBlocks.MOSS_SILVERBLANC_STONE, "bottom"),
                        tex(NchBlocks.MOSS_SILVERBLANC_STONE, "top2"))),
                new ConfiguredModel(models().cubeBottomTop(name(NchBlocks.MOSS_SILVERBLANC_STONE, 3),
                        tex(NchBlocks.MOSS_SILVERBLANC_STONE, "side"),
                        tex(NchBlocks.MOSS_SILVERBLANC_STONE, "bottom"),
                        tex(NchBlocks.MOSS_SILVERBLANC_STONE, "top3"))),
                new ConfiguredModel(models().cubeBottomTop(name(NchBlocks.MOSS_SILVERBLANC_STONE, 4),
                        tex(NchBlocks.MOSS_SILVERBLANC_STONE, "side"),
                        tex(NchBlocks.MOSS_SILVERBLANC_STONE, "bottom"),
                        tex(NchBlocks.MOSS_SILVERBLANC_STONE, "top4"))),
                new ConfiguredModel(models().cubeBottomTop(name(NchBlocks.MOSS_SILVERBLANC_STONE, 5),
                        tex(NchBlocks.MOSS_SILVERBLANC_STONE, "side"),
                        tex(NchBlocks.MOSS_SILVERBLANC_STONE, "bottom"),
                        tex(NchBlocks.MOSS_SILVERBLANC_STONE, "top5"))));
        cubeAll(NchBlocks.WHITE_BUD_LEAF_BLOCK);
        tintedCross(NchBlocks.STRANGE_FERN);
        tintedCross(NchBlocks.LANTERN_BERRIES_PLANT);
        cubeAll(NchBlocks.COARSE_CACTUS_PLANKS);
        ResourceLocation locPlanks = tex(NchBlocks.COARSE_CACTUS_PLANKS);
        stairsBlock((StairBlock) NchBlocks.COARSE_CACTUS_STAIRS.get(), locPlanks);
        slabBlock((SlabBlock) NchBlocks.COARSE_CACTUS_SLABS.get(), locPlanks, locPlanks);
        fenceBlock((FenceBlock) NchBlocks.COARSE_CACTUS_FENCE.get(), locPlanks);
        models().fenceInventory(NchBlocks.COARSE_CACTUS_FENCE.getId().getPath() + "_inventory", locPlanks);
        fenceGateBlock((FenceGateBlock) NchBlocks.COARSE_CACTUS_FENCE_GATE.get(), locPlanks);
        trapdoorBlock((TrapDoorBlock) NchBlocks.COARSE_CACTUS_TRAPDOOR.get(), locPlanks, true);
        doorBlock((DoorBlock) NchBlocks.COARSE_CACTUS_DOOR.get(),
                tex(NchBlocks.COARSE_CACTUS_DOOR, "bottom"),
                tex(NchBlocks.COARSE_CACTUS_DOOR, "top"));
        pottedPlant(NchBlocks.POTTED_BLUE_KODOKU_FLOWER, NchBlocks.BLUE_KODOKU_FLOWER);
        pottedPlant(NchBlocks.POTTED_PURPLE_KODOKU_FLOWER, NchBlocks.PURPLE_KODOKU_FLOWER);
        pottedPlant(NchBlocks.POTTED_WHITE_KODOKU_FLOWER, NchBlocks.WHITE_KODOKU_FLOWER);
        cross(NchBlocks.BLUE_KODOKU_FLOWER);
        cross(NchBlocks.PURPLE_KODOKU_FLOWER);
        cross(NchBlocks.WHITE_KODOKU_FLOWER);
        cubeAll(NchBlocks.SILVERBLANC_BEDROCK);
        cubeAll(NchBlocks.SILVERBLANC_BEDROCK_IRON_ORE);
        cubeAll(NchBlocks.SILVERBLANC_BEDROCK_GOLD_ORE);
        cubeAll(NchBlocks.SILVERBLANC_BEDROCK_BLACK_TUNGSTEN_ORE);
        ResourceLocation locSilverblancStoneBricks = tex(NchBlocks.SILVERBLANC_STONE_BRICKS);
        stairsBlock((StairBlock) NchBlocks.SILVERBLANC_STONE_BRICKS_STAIRS.get(), locSilverblancStoneBricks);
        slabBlock((SlabBlock) NchBlocks.SILVERBLANC_STONE_BRICKS_SLAB.get(), locSilverblancStoneBricks, locSilverblancStoneBricks);
    }

    private String name(RegistryObject<?> block) {
        return block.getId().getPath();
    }

    private String name(RegistryObject<?> block, Object postfix) {
        return block.getId().getPath() + "_" + postfix;
    }

    private ResourceLocation tex(RegistryObject<?> block, Object postfix) {
        return modLoc(ModelProvider.BLOCK_FOLDER + "/" + name(block, postfix));
    }

    private ResourceLocation tex(RegistryObject<?> block) {
        return modLoc(ModelProvider.BLOCK_FOLDER + "/" + name(block));
    }

    private BlockModelBuilder tintedCross(String name, String texture) {
        return models().singleTexture(name, tintedCross, "cross", modLoc(ModelProvider.BLOCK_FOLDER + "/" + texture));
    }

    private <T extends Block> void tintedCross(RegistryObject<T> block) {
        simpleBlock(block.get(), tintedCross(name(block), name(block)));
    }

    private <T extends Block> void cross(RegistryObject<T> block) {
        simpleBlock(block.get(), models().cross(name(block), tex(block)));
    }

    private <T extends Block> void pottedPlant(RegistryObject<T> block, RegistryObject<T> content) {
        simpleBlock(block.get(), models().singleTexture(name(block), pot, "plant", tex(content)));
    }

    private <T extends Block> void cubeAll(RegistryObject<T> block) {
        Block b = block.get();
        simpleBlock(b, models().cubeAll(name(block), blockTexture(b)));
    }

    private <T extends Block> void column(RegistryObject<T> block) {
        Block b = block.get();
        ResourceLocation top = tex(block, "top");
        ResourceLocation side = tex(block, "side");
        simpleBlock(b, models().cubeColumn(name(block), side, top));
    }
}
