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

// todo by lq2007
//   change block to NchBlocks.SILVERBLANC_STONE
//   grow crops and trees
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
        System.out.println("pState=" + pState + ", pPos=" + pPos + ", pBlock=" + pBlock + ", pFrom=" + pFromPos + ", pMoving=" + pIsMoving);
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        PlantType plantType = plantable.getPlantType(world, pos.relative(facing));
        return !(PlantType.WATER.equals(plantType));
    }
}
