package io.github.nebulachroniclesteam.nch.block;

import io.github.nebulachroniclesteam.nch.blockentity.CoarseCactusBlockEntity;
import io.github.nebulachroniclesteam.nch.register.NchBlocks;
import io.github.nebulachroniclesteam.nch.util.BlockUtils;
import io.github.nebulachroniclesteam.nch.util.CrossBlocks;
import io.github.nebulachroniclesteam.nch.util.StreamUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CoarseCactus extends PipeBlock implements EntityBlock, BlockEntityTicker<CoarseCactusBlockEntity> {

    public CoarseCactus() {
        super(0.5f, Properties.of(Material.CACTUS, MaterialColor.COLOR_GREEN)
                .sound(SoundType.WOOL)
                .noOcclusion()
                .strength(0.5f, 0.5f));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new CoarseCactusBlockEntity(pPos, pState);
    }

    @Nullable
    @Override
    @SuppressWarnings("unchecked")
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return (BlockEntityTicker<T>) this;
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
        return super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
    }

    @Override
    public void tick(Level pLevel, BlockPos pPos, BlockState pState, CoarseCactusBlockEntity cactus) {
        if (!pLevel.isClientSide) {
            CrossBlocks blocks = new CrossBlocks(pLevel, pPos);
            if (blocks.is(Direction.DOWN, NchBlocks.COSMIC_SAND) || blocks.is(cactus.getParent(), this)) {
                if (cactus.nextAge()) {
                    // grow up
                    if (blocks.isAir(Direction.UP) && cactus.canGrowUp()) {
                        // 下方为太空砂，有50%概率拔高
                        // 下方为太空砂，且年龄为4，必定拔高
                        boolean shouldGrow = blocks.is(Direction.DOWN, NchBlocks.COSMIC_SAND)
                                && (probability(pLevel, 0.5) || cactus.getAge() == 4);
                        // 下方第一格为仙人掌，第二格为太空砂，有25%概率拔高
                        if (!shouldGrow && probability(pLevel, 0.25)
                                && blocks.is(Direction.DOWN, this)
                                && blocks.is(Direction.DOWN, 2, NchBlocks.COSMIC_SAND)) {
                            shouldGrow = true;
                        }
                        // 下方第一二格为仙人掌，第三格为太空砂，有5%概率拔高
                        if (!shouldGrow && probability(pLevel, 0.05)
                                && blocks.is(Direction.DOWN, this)
                                && blocks.is(Direction.DOWN, 2, this)
                                && blocks.is(Direction.DOWN, 3, NchBlocks.COSMIC_SAND)) {
                            shouldGrow = true;
                        }
                        // 主干有10%概率拔高
                        if (!shouldGrow && cactus.isTrunk() && probability(pLevel, 0.1)) {
                            shouldGrow = true;
                        }
                        // 下方第三格为仙人掌，不会拔高
                        if (!shouldGrow && !blocks.is(Direction.DOWN, 3, this)) {
                            shouldGrow = true;
                        }
                        if (shouldGrow) {
                            growTo(pLevel, pPos, Direction.UP, cactus);
                            return;
                        }
                    }
                    // fork
                    if (cactus.canFork()) {
                        boolean shouldFork;
                        if (cactus.isTrunk()) {
                            if (blocks.is(Direction.DOWN, NchBlocks.COSMIC_SAND)) {
                                // 下方是太空砂，不会分叉
                                shouldFork = false;
                            } else {
                                // 下方是仙人掌，有%（（8*年龄）+5）的概率分叉
                                shouldFork = blocks.is(Direction.DOWN, this) && probability(pLevel, (8 * cactus.getAge() + 5) / 100f);
                            }
                        } else {
                            // 不是主干，恒有5%概率分叉
                            shouldFork = probability(pLevel, 0.05);
                        }
                        if (shouldFork) {
                            cactus.forkDirections()
                                    .filter(blocks::isAir)
                                    .filter(d -> blocks.relative(d).nearby(this) <= 1)
                                    .collect(StreamUtils.random(pLevel.random))
                                    .ifPresent(direction -> {
                                        growTo(pLevel, pPos, direction, cactus);
                                        if (cactus.isTrunk()) {
                                            cactus.markGrownTag(direction);
                                        }
                                    });
                        }
                    }
                }
            } else {
                // drop self
                popResource(pLevel, pPos, new ItemStack(this));
                pLevel.removeBlock(pPos, false);
            }
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN);
    }

    @Override
    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean pIsMoving) {
        super.neighborChanged(pState, pLevel, pPos, pBlock, pFromPos, pIsMoving);
        CoarseCactusBlockEntity cactus = (CoarseCactusBlockEntity) pLevel.getBlockEntity(pPos);
        assert cactus != null;
        CrossBlocks blocks = new CrossBlocks(pLevel, pPos);
        boolean drop;
        if (cactus.isRoot()) {
            drop = !blocks.is(Direction.DOWN, NchBlocks.COSMIC_SAND);
        } else {
            drop = !blocks.is(cactus.getParent(), this);
        }
        if (drop) {
            popResource(pLevel, pPos, new ItemStack(this));
            pLevel.removeBlock(pPos, false);
        } else {
            List<Direction> directions = Arrays.stream(Direction.values())
                    .filter(d -> pState.getValue(PROPERTY_BY_DIRECTION.get(d)))
                    .filter(d -> !(blocks.is(d, this) || blocks.is(d, NchBlocks.COSMIC_SAND)))
                    .toList();
            if (!directions.isEmpty()) {
                BlockState newState = pState;
                for (Direction direction : directions) {
                    newState = newState.setValue(PROPERTY_BY_DIRECTION.get(direction), false);
                }
                BlockUtils.setBlock(newState, pPos, pLevel);
            }
        }
    }

    private void growTo(Level level, BlockPos pos, Direction direction, CoarseCactusBlockEntity parent) {
        BlockPos target = pos.relative(direction);
        Direction pd = direction.getOpposite();
        level.setBlock(target, defaultBlockState()
                .setValue(PipeBlock.PROPERTY_BY_DIRECTION.get(pd), true), 2);
        ((CoarseCactusBlockEntity) Objects.requireNonNull(level.getBlockEntity(target))).setParent(pd, parent);
    }

    private boolean probability(Level level, double probability) {
        return level.random.nextFloat() <= probability;
    }
}
