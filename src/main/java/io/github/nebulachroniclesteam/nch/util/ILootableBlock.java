package io.github.nebulachroniclesteam.nch.util;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.FunctionUserBuilder;
import net.minecraft.world.level.storage.loot.predicates.ConditionUserBuilder;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;

public interface ILootableBlock {

    default LootTable.Builder createLootBuilder() {
        return LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem((Block) this)));
    }

    default <T> T applyExplosionDecay(FunctionUserBuilder<T> builder) {
        return builder.apply(ApplyExplosionDecay.explosionDecay());
    }

    default <T> T applyExplosionDecay(boolean explosionResistant, FunctionUserBuilder<T> builder) {
        return explosionResistant ? builder.unwrap() : builder.apply(ApplyExplosionDecay.explosionDecay());
    }

    default <T> T applyExplosionCondition(ConditionUserBuilder<T> builder) {
        return builder.when(ExplosionCondition.survivesExplosion());
    }

    default <T> T applyExplosionCondition(boolean explosionResistant, ConditionUserBuilder<T> builder) {
        return explosionResistant ? builder.unwrap() : builder.when(ExplosionCondition.survivesExplosion());
    }
}
