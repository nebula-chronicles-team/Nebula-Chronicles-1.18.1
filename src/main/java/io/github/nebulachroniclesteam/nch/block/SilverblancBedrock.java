package io.github.nebulachroniclesteam.nch.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SilverblancBedrock extends Block {

    public SilverblancBedrock() {
        super(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2, 6));
    }
}
