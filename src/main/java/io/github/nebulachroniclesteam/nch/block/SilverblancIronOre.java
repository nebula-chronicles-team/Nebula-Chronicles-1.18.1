package io.github.nebulachroniclesteam.nch.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class SilverblancIronOre extends Block {
    public SilverblancIronOre() {
        super(Properties.copy(Blocks.IRON_BLOCK)
                .strength(2, 6));
    }
}
