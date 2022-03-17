package io.github.nebulachroniclesteam.nch.block;

import io.github.nebulachroniclesteam.nch.util.ILootableBlock;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class CoarseCactusDoor extends DoorBlock implements ILootableBlock {

    public CoarseCactusDoor() {
        super(Properties.copy(Blocks.OAK_DOOR));
    }

    @Override
    public LootTable.Builder createLootBuilder() {
        return LootTable.lootTable().withPool(applyExplosionCondition(LootPool.lootPool()
                .add(LootItem.lootTableItem(this)
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(this)
                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                        .hasProperty(HALF, DoubleBlockHalf.LOWER))))));

    }
}
