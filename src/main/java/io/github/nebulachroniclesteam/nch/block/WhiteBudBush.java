package io.github.nebulachroniclesteam.nch.block;


import io.github.nebulachroniclesteam.nch.item.NchItemTags;
import io.github.nebulachroniclesteam.nch.register.NchBlockItems;
import io.github.nebulachroniclesteam.nch.util.ILootableBlock;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeHooks;

import java.util.Random;

public class WhiteBudBush extends BushBlock implements BonemealableBlock, ILootableBlock {

    public static final IntegerProperty AGE = BlockStateProperties.AGE_2;

    private static final VoxelShape VS_SMALL = Block.box(3, 0, 3, 13, 9, 13);
    private static final VoxelShape VS_FULL = Block.box(1, 0, 1, 15, 13, 15);

    public WhiteBudBush() {
        super(Properties.of(Material.PLANT)
                .randomTicks()
                .noCollission()
                .sound(SoundType.CROP));
        registerDefaultState(getStateDefinition().any().setValue(AGE, 0));
    }

    public int getAge(BlockState state) {
        return state.getValue(AGE);
    }

    public boolean isMaxAge(BlockState state) {
        return state.getValue(AGE) == 2;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(AGE);
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
        return new ItemStack(NchBlockItems.WHITE_BUD_LEAVES.get());
    }

    @Override
    public boolean isRandomlyTicking(BlockState pState) {
        return !isMaxAge(pState);
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, Random pRandom) {
        if (!isMaxAge(pState)
                // 光照强度 >= 9
                && pLevel.getRawBrightness(pPos.above(), 0) >= 9
                // event: 20% 生长
                && ForgeHooks.onCropsGrowPre(pLevel, pPos, pState, pRandom.nextInt(5) == 0)) {
            pLevel.setBlock(pPos, pState.setValue(AGE, getAge(pState) + 1), 2);
            ForgeHooks.onCropsGrowPost(pLevel, pPos, pState);
        }
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide && pPlayer instanceof ServerPlayer sp) {
            ItemStack itemInHand = pPlayer.getItemInHand(pHand);
            if (isMaxAge(pState)) {
                if (itemInHand.is(NchItemTags.AXES)) {
                    popResource(pLevel, pPos, new ItemStack(NchBlockItems.WHITE_BUD_LEAVES.get()));
                    itemInHand.hurt(1, pLevel.random, sp);
                    float pitch = 0.8f + pLevel.random.nextFloat() * 4;
                    pLevel.playSound(null, pPos, SoundEvents.CROP_BREAK, SoundSource.BLOCKS, 1, pitch);
                    pLevel.setBlock(pPos, pState.setValue(AGE, 0), 2);
                    return InteractionResult.PASS;
                }
            }
            if (!isMaxAge(pState) && itemInHand.is(Items.BONE_MEAL)) {
                return InteractionResult.PASS;
            }
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return isMaxAge(pState) ? VS_FULL : VS_SMALL;
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
        return !isMaxAge(pState);
    }

    @Override
    public boolean isBonemealSuccess(Level pLevel, Random pRandom, BlockPos pPos, BlockState pState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel pLevel, Random pRandom, BlockPos pPos, BlockState pState) {
        int i = Math.min(2, getAge(pState) + 1);
        pLevel.setBlock(pPos, pState.setValue(AGE, i), 2);
    }

    @Override
    public LootTable.Builder createLootBuilder() {
        LootItemBlockStatePropertyCondition.Builder isGrown = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(this)
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(AGE, 2));
        LootItemCondition.Builder useAxe = MatchTool.toolMatches(ItemPredicate.Builder.item().of(NchItemTags.AXES));
        // drop (1 or 2 if use axe and is grown) leaves
        return LootTable.lootTable().withPool(applyExplosionCondition(LootPool.lootPool()
                .add(LootItem.lootTableItem(this)
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2)).when(useAxe).when(isGrown)))));
    }

}
