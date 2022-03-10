package io.github.nebulachroniclesteam.nch.datagen;

import com.mojang.datafixers.util.Pair;
import io.github.nebulachroniclesteam.nch.datagen.loot.NchBlockLoots;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.registries.DeferredRegister;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class NchLootProvider extends LootTableProvider {

    private final DeferredRegister<Block> blocks;

    public NchLootProvider(DataGenerator pGenerator, DeferredRegister<Block> blocks) {
        super(pGenerator);
        this.blocks = blocks;
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return List.of(Pair.of(() -> new NchBlockLoots(blocks), LootContextParamSets.BLOCK));
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationTracker) {
        map.forEach((location, table) -> LootTables.validate(validationTracker, location, table));
    }
}
