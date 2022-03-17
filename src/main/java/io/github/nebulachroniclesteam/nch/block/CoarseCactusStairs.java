package io.github.nebulachroniclesteam.nch.block;

import io.github.nebulachroniclesteam.nch.register.NchBlocks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;

public class CoarseCactusStairs extends StairBlock {

    public CoarseCactusStairs() {
        super(() -> NchBlocks.COARSE_CACTUS_PLANKS.get().defaultBlockState(), Properties.copy(Blocks.OAK_STAIRS));
    }
}
