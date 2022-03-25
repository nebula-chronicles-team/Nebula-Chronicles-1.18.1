package io.github.nebulachroniclesteam.nch.feature;

import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedList;
import java.util.List;

/**
 * A builder for feature
 * <p>This used to build placed feature</p>
 */
public abstract class BaseFeatureBuilder<C extends FeatureConfiguration, SELF extends BaseFeatureBuilder<C, SELF>> {

    protected final Feature<C> feature;
    protected final List<PlacementModifier> modifiers = new LinkedList<>();

    private volatile PlacedFeature result = null;
    private volatile ConfiguredFeature<C, ?> configured = null;

    private volatile boolean isConfiguredRegistered = false, isFeatureRegistered = false;

    public BaseFeatureBuilder(Feature<C> feature) {
        this.feature = feature;
    }

    /**
     * A modifier can set generated base position by range, times, etc...
     *
     * @param modifier generate modifier
     * @return this builder
     */
    public SELF addModifier(PlacementModifier modifier) {
        modifiers.add(modifier);
        return getThis();
    }

    /**
     * Add a modifier and remove same type of other modifiers
     *
     * @param modifier generate modifier
     * @return this builder
     */
    public SELF replaceModifier(PlacementModifier modifier) {
        return replaceModifier(modifier.getClass(), modifier);
    }

    /**
     * Add a modifier and remove same type of other modifiers
     *
     * @param type     type
     * @param modifier generate modifier
     * @return this builder
     */
    public SELF replaceModifier(Class<?> type, PlacementModifier modifier) {
        modifiers.removeIf(type::isInstance);
        modifiers.add(modifier);
        return getThis();
    }

    /**
     * Copy modifiers from another feature
     *
     * @param parent base feature
     * @return this builder
     */
    public SELF fromModifier(PlacedFeature parent) {
        modifiers.addAll(parent.getPlacement());
        return getThis();
    }

    /**
     * Create a configuration base on parent
     *
     * @param parent base configuration
     * @return this builder
     */
    public abstract SELF fromConfiguration(C parent);

    /**
     * Create a configuration
     *
     * @return configuration
     */
    protected abstract C buildConfiguration();

    /**
     * Create {@link ConfiguredFeature} from the builder.
     * <p>Note: Not assure that the configured feature is registered in {@link FeatureUtils}.</p>
     *
     * @return configured feature, not ensure registered
     */
    public ConfiguredFeature<C, ?> configured() {
        if (configured == null) {
            C config = buildConfiguration();
            configured = feature.configured(config);
        }
        return configured;
    }

    /**
     * Create a {@link ConfiguredFeature} and register it.
     *
     * @param name default name of configured feature
     * @return a registered configured feature
     */
    public ConfiguredFeature<C, ?> configured(String name) {
        if (!isConfiguredRegistered) {
            FeatureUtils.register(name, configured());
            isConfiguredRegistered = true;
        }
        return configured;
    }

    /**
     * Create a {@link ConfiguredFeature} and register it.
     *
     * @param modid mod id
     * @param name  name
     * @return a registered configured feature
     */
    public ConfiguredFeature<C, ?> configured(String modid, String name) {
        return configured(modid + ":" + name);
    }

    /**
     * Create a {@link ConfiguredFeature} and register it.
     *
     * @param id name
     * @return a registered configured feature
     */
    public ConfiguredFeature<C, ?> configured(ResourceLocation id) {
        return configured(id.toString());
    }

    /**
     * Create a {@link ConfiguredFeature} and register it.
     *
     * @param buildFor get name from it
     * @return a registered configured feature
     */
    public ConfiguredFeature<C, ?> configured(RegistryObject<?> buildFor) {
        return configured(buildFor.getId());
    }

    /**
     * Create {@link PlacedFeature} from the builder.
     * <p>Note: Not assure that the configured feature or placed feature is registered in {@link PlacementUtils}.</p>
     *
     * @return placed feature, not ensure registered
     */
    public PlacedFeature build() {
        if (result == null) {
            synchronized (this) {
                if (result == null) {
                    result = configured().placed(modifiers);
                }
            }
        }
        return result;
    }

    /**
     * Create a {@link PlacedFeature} and register it.
     *
     * @param name default name of configured feature and placed feature
     * @return a registered placed feature
     */
    public PlacedFeature build(String name) {
        synchronized (this) {
            if (!isConfiguredRegistered) {
                FeatureUtils.register(name, configured());
                isConfiguredRegistered = true;
            }
            if (!isFeatureRegistered) {
                PlacementUtils.register(name, build());
                isFeatureRegistered = true;
            }
        }
        return result;
    }

    /**
     * Create a {@link PlacedFeature} and register it, name is modid:name
     *
     * @param modid mod id
     * @param name  name
     * @return a registered placed feature
     */
    public PlacedFeature build(String modid, String name) {
        return build(modid + ":" + name);
    }

    /**
     * Create a {@link PlacedFeature} and register it, name is modid:name
     *
     * @param id name
     * @return a registered placed feature
     */
    public PlacedFeature build(ResourceLocation id) {
        return build(id.toString());
    }

    /**
     * Create a {@link PlacedFeature} and register it, name is builderFor.id
     *
     * @param buildFor get name from it
     * @return a registered placed feature
     */
    public PlacedFeature build(RegistryObject<?> buildFor) {
        return build(buildFor.getId());
    }

    @SuppressWarnings("unchecked")
    private SELF getThis() {
        return (SELF) this;
    }
}
