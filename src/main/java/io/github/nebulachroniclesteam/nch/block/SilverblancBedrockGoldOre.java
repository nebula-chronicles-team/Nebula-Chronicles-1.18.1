package io.github.nebulachroniclesteam.nch.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SilverblancBedrockGoldOre extends Block {

    public SilverblancBedrockGoldOre() {
        super(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).strength(3, 6));
    }
}
