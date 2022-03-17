package io.github.nebulachroniclesteam.nch.blockentity;

import io.github.nebulachroniclesteam.nch.register.NchBlockEntities;
import io.github.nebulachroniclesteam.nch.util.NbtUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.stream.Stream;

public class CoarseCactusBlockEntity extends BlockEntity {

    public static int WAIT_TIME = 40;
    public static int MAX_AGE = 5;
    public static int MAX_TRUNK_HEIGHT = 8;
    public static int MAX_FORK_HEIGHT = 8;

    private static final int FLAG_UP = 0b00001;
    // 0: never growable
    private static final int FLAG_DOWN = 0b00000;
    private static final int FLAG_EAST = 0b00010;
    private static final int FLAG_WEST = 0b00100;
    private static final int FLAG_NORTH = 0b01000;
    private static final int FLAG_SOUTH = 0b10000;
    private static final int FLAG_FORK = FLAG_EAST | FLAG_WEST | FLAG_SOUTH | FLAG_NORTH;
    private static final int[] FLAGS;

    static {
        FLAGS = new int[Direction.values().length];
        FLAGS[Direction.UP.ordinal()] = FLAG_UP;
        FLAGS[Direction.DOWN.ordinal()] = FLAG_DOWN;
        FLAGS[Direction.EAST.ordinal()] = FLAG_EAST;
        FLAGS[Direction.WEST.ordinal()] = FLAG_WEST;
        FLAGS[Direction.NORTH.ordinal()] = FLAG_NORTH;
        FLAGS[Direction.SOUTH.ordinal()] = FLAG_SOUTH;
    }

    private int forkLevel = 0;
    private int height = 0;
    private Direction parent = Direction.DOWN;

    private int age = 0;
    private int wait = WAIT_TIME;

    // 1st: only allow to grow up
    private int noGrowable = ~FLAG_UP;

    public CoarseCactusBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(NchBlockEntities.COARSE_CACTUS.get(), pWorldPosition, pBlockState);
    }

    public void setAge(int age) {
        if (age != this.age) {
            this.age = age;
            setChanged();
        }
    }

    public int getAge() {
        return age;
    }

    public void setParent(Direction parent, CoarseCactusBlockEntity cactus) {
        this.parent = parent;
        // set fork level and height
        if (parent == Direction.DOWN) {
            this.forkLevel = cactus.forkLevel;
            this.height = cactus.height + 1;
        } else {
            this.forkLevel = cactus.forkLevel + 1;
            this.height = cactus.height;
        }
        // 0 trunk
        if (isTrunk()) {
            if (height == 1) {
                // 2nd: allow to grow all direction
                noGrowable = 0;
            } else {
                // other: check max height
                this.noGrowable = cactus.noGrowable;
                if (height >= MAX_TRUNK_HEIGHT) {
                    noGrowable |= FLAG_UP;
                }
            }
        }
        // fork level 1: grow up and same side
        if (forkLevel == 1) {
            noGrowable = cactus.isTrunk()
                    ? ~(FLAG_UP | FLAGS[parent.getOpposite().ordinal()])
                    : cactus.noGrowable;
            if (height >= MAX_FORK_HEIGHT) {
                noGrowable |= FLAG_UP;
            }
        }
        // fork level 2: only grow up
        else if (forkLevel == 2) {
            noGrowable = FLAG_FORK;
            if (height >= MAX_FORK_HEIGHT) {
                noGrowable |= FLAG_UP;
            }
        }
        setChanged();
    }

    public Direction getParent() {
        return parent;
    }

    public boolean isTrunk() {
        return forkLevel == 0;
    }

    public boolean isRoot() {
        return forkLevel == 0 && height == 0;
    }

    public boolean nextAge() {
        boolean grow = false;
        if (level != null && age <= MAX_AGE && canGrow()) {
            if (wait == 0 || true) { // todo by lq2007: debug flag
                if (level.random.nextFloat() <= 0.1 || true) { // todo by lq2007: debug flag
                    age++;
                    grow = true;
                }
                wait = WAIT_TIME;
            } else {
                wait--;
            }
            setChanged();
        }
        return grow;
    }

    public boolean canGrow() {
        return canGrowUp() || canFork();
    }

    public boolean canGrowUp() {
        return (noGrowable & FLAG_UP) == 0;
    }

    public boolean canFork() {
        return (noGrowable & FLAG_FORK) != FLAG_FORK;
    }

    public boolean canGrow(Direction direction) {
        int flag = FLAGS[direction.ordinal()];
        return (noGrowable & flag) == 0;
    }

    public void markGrownTag(Direction direction) {
        if (canGrow(direction)) {
            noGrowable |= FLAGS[direction.ordinal()];
            if (level != null) {
                BlockEntity be = level.getBlockEntity(worldPosition.below());
                if (be instanceof CoarseCactusBlockEntity below) {
                    below.markGrownTag(direction);
                }
            }
            setChanged();
        }
    }

    public Stream<Direction> forkDirections() {
        return canFork() ? Direction.Plane.HORIZONTAL.stream().filter(this::canGrow) : Stream.empty();
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        NbtUtils.readAllFields(this, pTag);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        NbtUtils.writeAllFields(this, pTag);
    }
}
