package io.github.nebulachroniclesteam.nch.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MaterialColor;

public class SilverblancStone extends Block {

    public SilverblancStone() {
        super(Properties.copy(Blocks.STONE)
                .color(MaterialColor.COLOR_LIGHT_GRAY)
                .strength(1, 3));
    }
}
