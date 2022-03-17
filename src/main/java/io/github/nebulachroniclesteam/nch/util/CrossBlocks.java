package io.github.nebulachroniclesteam.nch.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.function.Supplier;

public class CrossBlocks {

    private final BlockGetter getter;
    private final BlockPos pos;
    private final EnumMap<Direction, BlockState[]> bs = new EnumMap<>(Direction.class);

    public CrossBlocks(BlockGetter getter, BlockPos pos) {
        this.getter = getter;
        this.pos = pos;

        for (Direction value : Direction.values()) {
            bs.put(value, new BlockState[0]);
        }
    }

    public BlockState get(Direction direction) {
        return get(direction, 1);
    }

    public BlockState get(Direction direction, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must larger than 0");
        }
        BlockState[] states = bs.get(direction);
        if (n > states.length) {
            states = Arrays.copyOf(states, n, BlockState[].class);
        }
        BlockState result = states[n - 1];
        if (result == null) {
            result = states[n - 1] = getter.getBlockState(pos.relative(direction, n));
        }
        return result;
    }

    public boolean is(Direction direction, Supplier<? extends Block> block) {
        return get(direction).is(block.get());
    }

    public boolean is(Direction direction, Block block) {
        return get(direction).is(block);
    }

    public boolean isAir(Direction direction) {
        return get(direction).isAir();
    }

    public boolean is(Direction direction, int n, Supplier<? extends Block> block) {
        return get(direction, n).is(block.get());
    }

    public boolean is(Direction direction, int n, Block block) {
        return get(direction, n).is(block);
    }

    public int nearby(Block block) {
        return (int) Arrays.stream(Direction.values())
                .filter(d -> is(d, block))
                .count();
    }

    public CrossBlocks relative(Direction direction) {
        return new CrossBlocks(getter, pos.relative(direction));
    }

    public void clear() {
        bs.clear();
    }
}
