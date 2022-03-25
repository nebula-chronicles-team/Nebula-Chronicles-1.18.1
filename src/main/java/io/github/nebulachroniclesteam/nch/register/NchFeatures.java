package io.github.nebulachroniclesteam.nch.register;

import io.github.nebulachroniclesteam.nch.feature.OreFeatureBuilder;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.common.util.Lazy;

public class NchFeatures {

    private static final HeightRangePlacement HEIGHT_NORMAL = HeightRangePlacement.triangle(VerticalAnchor.absolute(20), VerticalAnchor.absolute(40));
    private static final HeightRangePlacement HEIGHT_LOWER = HeightRangePlacement.triangle(VerticalAnchor.absolute(20), VerticalAnchor.absolute(25));
    private static final HeightRangePlacement HEIGHT_BEDROCK = HeightRangePlacement.triangle(VerticalAnchor.absolute(1), VerticalAnchor.absolute(20));

    // ores

    public static final Lazy<OreFeatureBuilder> ORE_SILVERBLANC_IRON = Lazy.of(() -> new OreFeatureBuilder()
            .fromModifier(OrePlacements.ORE_IRON_MIDDLE)
            .fromConfiguration((OreConfiguration) OreFeatures.ORE_IRON.config)
            .replaceModifier(HEIGHT_NORMAL)
            .addReplaceRule(new BlockMatchTest(NchBlocks.SILVERBLANC_STONE.get()), NchBlocks.SILVERBLANC_IRON_ORE));

    public static final Lazy<OreFeatureBuilder> ORE_SILVERBLANC_GOLD = Lazy.of(() -> new OreFeatureBuilder()
            .fromModifier(OrePlacements.ORE_GOLD)
            .fromConfiguration((OreConfiguration) OreFeatures.ORE_GOLD.config)
            .replaceModifier(HEIGHT_NORMAL)
            .addReplaceRule(new BlockMatchTest(NchBlocks.SILVERBLANC_STONE.get()), NchBlocks.SILVERBLANC_GOLD_ORE));

    public static final Lazy<OreFeatureBuilder> ORE_SILVERBLANC_TUNGSTEN = Lazy.of(() -> new OreFeatureBuilder()
            .fromModifier(OrePlacements.ORE_DIAMOND)
            .fromConfiguration((OreConfiguration) OreFeatures.ORE_DIAMOND_LARGE.config)
            .replaceModifier(HEIGHT_LOWER)
            .addReplaceRule(new BlockMatchTest(NchBlocks.SILVERBLANC_STONE.get()), NchBlocks.SILVERBLANC_BLACK_TUNGSTEN_ORE));

    public static final Lazy<OreFeatureBuilder> ORE_SILVERBLANC_IRON_BEDROCK = Lazy.of(() -> new OreFeatureBuilder()
            .fromModifier(OrePlacements.ORE_IRON_MIDDLE)
            .fromConfiguration((OreConfiguration) OreFeatures.ORE_IRON.config)
            .replaceModifier(HEIGHT_BEDROCK)
            .addReplaceRule(new BlockMatchTest(NchBlocks.SILVERBLANC_BEDROCK.get()), NchBlocks.SILVERBLANC_BEDROCK_IRON_ORE));

    public static final Lazy<OreFeatureBuilder> ORE_SILVERBLANC_GOLD_BEDROCK = Lazy.of(() -> new OreFeatureBuilder()
            .fromModifier(OrePlacements.ORE_GOLD)
            .fromConfiguration((OreConfiguration) OreFeatures.ORE_GOLD_BURIED.config)
            .replaceModifier(HEIGHT_BEDROCK)
            .addReplaceRule(new BlockMatchTest(NchBlocks.SILVERBLANC_BEDROCK.get()), NchBlocks.SILVERBLANC_BEDROCK_GOLD_ORE));

    public static final Lazy<OreFeatureBuilder> ORE_SILVERBLANC_TUNGSTEN_BEDROCK = Lazy.of(() -> new OreFeatureBuilder()
            .fromModifier(OrePlacements.ORE_DIAMOND)
            .fromConfiguration((OreConfiguration) OreFeatures.ORE_DIAMOND_BURIED.config)
            .replaceModifier(HEIGHT_BEDROCK)
            .addReplaceRule(new BlockMatchTest(NchBlocks.SILVERBLANC_BEDROCK.get()), NchBlocks.SILVERBLANC_BEDROCK_BLACK_TUNGSTEN_ORE));

    public static final Lazy<OreFeatureBuilder> ORE_SILVERBLANC_DIAMOND_BEDROCK = Lazy.of(() -> new OreFeatureBuilder()
            .fromModifier(OrePlacements.ORE_DIAMOND)
            .fromConfiguration((OreConfiguration) OreFeatures.ORE_DIAMOND_BURIED.config)
            .replaceModifier(HEIGHT_BEDROCK)
            .addReplaceRule(new BlockMatchTest(NchBlocks.SILVERBLANC_BEDROCK.get()), NchBlocks.SILVERBLANC_BEDROCK_DIAMOND_ORE));

    // natures

    public static final PlacedFeature SILVERBLANC_MONSTER_ROOM = PlacementUtils.register("silverblanc_monster_room", CaveFeatures.MONSTER_ROOM.placed(
            CountPlacement.of(10),
            InSquarePlacement.spread(),
            HeightRangePlacement.uniform(VerticalAnchor.absolute(2), VerticalAnchor.top())));

    public static final PlacedFeature SILVERBLANC_MONSTER_ROOM_DEEP = PlacementUtils.register("silverblanc_monster_room_deep", CaveFeatures.MONSTER_ROOM.placed(
            CountPlacement.of(10),
            InSquarePlacement.spread(),
            HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(10), VerticalAnchor.absolute(3))));
}
