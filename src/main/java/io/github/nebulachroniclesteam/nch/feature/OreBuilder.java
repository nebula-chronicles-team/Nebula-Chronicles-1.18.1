package io.github.nebulachroniclesteam.nch.feature;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author DustW
 **/
public class OreBuilder extends FeatureBuilder<OreConfiguration, OreBuilder> {
    private final List<OreConfiguration.TargetBlockState> targets = new LinkedList<>();
    private float discardChanceOnAirExposure;
    private int size;

    public OreBuilder(String namespace, String name) {
        super(namespace, name);
    }

    public OreBuilder replace(Supplier<Block> replaced) {
        return replace(new BlockMatchTest(replaced.get()), replaced);
    }

    public OreBuilder replace(RuleTest rule, Block replaced) {
        return replace(OreConfiguration.target(rule, replaced.defaultBlockState()));
    }

    public OreBuilder replace(OreConfiguration.TargetBlockState target) {
        targets.add(target);
        return self();
    }

    /**
     * Add a rule to replace existed block to ore
     *
     * @param rule     replace rule
     * @param replaced new block
     * @return this builder
     */
    public OreBuilder replace(RuleTest rule, Supplier<Block> replaced) {
        return replace(rule, replaced.get());
    }

    @Override
    public OreBuilder fromConfiguration(OreConfiguration parent) {
        discardChanceOnAirExposure = parent.discardChanceOnAirExposure;
        size = parent.size;
        return self();
    }

    @Override
    protected OreConfiguration buildConfiguration() {
        return new OreConfiguration(targets, size, discardChanceOnAirExposure);
    }
}
