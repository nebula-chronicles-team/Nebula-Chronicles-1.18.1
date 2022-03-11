package io.github.nebulachroniclesteam.nch.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MaterialColor;

public class CosmicSandstone extends Block {

    public CosmicSandstone() {
        super(Properties.copy(Blocks.SANDSTONE)
                .color(MaterialColor.QUARTZ)
                .strength(1, 2)
                .sound(SoundType.STONE));
    }
}
