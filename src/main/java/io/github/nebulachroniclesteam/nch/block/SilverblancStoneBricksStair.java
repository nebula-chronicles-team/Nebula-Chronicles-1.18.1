package io.github.nebulachroniclesteam.nch.block;

import io.github.nebulachroniclesteam.nch.register.NchBlocks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;

public class SilverblancStoneBricksStair extends StairBlock {

    public SilverblancStoneBricksStair() {
        super(() -> NchBlocks.SILVERBLANC_STONE_BRICKS.get().defaultBlockState(), Properties.copy(Blocks.STONE_STAIRS)
                .strength(1.5f, 6));
    }
}
