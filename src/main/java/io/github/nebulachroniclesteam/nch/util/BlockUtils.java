package io.github.nebulachroniclesteam.nch.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BlockUtils {

    /**
     * 替换 BlockState 并恢复 BlockEntity，当方块存在 BlockEntity 时使用
     */
    public static void setBlock(BlockState newState, BlockPos pos, Level level) {
        BlockEntity be = level.getBlockEntity(pos);
        level.setBlock(pos, newState, 2);
        if (be != null && be.isRemoved()) {
            BlockEntity newBe = level.getBlockEntity(pos);
            if (newBe != null && newBe.getClass() == be.getClass()) {
                be.clearRemoved();
                level.setBlockEntity(be);
            }
        }
    }
}
