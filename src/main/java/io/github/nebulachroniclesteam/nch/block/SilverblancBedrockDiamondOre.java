package io.github.nebulachroniclesteam.nch.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class SilverblancBedrockDiamondOre extends Block {

    public SilverblancBedrockDiamondOre() {
        super(Properties.copy(Blocks.DIAMOND_ORE)
                .lootFrom(() -> Blocks.DIAMOND_ORE)
                .strength(3, 6));
    }
}
