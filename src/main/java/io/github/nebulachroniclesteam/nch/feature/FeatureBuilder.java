package io.github.nebulachroniclesteam.nch.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import org.checkerframework.checker.units.qual.C;

import java.util.LinkedList;
import java.util.List;

/**
 * @author DustW
 **/
public abstract class FeatureBuilder<C extends FeatureConfiguration, SELF extends FeatureBuilder<C, SELF>> {
    protected final List<PlacementModifier> modifiers = new LinkedList<>();

    String name;

    public FeatureBuilder(String namespace, String name) {
        this.name = namespace + ":" + name;
    }

    public SELF fromModifier(PlacedFeature parent) {
        modifiers.addAll(parent.placement());
        return self();
    }

    public SELF replaceModifier(PlacementModifier modifier) {
        return replaceModifier(modifier.getClass(), modifier);
    }

    public SELF replaceModifier(Class<?> type, PlacementModifier modifier) {
        modifiers.removeIf(type::isInstance);
        modifiers.add(modifier);
        return self();
    }

    public abstract SELF fromConfiguration(C parent);
    protected abstract OreConfiguration buildConfiguration();

    public Holder<PlacedFeature> build() {
        Holder<ConfiguredFeature<OreConfiguration, ?>> config =
                FeatureUtils.register(name + "_config", Feature.ORE, buildConfiguration());
        Holder<PlacedFeature> feature = PlacementUtils.register(name, config, modifiers);
        return feature;
    }

    protected final SELF self() {
        return (SELF) this;
    }
}
