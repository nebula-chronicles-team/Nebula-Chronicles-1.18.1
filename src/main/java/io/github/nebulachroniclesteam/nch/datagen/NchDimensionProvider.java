package io.github.nebulachroniclesteam.nch.datagen;

import io.github.nebulachroniclesteam.nch.NebulaChronicles;
import io.github.nebulachroniclesteam.nch.datagen.base.BaseWorldProvider;
import io.github.nebulachroniclesteam.nch.register.NchBiomes;
import io.github.nebulachroniclesteam.nch.register.NchBlocks;
import io.github.nebulachroniclesteam.nch.register.NchDimensions;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.biome.TerrainShaper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseSettings;
import net.minecraft.world.level.levelgen.StructureSettings;

import java.util.Map;
import java.util.OptionalLong;

public class NchDimensionProvider extends BaseWorldProvider {

    public NchDimensionProvider(DataGenerator generator) {
        super(generator, NebulaChronicles.MOD_ID, true);
    }

    @Override
    public void addDimensionTypes(Map<ResourceLocation, Type> register) {
        register.put(NchDimensions.SILVERBLANC,
                new Type("NebulaChronicles: Silverblanc", DimensionType.create(
                        OptionalLong.empty(),
                        true,
                        false,
                        false,
                        true,
                        1.0,
                        false,
                        false,
                        true,
                        false,
                        true,
                        0,
                        384,
                        384,
                        BlockTags.INFINIBURN_OVERWORLD.getName(),
                        DimensionType.OVERWORLD_EFFECTS,
                        0)));
    }

    @Override
    public void addNoiseSettings(Map<ResourceLocation, NoiseGeneratorSettings> register) {
        register.put(NchDimensions.SILVERBLANC, generatorSettings(
                new StructureSettings(false),
                new NoiseSettings(
                        0,
                        384,
                        samplingSettings(1, 1, 80, 100),
                        noiseSlider(-0.078125, 2, 16),
                        noiseSlider(0.1171875, 3, 0),
                        4,
                        2,
                        false,
                        false,
                        false,
                        TerrainShaper.overworld(false)),
                NchBlocks.SILVERBLANC_STONE.get().defaultBlockState(),
                Blocks.WATER.defaultBlockState().setValue(LiquidBlock.LEVEL, 0),
                sequence().ifBottomY("nch:bedrock_floor", 0, 1, block(Blocks.BEDROCK))
                        .ifBottomY("nch:soft_bedrock_floor", 1, 5, block(NchBlocks.SILVERBLANC_BEDROCK))
                        .build(),
                64,
                false,
                true,
                true,
                true,
                true,
                true));
    }

    @Override
    public void addLevelStems(Map<ResourceLocation, Stem> register) {
        register.put(NchDimensions.SILVERBLANC, new Stem(NchDimensions.SILVERBLANC,
                noiseGenerator(new FixedBiomeSource(NchBiomes.SILVERBLANC), NchDimensions.SILVERBLANC)));
    }
}
