package io.github.nebulachroniclesteam.nch.datagen;

import io.github.nebulachroniclesteam.nch.NebulaChronicles;
import io.github.nebulachroniclesteam.nch.block.WhiteBudBush;
import io.github.nebulachroniclesteam.nch.register.NchBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class NchBlockStateProvider extends BlockStateProvider {
    private final ResourceLocation tintedCross = mcLoc(ModelProvider.BLOCK_FOLDER + "/tinted_cross");

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
        simpleBlock(NchBlocks.WHITE_BUD.get(), tintedCross(name(NchBlocks.WHITE_BUD), "white_bud"));

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

    private BlockModelBuilder tintedCross(String name, String texture) {
        return models().singleTexture(name, tintedCross, "cross", modLoc(ModelProvider.BLOCK_FOLDER + "/" + texture));
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
