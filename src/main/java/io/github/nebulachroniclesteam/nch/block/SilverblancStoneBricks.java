package io.github.nebulachroniclesteam.nch.block;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MaterialColor;

public class SilverblancStoneBricks extends Block {
    public SilverblancStoneBricks() {
        super(Properties.copy(Blocks.BRICKS)
                .color(MaterialColor.QUARTZ)
                .strength(1.5f, 6));
    }
}
