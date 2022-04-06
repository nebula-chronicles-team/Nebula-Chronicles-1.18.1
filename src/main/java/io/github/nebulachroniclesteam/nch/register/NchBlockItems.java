package io.github.nebulachroniclesteam.nch.register;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static io.github.nebulachroniclesteam.nch.register.NchCreativeModeTab.NCH_MISC_ITEMS;
import static io.github.nebulachroniclesteam.nch.register.NchCreativeModeTab.NCH_WORLD;

public class NchBlockItems {

    public static final DeferredRegister<Item> ITEMS = NchItems.ITEMS;
    public static final RegistryObject<Item> WHITE_BUD_LEAVES = block(NchBlocks.WHITE_BUD_BUSH, "white_bud_leaves", NCH_MISC_ITEMS);
    public static final RegistryObject<Item> COSMIC_SAND = block(NchBlocks.COSMIC_SAND, NCH_WORLD);
    public static final RegistryObject<Item> COSMIC_SANDSTONE = block(NchBlocks.COSMIC_SANDSTONE, NCH_WORLD);
    public static final RegistryObject<Item> SILVERBLANC_STONE = block(NchBlocks.SILVERBLANC_STONE, NCH_WORLD);
    public static final RegistryObject<Item> MOSS_SILVERBLANC_STONE = block(NchBlocks.MOSS_SILVERBLANC_STONE, NCH_WORLD);
    public static final RegistryObject<Item> SILVERBLANC_STONE_BRICKS = block(NchBlocks.SILVERBLANC_STONE_BRICKS, NCH_WORLD);
    public static final RegistryObject<Item> CHISELED_SILVERBLANC_STONE_BRICKS = block(NchBlocks.CHISELED_SILVERBLANC_STONE_BRICKS, NCH_WORLD);
    public static final RegistryObject<Item> SILVERBLANC_IRON_ORE = block(NchBlocks.SILVERBLANC_IRON_ORE, NCH_WORLD);
    public static final RegistryObject<Item> SILVERBLANC_GOLD_ORE = block(NchBlocks.SILVERBLANC_GOLD_ORE, NCH_WORLD);
    public static final RegistryObject<Item> SILVERBLANC_BLACK_TUNGSTEN_ORE = block(NchBlocks.SILVERBLANC_BLACK_TUNGSTEN_ORE, NCH_WORLD);
    public static final RegistryObject<Item> SILVERBLANC_BEDROCK_DIAMOND_ORE = block(NchBlocks.SILVERBLANC_BEDROCK_DIAMOND_ORE, NCH_WORLD);
    public static final RegistryObject<Item> WHITE_BUD = block(NchBlocks.WHITE_BUD, NCH_WORLD);
    public static final RegistryObject<Item> WHITE_BUD_LEAF_BLOCK = block(NchBlocks.WHITE_BUD_LEAF_BLOCK, NCH_WORLD);
    public static final RegistryObject<Item> STRANGE_FERN = block(NchBlocks.STRANGE_FERN, NCH_WORLD);
    public static final RegistryObject<Item> LANTERN_BERRIES_PLANT = block(NchBlocks.LANTERN_BERRIES_PLANT, NCH_WORLD);
    public static final RegistryObject<Item> COARSE_CACTUS = block(NchBlocks.COARSE_CACTUS, NCH_WORLD);
    public static final RegistryObject<Item> COARSE_CACTUS_PLANKS = block(NchBlocks.COARSE_CACTUS_PLANKS, NCH_WORLD);
    public static final RegistryObject<Item> COARSE_CACTUS_STAIRS = block(NchBlocks.COARSE_CACTUS_STAIRS, NCH_WORLD);
    public static final RegistryObject<Item> COARSE_CACTUS_SLABS = block(NchBlocks.COARSE_CACTUS_SLABS, NCH_WORLD);
    public static final RegistryObject<Item> COARSE_CACTUS_FENCE = block(NchBlocks.COARSE_CACTUS_FENCE, NCH_WORLD);
    public static final RegistryObject<Item> COARSE_CACTUS_FENCE_GATE = block(NchBlocks.COARSE_CACTUS_FENCE_GATE, NCH_WORLD);
    public static final RegistryObject<Item> COARSE_CACTUS_TRAPDOOR = block(NchBlocks.COARSE_CACTUS_TRAPDOOR, NCH_WORLD);
    public static final RegistryObject<Item> COARSE_CACTUS_DOOR = block(NchBlocks.COARSE_CACTUS_DOOR, NCH_WORLD);
    public static final RegistryObject<Item> BLUE_KODOKU_FLOWER = block(NchBlocks.BLUE_KODOKU_FLOWER, NCH_WORLD);
    public static final RegistryObject<Item> PURPLE_KODOKU_FLOWER = block(NchBlocks.PURPLE_KODOKU_FLOWER, NCH_WORLD);
    public static final RegistryObject<Item> WHITE_KODOKU_FLOWER = block(NchBlocks.WHITE_KODOKU_FLOWER, NCH_WORLD);
    public static final RegistryObject<Item> SILVERBLANC_BEDROCK = block(NchBlocks.SILVERBLANC_BEDROCK, NCH_WORLD);
    public static final RegistryObject<Item> SILVERBLANC_BEDROCK_IRON_ORE = block(NchBlocks.SILVERBLANC_BEDROCK_IRON_ORE, NCH_WORLD);
    public static final RegistryObject<Item> SILVERBLANC_BEDROCK_GOLD_ORE = block(NchBlocks.SILVERBLANC_BEDROCK_GOLD_ORE, NCH_WORLD);
    public static final RegistryObject<Item> SILVERBLANC_BEDROCK_BLACK_TUNGSTEN_ORE = block(NchBlocks.SILVERBLANC_BEDROCK_BLACK_TUNGSTEN_ORE, NCH_WORLD);
    public static final RegistryObject<Item> SILVERBLANC_STONE_BRICKS_STAIRS = block(NchBlocks.SILVERBLANC_STONE_BRICKS_STAIRS, NCH_WORLD);
    public static final RegistryObject<Item> SILVERBLANC_STONE_BRICKS_SLAB = block(NchBlocks.SILVERBLANC_STONE_BRICKS_SLAB, NCH_WORLD);


    private static <T extends Block> RegistryObject<Item> block(RegistryObject<T> block, CreativeModeTab tab) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    private static <T extends Block> RegistryObject<Item> block(RegistryObject<T> block, String id, CreativeModeTab tab) {
        return ITEMS.register(id, () -> new ItemNameBlockItem(block.get(), new Item.Properties().tab(tab)));
    }

}
