package io.github.nebulachroniclesteam.nch.datagen.loot;

import io.github.nebulachroniclesteam.nch.block.WhiteBudBush;
import io.github.nebulachroniclesteam.nch.item.NchItemTags;
import io.github.nebulachroniclesteam.nch.register.NchBlocks;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

public class NchBlockLoots extends BlockLoot {

    private final List<Block> blocks = new LinkedList<>();

    @Override
    protected void addTables() {
        // drop (1 or 2 if use axe and is grown) leaves
        add(NchBlocks.WHITE_BUD_BUSH.get(), LootTable.lootTable()
                .withPool(applyExplosionCondition(NchBlocks.WHITE_BUD_BUSH.get(), LootPool.lootPool()
                        .add(LootItem.lootTableItem(NchBlocks.WHITE_BUD_BUSH.get()).apply(SetItemCountFunction
                                .setCount(ConstantValue.exactly(2))
                                .when(useItem(NchItemTags.AXES))
                                .when(isGrown(NchBlocks.WHITE_BUD_BUSH, WhiteBudBush.AGE, 2)))))));
    }

    private LootItemCondition.Builder isGrown(Supplier<Block> block, IntegerProperty property, int max) {
        return LootItemBlockStatePropertyCondition.hasBlockStateProperties(block.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(property, max));
    }

    private LootItemCondition.Builder useItem(Tag<Item> tag) {
        return MatchTool.toolMatches(ItemPredicate.Builder.item().of(tag));
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
