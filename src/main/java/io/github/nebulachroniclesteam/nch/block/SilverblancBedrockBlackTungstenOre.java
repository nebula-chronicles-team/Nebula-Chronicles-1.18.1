package io.github.nebulachroniclesteam.nch.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class SilverblancBedrockBlackTungstenOre extends Block {

    public SilverblancBedrockBlackTungstenOre() {
        super(Properties.copy(Blocks.IRON_ORE).strength(3, 6));
    }
}
