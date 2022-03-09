package io.github.nebulachroniclesteam.nch.datagen;

import io.github.nebulachroniclesteam.nch.NebulaChronicles;
import io.github.nebulachroniclesteam.nch.block.WhiteBudBush;
import io.github.nebulachroniclesteam.nch.register.NchBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
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
                .modelFile(tintedCross(name(NchBlocks.WHITE_BUD_BUSH) + "_0", "white_bud_bush_0")).addModel()
                .partialState().with(WhiteBudBush.AGE, 1).modelForState()
                .modelFile(tintedCross(name(NchBlocks.WHITE_BUD_BUSH) + "_1", "white_bud_bush_1")).addModel()
                .partialState().with(WhiteBudBush.AGE, 2).modelForState()
                .modelFile(tintedCross(name(NchBlocks.WHITE_BUD_BUSH) + "_2", "white_bud_bush_2")).addModel();
    }

    private String name(RegistryObject<?> block) {
        return block.getId().getPath();
    }

    private BlockModelBuilder tintedCross(String name, String texture) {
        return models().singleTexture(name, tintedCross, "cross", modLoc("blocks/" + texture));
    }
}
