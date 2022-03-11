package io.github.nebulachroniclesteam.nch.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SandBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MaterialColor;

public class CosmicSand extends SandBlock {

    public CosmicSand() {
        // MaterialColor.QUARTZ
        super(16776437, Properties.copy(Blocks.SAND)
                .color(MaterialColor.QUARTZ)
                .strength(0.8f, 1)
                .sound(SoundType.SAND));
    }
}
