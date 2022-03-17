package io.github.nebulachroniclesteam.nch.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LanternBerriesPlant extends BushBlock {

    // 13 * 15 * 13
    private static final VoxelShape SHAPE = box(1.5f, 0, 1.5f, 14.5f, 15, 14.5f);

    public LanternBerriesPlant() {
        super(Properties.copy(Blocks.BLUE_ORCHID));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
}
