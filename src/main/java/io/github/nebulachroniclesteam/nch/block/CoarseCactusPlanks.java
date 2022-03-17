package io.github.nebulachroniclesteam.nch.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MaterialColor;

public class CoarseCactusPlanks extends Block {

    public CoarseCactusPlanks() {
        super(Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_LIGHT_BLUE));
    }
}
