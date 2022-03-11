package io.github.nebulachroniclesteam.nch.datagen.loot;

import io.github.nebulachroniclesteam.nch.register.NchBlocks;
import io.github.nebulachroniclesteam.nch.util.ILootableBlock;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedList;
import java.util.List;

public class NchBlockLoots extends BlockLoot {

    private final List<Block> blocks = new LinkedList<>();

    @Override
    protected void addTables() {
        NchBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            ResourceLocation lootTable = block.getLootTable();
            ResourceLocation id = block.delegate.name();
            ResourceLocation defaultTable = new ResourceLocation(id.getNamespace(), "blocks/" + id.getPath());
            if (lootTable.equals(defaultTable)) {
                if (block instanceof ILootableBlock lootable) {
                    add(block, lootable.createLootBuilder());
                    return;
                }
                add(block, createSingleItemTable(block));
            }
        });
    }

    @Override
    protected void add(Block pBlock, LootTable.Builder pLootTableBuilder) {
        super.add(pBlock, pLootTableBuilder);
        blocks.add(pBlock);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return blocks;
    }
}
