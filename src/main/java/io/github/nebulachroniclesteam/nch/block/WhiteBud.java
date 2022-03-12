package io.github.nebulachroniclesteam.nch.block;

import io.github.nebulachroniclesteam.nch.NebulaChronicles;
import io.github.nebulachroniclesteam.nch.register.NchBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.Tags;

public class WhiteBud extends BushBlock {

    protected static final VoxelShape SHAPE = Block.box(1, 0, 1, 15, 6, 15);

    // create a new type to avoid plant to other block
    private static final PlantType type = PlantType.get(NebulaChronicles.MOD_ID + "_white_bud");

    public WhiteBud() {
        super(Properties.copy(Blocks.GRASS).noDrops());
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.is(Tags.Blocks.SAND) || pState.is(NchBlocks.MOSS_SILVERBLANC_STONE.get());
    }

    @Override
    public PlantType getPlantType(BlockGetter world, BlockPos pos) {
        return type;
    }
}
