package io.github.nebulachroniclesteam.nch.register;

import io.github.nebulachroniclesteam.nch.NebulaChronicles;
import io.github.nebulachroniclesteam.nch.feature.OreBuilder;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.util.Lazy;

public class NchFeatures {

    private static final HeightRangePlacement HEIGHT_NORMAL = HeightRangePlacement.triangle(VerticalAnchor.absolute(20), VerticalAnchor.absolute(40));
    private static final HeightRangePlacement HEIGHT_LOWER = HeightRangePlacement.triangle(VerticalAnchor.absolute(20), VerticalAnchor.absolute(25));
    private static final HeightRangePlacement HEIGHT_BEDROCK = HeightRangePlacement.triangle(VerticalAnchor.absolute(1), VerticalAnchor.absolute(20));

    // ores

    public static final Lazy<Holder<PlacedFeature>> ORE_SILVERBLANC_IRON = Lazy.of(
            () -> new OreBuilder(NebulaChronicles.MOD_ID, "ore_silverblanc_iron")
                    .fromModifier(OrePlacements.ORE_IRON_MIDDLE.value())
                    .fromConfiguration(OreFeatures.ORE_IRON.value().config())
                    .replaceModifier(HEIGHT_NORMAL)
                    .replace(NchBlocks.SILVERBLANC_IRON_ORE)
                    .build());

    public static final Lazy<Holder<PlacedFeature>> ORE_SILVERBLANC_GOLD = Lazy.of(
            () -> new OreBuilder(NebulaChronicles.MOD_ID, "ore_silverblanc_gold")
                    .fromModifier(OrePlacements.ORE_GOLD.value())
                    .fromConfiguration(OreFeatures.ORE_GOLD.value().config())
                    .replaceModifier(HEIGHT_NORMAL)
                    .replace(NchBlocks.SILVERBLANC_GOLD_ORE)
                    .build());

    public static final Lazy<Holder<PlacedFeature>> ORE_SILVERBLANC_TUNGSTEN = Lazy.of(
            () -> new OreBuilder(NebulaChronicles.MOD_ID, "ore_silverblanc_tungsten")
                    .fromModifier(OrePlacements.ORE_DIAMOND.value())
                    .fromConfiguration(OreFeatures.ORE_DIAMOND_LARGE.value().config())
                    .replaceModifier(HEIGHT_LOWER)
                    .replace(NchBlocks.SILVERBLANC_BLACK_TUNGSTEN_ORE)
                    .build());

    public static final Lazy<Holder<PlacedFeature>> ORE_SILVERBLANC_IRON_BEDROCK = Lazy.of(
            () -> new OreBuilder(NebulaChronicles.MOD_ID, "ore_silverblanc_iron_bedrock")
                    .fromModifier(OrePlacements.ORE_IRON_MIDDLE.value())
                    .fromConfiguration(OreFeatures.ORE_IRON.value().config())
                    .replaceModifier(HEIGHT_BEDROCK)
                    .replace(NchBlocks.SILVERBLANC_BEDROCK_IRON_ORE)
                    .build());

    public static final Lazy<Holder<PlacedFeature>> ORE_SILVERBLANC_GOLD_BEDROCK = Lazy.of(
            () -> new OreBuilder(NebulaChronicles.MOD_ID, "ore_silverblanc_gold_bedrock")
                    .fromModifier(OrePlacements.ORE_GOLD.value())
                    .fromConfiguration(OreFeatures.ORE_GOLD_BURIED.value().config())
                    .replaceModifier(HEIGHT_BEDROCK)
                    .replace(NchBlocks.SILVERBLANC_BEDROCK_GOLD_ORE)
                    .build());

    public static final Lazy<Holder<PlacedFeature>> ORE_SILVERBLANC_TUNGSTEN_BEDROCK = Lazy.of(
            () -> new OreBuilder(NebulaChronicles.MOD_ID, "ore_silverblanc_tungsten_bedrock")
                    .fromModifier(OrePlacements.ORE_DIAMOND.value())
                    .fromConfiguration(OreFeatures.ORE_DIAMOND_BURIED.value().config())
                    .replaceModifier(HEIGHT_BEDROCK)
                    .replace(NchBlocks.SILVERBLANC_BEDROCK_BLACK_TUNGSTEN_ORE)
                    .build());

    public static final Lazy<Holder<PlacedFeature>> ORE_SILVERBLANC_DIAMOND_BEDROCK = Lazy.of(
            () -> new OreBuilder(NebulaChronicles.MOD_ID, "ore_silverblanc_diamond_bedrock")
                    .fromModifier(OrePlacements.ORE_DIAMOND.value())
                    .fromConfiguration(OreFeatures.ORE_DIAMOND_BURIED.value().config())
                    .replaceModifier(HEIGHT_BEDROCK)
                    .replace(NchBlocks.SILVERBLANC_BEDROCK_DIAMOND_ORE)
                    .build());

    // natures

    public static final Holder<PlacedFeature> SILVERBLANC_MONSTER_ROOM = PlacementUtils
            .register("silverblanc_monster_room",
                    CaveFeatures.MONSTER_ROOM,
                    CountPlacement.of(10),
                    InSquarePlacement.spread(),
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(2), VerticalAnchor.top()));

    public static final Holder<PlacedFeature> SILVERBLANC_MONSTER_ROOM_DEEP = PlacementUtils
            .register("silverblanc_monster_room_deep", CaveFeatures.MONSTER_ROOM,
                    CountPlacement.of(10),
                    InSquarePlacement.spread(),
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(10), VerticalAnchor.absolute(3)));
}
