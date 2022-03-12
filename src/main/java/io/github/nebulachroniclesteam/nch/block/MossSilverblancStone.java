package io.github.nebulachroniclesteam.nch.block;


import io.github.nebulachroniclesteam.nch.register.NchBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

public class MossSilverblancStone extends Block {

    public MossSilverblancStone() {
        super(Properties.copy(Blocks.MYCELIUM)
                .color(MaterialColor.WARPED_NYLIUM)
                .strength(1, 3)
                .lootFrom(NchBlocks.SILVERBLANC_STONE));
    }

    @Override
    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean pIsMoving) {
        super.neighborChanged(pState, pLevel, pPos, pBlock, pFromPos, pIsMoving);
        if (!pIsMoving) {
            BlockPos above = pPos.above();
            BlockState bs = pLevel.getBlockState(above);
            if (!bs.is(NchBlocks.SILVERBLANC_STONE.get()) && !bs.isAir() && !bs.hasBlockEntity() && bs.canOcclude() && bs.isCollisionShapeFullBlock(pLevel, pPos)) {
                System.out.println(bs);
                pLevel.setBlock(above, NchBlocks.SILVERBLANC_STONE.get().defaultBlockState(), 2);
            }
        }
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        PlantType plantType = plantable.getPlantType(world, pos.relative(facing));
        return !(PlantType.WATER.equals(plantType));
    }

    @Override
    public boolean isFertile(BlockState state, BlockGetter world, BlockPos pos) {
        return true;
    }
}
