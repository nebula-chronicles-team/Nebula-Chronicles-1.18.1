package io.github.nebulachroniclesteam.nch.block;

import io.github.nebulachroniclesteam.nch.util.ILootableBlock;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class CoarseCactusSlabs extends SlabBlock implements ILootableBlock {

    public CoarseCactusSlabs() {
        super(Properties.copy(Blocks.OAK_SLAB));
    }

    @Override
    public LootTable.Builder createLootBuilder() {
        return LootTable.lootTable().withPool(LootPool.lootPool()
                .add(applyExplosionDecay(LootItem.lootTableItem(this)
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(this)
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))))));
    }
}
