package io.github.nebulachroniclesteam.nch.datagen.base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.datafixers.util.Function3;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.JsonOps;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.data.info.WorldgenRegistryDumpReport;
import net.minecraft.resources.RegistryWriteOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.CubicSpline;
import net.minecraft.util.ToFloatFunction;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.biome.TerrainShaper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class BaseWorldProvider implements DataProvider {

    private final Gson gson = (new GsonBuilder()).setPrettyPrinting().create();
    private final Logger logger = LogManager.getLogger();

    private final RegistryAccess registryAccess = RegistryAccess.builtin();
    private final DynamicOps<JsonElement> ops = RegistryWriteOps.create(JsonOps.INSTANCE, registryAccess);
    private final Map<Class<? extends BiomeSource>, BiFunction<BiomeSource, JsonElement, JsonElement>> biomeFixers = new HashMap<>();
    private final boolean dump;

    private final DataGenerator generator;
    private final String modid;

    private final DimensionType dummyType = DimensionType.create(OptionalLong.empty(), false, false,
            false, false, 1, false, false,
            false, false, false, 0, 16, 16,
            BlockTags.INFINIBURN_OVERWORLD.getName(), DimensionType.OVERWORLD_EFFECTS, 0);
    private final NoiseGeneratorSettings dummyNoiseSettings = new NoiseGeneratorSettings(new StructureSettings(false),
            new NoiseSettings(0, 0, new NoiseSamplingSettings(1, 1, 1, 1),
                    new NoiseSlider(0, 0, 0),
                    new NoiseSlider(0, 0, 0),
                    1, 1, false, false, false,
                    TerrainShaper.overworld(false)),
            Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState(),
            sequence().ifAbovePreliminarySurface(SurfaceRules.state(Blocks.STONE.defaultBlockState())).build(),
            0, false, false, false, false, false, false);

    public BaseWorldProvider(DataGenerator generator, String modid, boolean dump) {
        this.generator = generator;
        this.modid = modid;
        this.dump = dump;

        addBiomeSourceFixer(FixedBiomeSource.class, (bs, json) -> {
            JsonObject object = json.getAsJsonObject();
            JsonObject bsJson = object.getAsJsonObject("generator").getAsJsonObject("biome_source");
            JsonElement biome = bsJson.get("biome");
            if (biome.isJsonObject()) {
                bsJson.remove("biome");
                bsJson.add("biome", biome.getAsJsonObject().get("forge:registry_name"));
            }
            return json;
        });
    }

    public abstract void addDimensionTypes(Map<ResourceLocation, Type> register);

    public abstract void addLevelStems(Map<ResourceLocation, Stem> register);

    public abstract void addNoiseSettings(Map<ResourceLocation, NoiseGeneratorSettings> register);

    public <T extends BiomeSource> void addBiomeSourceFixer(Class<T> type, BiFunction<BiomeSource, JsonElement, JsonElement> fixer) {
        biomeFixers.put(type, fixer);
    }

    public NoiseSamplingSettings samplingSettings(double xzScale, double yScale, double xzFactor, double yFactor) {
        return new NoiseSamplingSettings(xzScale, yScale, xzFactor, yFactor);
    }

    public NoiseSlider noiseSlider(double target, int size, int offset) {
        return new NoiseSlider(target, size, offset);
    }

    static TerrainShaper terrainShaper(CubicSpline<TerrainShaper.Point> offsetSampler,
                                       CubicSpline<TerrainShaper.Point> factorSampler,
                                       CubicSpline<TerrainShaper.Point> jaggednessSampler) {
        return new TerrainShaper(offsetSampler, factorSampler, jaggednessSampler);
    }

    static <C> CubicSpline<C> cubicSpline(float value) {
        return CubicSpline.constant(value);
    }

    static <C> NamedCubicSplineBuilder<C> cubicSpline(ToFloatFunction<C> coordinate) {
        return new NamedCubicSplineBuilder<>(CubicSpline.builder(coordinate));
    }

    static <C> NamedCubicSplineBuilder<C> cubicSpline(ToFloatFunction<C> coordinate, ToFloatFunction<Float> valueTransformer) {
        return new NamedCubicSplineBuilder<>(CubicSpline.builder(coordinate, valueTransformer));
    }

    public NoiseBasedChunkGenerator noiseGenerator(BiomeSource biomeSource, long seed, NoiseGeneratorSettings settings) {
        return new NoiseBasedChunkGenerator(registryAccess.registryOrThrow(Registry.NOISE_REGISTRY), biomeSource, seed, () -> settings);
    }

    public NoiseBasedChunkGenerator noiseGenerator(BiomeSource biomeSource, long seed, ResourceLocation settings) {
        return new NoiseBasedChunkGenerator2(registryAccess.registryOrThrow(Registry.NOISE_REGISTRY), biomeSource, seed, settings);
    }

    public NoiseBasedChunkGenerator noiseGenerator(BiomeSource biomeSource, NoiseGeneratorSettings settings) {
        return noiseGenerator(biomeSource, 0, settings);
    }

    public NoiseBasedChunkGenerator noiseGenerator(BiomeSource biomeSource, ResourceLocation settings) {
        return noiseGenerator(biomeSource, 0, settings);
    }

    public NoiseGeneratorSettings generatorSettings(StructureSettings structureSettings,
                                                    NoiseSettings noiseSettings,
                                                    BlockState defaultBlock,
                                                    BlockState defaultFluid,
                                                    SurfaceRules.RuleSource surfaceRule,
                                                    int seaLevel,
                                                    boolean disableMobGeneration,
                                                    boolean aquifersEnabled,
                                                    boolean noiseCavesEnabled,
                                                    boolean oreVeinsEnabled,
                                                    boolean noodleCavesEnabled,
                                                    boolean isLegacyAlgorithm) {
        return new NoiseGeneratorSettings(structureSettings, noiseSettings, defaultBlock, defaultFluid, surfaceRule,
                seaLevel, disableMobGeneration, aquifersEnabled, noiseCavesEnabled, oreVeinsEnabled,
                noodleCavesEnabled, isLegacyAlgorithm);
    }

    public SurfaceRules.RuleSource ifTrue(SurfaceRules.ConditionSource ifTrue, SurfaceRules.RuleSource thenRun) {
        return SurfaceRules.ifTrue(ifTrue, thenRun);
    }

    public SurfaceRules.RuleSource block(Block state) {
        return SurfaceRules.state(state.defaultBlockState());
    }

    public SurfaceRules.RuleSource block(Supplier<? extends Block> state) {
        return SurfaceRules.state(state.get().defaultBlockState());
    }

    public RuleSourceSequence sequence() {
        return new RuleSourceSequence();
    }

    public SurfaceRules.ConditionSource verticalGradient(String randomName, VerticalAnchor trueAtAndBelow, VerticalAnchor falseAtAndAbove) {
        return SurfaceRules.verticalGradient(randomName, trueAtAndBelow, falseAtAndAbove);
    }

    @Override
    public void run(HashCache cache) {
        if (dump) {
            new WorldgenRegistryDumpReport(generator).run(cache);
        }

        Path path = generator.getOutputFolder();
        // dimension types
        Map<ResourceLocation, Type> types = new HashMap<>();
        addDimensionTypes(types);
        save(path, cache, Registry.DIMENSION_TYPE_REGISTRY, types, Type::type, DimensionType.DIRECT_CODEC, (type, json) -> {
            if (type.name != null) {
                JsonObject obj = json.getAsJsonObject();
                obj.addProperty("name", type.name);
            }
            return json;
        });
        // noise settings
        Map<ResourceLocation, NoiseGeneratorSettings> settings = new HashMap<>();
        addNoiseSettings(settings);
        save(path, cache, Registry.NOISE_GENERATOR_SETTINGS_REGISTRY, settings, Function.identity(), NoiseGeneratorSettings.DIRECT_CODEC, (_1, _2, json) -> json);
        // stems
        Map<ResourceLocation, Stem> stems = new HashMap<>();
        addLevelStems(stems);
        save(path, cache, Registry.LEVEL_STEM_REGISTRY, stems, stem -> new LevelStem(() -> dummyType, stem.generator, stem.useServerSeed), LevelStem.CODEC, (stem, levelStem, json) -> {
            JsonObject object = json.getAsJsonObject();
            object.addProperty("type", stem.dimension.toString());
            BiomeSource bs = levelStem.generator().getBiomeSource();
            BiFunction<BiomeSource, JsonElement, JsonElement> fixer = biomeFixers.get(bs.getClass());
            if (fixer != null) {
                json = fixer.apply(bs, json);
            }
            if (stem.generator instanceof NoiseBasedChunkGenerator2 noiseGenerator) {
                object.getAsJsonObject("generator").remove("settings");
                object.getAsJsonObject("generator").addProperty("settings", noiseGenerator.settings.toString());
            }
            return json;
        });
    }

    private <T, RT> void save(Path path, HashCache cache, ResourceKey<?> key, Map<ResourceLocation, T> register,
                              Function<T, RT> map, Codec<RT> codec, Function3<T, RT, JsonElement, JsonElement> fixer) {
        Path target = path.resolve("data").resolve(modid).resolve(key.location().getPath());
        register.forEach((name, value) -> {
            RT rt = map.apply(value);
            JsonElement json = codec.encodeStart(ops, rt)
                    .getOrThrow(false, s -> {
                        throw new RuntimeException("Couldn't serialize element " + name + ": " + s);
                    });
            json = fixer.apply(value, rt, json);
            Path output = target.resolve(name.getPath() + ".json");
            save(cache, json, output);
        });
    }

    private <T, RT> void save(Path path, HashCache cache, ResourceKey<?> key, Map<ResourceLocation, T> register,
                              Function<T, RT> map, Codec<RT> codec, BiFunction<T, JsonElement, JsonElement> fixer) {
        save(path, cache, key, register, map, codec, (v, rv, json) -> fixer.apply(v, json));
    }

    private void save(HashCache cache, JsonElement element, Path path) {
        try {
            DataProvider.save(gson, cache, element, path);
        } catch (IOException e) {
            logger.error("Couldn't save element {}", path, e);
        }
    }

    @Override
    public String getName() {
        return "Worldgen: " + modid;
    }

    public record NamedCubicSplineBuilder<C>(CubicSpline.Builder<C> builder) {

        public NamedCubicSplineBuilder<C> addPoint(float location, float value, float derivative) {
            builder.addPoint(location, value, derivative);
            return this;
        }

        public NamedCubicSplineBuilder<C> addPoint(float location, CubicSpline<C> value, float derivative) {
            builder.addPoint(location, value, derivative);
            return this;
        }

        public CubicSpline<C> build() {
            return builder.build();
        }
    }

    public record Type(@Nullable String name, DimensionType type) {

        public Type(DimensionType type) {
            this(null, type);
        }
    }

    public record Stem(ResourceLocation dimension, ChunkGenerator generator, boolean useServerSeed) {

        public Stem(ResourceLocation dimension, ChunkGenerator generator) {
            this(dimension, generator, false);
        }
    }

    public class RuleSourceSequence {

        private final List<SurfaceRules.RuleSource> rules = new ArrayList<>();

        public RuleSourceSequence add(SurfaceRules.RuleSource rule) {
            rules.add(rule);
            return this;
        }

        public RuleSourceSequence ifTure(SurfaceRules.ConditionSource ifTrue, SurfaceRules.RuleSource thenRun) {
            return add(ifTrue(ifTrue, thenRun));
        }

        public RuleSourceSequence ifTure(SurfaceRules.ConditionSource ifTrue, RuleSourceSequence thenRun) {
            return add(ifTrue(ifTrue, thenRun.build()));
        }

        public RuleSourceSequence ifBottomY(String randomName, int min, int max, SurfaceRules.RuleSource thenRun) {
            return ifTure(verticalGradient(randomName, VerticalAnchor.aboveBottom(min), VerticalAnchor.aboveBottom(max)), thenRun);
        }

        public RuleSourceSequence ifAbovePreliminarySurface(SurfaceRules.RuleSource thenRun) {
            return ifTure(SurfaceRules.abovePreliminarySurface(), thenRun);
        }

        public SurfaceRules.RuleSource build() {
            return SurfaceRules.sequence(rules.toArray(SurfaceRules.RuleSource[]::new));
        }
    }

    class NoiseBasedChunkGenerator2 extends NoiseBasedChunkGenerator {

        final ResourceLocation settings;

        public NoiseBasedChunkGenerator2(Registry<NormalNoise.NoiseParameters> p_188609_, BiomeSource p_188610_, long p_188611_, ResourceLocation settings) {
            super(p_188609_, p_188610_, p_188611_, () -> dummyNoiseSettings);
            this.settings = settings;
        }
    }
}
