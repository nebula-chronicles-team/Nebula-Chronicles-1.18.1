package io.github.nebulachroniclesteam.nch.block;

import io.github.nebulachroniclesteam.nch.util.ILootableBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;

import java.util.function.Supplier;

public class NchPottedFlower extends FlowerPotBlock implements ILootableBlock {

    public NchPottedFlower(Supplier<? extends Block> flower) {
        super(() -> (FlowerPotBlock) Blocks.FLOWER_POT, flower, Properties.of(Material.DECORATION).instabreak().noOcclusion());
    }

    @Override
    public LootTable.Builder createLootBuilder() {
        return LootTable.lootTable().withPool(applyExplosionCondition(LootPool.lootPool()
                        .add(LootItem.lootTableItem(Blocks.FLOWER_POT))))
                .withPool(applyExplosionCondition(LootPool.lootPool()
                        .add(LootItem.lootTableItem(getContent()))));
    }
}
