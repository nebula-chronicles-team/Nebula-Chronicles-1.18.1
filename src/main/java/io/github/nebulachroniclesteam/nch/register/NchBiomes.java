package io.github.nebulachroniclesteam.nch.register;

import io.github.nebulachroniclesteam.nch.NebulaChronicles;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NchBiomes {

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, NebulaChronicles.MOD_ID);

    // https://minecraft.fandom.com/zh/wiki/%E8%87%AA%E5%AE%9A%E4%B9%89%E4%B8%96%E7%95%8C%E7%94%9F%E6%88%90/biome
    public static final RegistryObject<Biome> SILVERBLANC = BIOMES.register("silverblanc", () -> new Biome.BiomeBuilder()
            .precipitation(Biome.Precipitation.NONE)
            .biomeCategory(Biome.BiomeCategory.PLAINS)
            .temperature(0.8f) // 0.15-snow, 0.95-rain, 1.0-dry
            .temperatureAdjustment(Biome.TemperatureModifier.NONE)
            .downfall(0.4f)
            .mobSpawnSettings(new MobSpawnSettings.Builder()
                    .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 1, 5, 50))
                    .addMobCharge(EntityType.PIGLIN, 0.1, 1)
                    .build())
            .specialEffects(new BiomeSpecialEffects.Builder()
                    .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                    .fogColor(0xB0F4AA)
                    .skyColor(calculateSkyColor(1.0f))
                    .waterColor(0x545953)
                    .waterFogColor(0x839e7b)
                    .foliageColorOverride(0xbeebbc)
                    .grassColorOverride(0x809e83)
                    .build())
            .generationSettings(new BiomeGenerationSettings.Builder()
                    .addFeature(GenerationStep.Decoration.UNDERGROUND_STRUCTURES, NchFeatures.SILVERBLANC_MONSTER_ROOM)
                    .addFeature(GenerationStep.Decoration.UNDERGROUND_STRUCTURES, NchFeatures.SILVERBLANC_MONSTER_ROOM_DEEP)
                    .addFeature(GenerationStep.Decoration.FLUID_SPRINGS, MiscOverworldPlacements.SPRING_WATER)
                    .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, NchFeatures.ORE_SILVERBLANC_IRON.get())
                    .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, NchFeatures.ORE_SILVERBLANC_GOLD.get())
                    .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, NchFeatures.ORE_SILVERBLANC_TUNGSTEN.get())
                    .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, NchFeatures.ORE_SILVERBLANC_IRON_BEDROCK.get())
                    .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, NchFeatures.ORE_SILVERBLANC_GOLD_BEDROCK.get())
                    .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, NchFeatures.ORE_SILVERBLANC_DIAMOND_BEDROCK.get())
                    .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, NchFeatures.ORE_SILVERBLANC_TUNGSTEN_BEDROCK.get())
                    .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
                    .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND)
                    .addCarver(GenerationStep.Carving.AIR, Carvers.CANYON)
                    .build())
            .build());

    private static int calculateSkyColor(float f) {
        float $$1 = Mth.clamp(f / 3.0F, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }
}
