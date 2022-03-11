package io.github.nebulachroniclesteam.nch.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class SilverblancGoldOre extends Block {

    public SilverblancGoldOre() {
        super(Properties.copy(Blocks.GOLD_ORE)
                .strength(2, 6));
    }
}
