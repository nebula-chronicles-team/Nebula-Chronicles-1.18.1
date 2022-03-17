package io.github.nebulachroniclesteam.nch.register;

import io.github.nebulachroniclesteam.nch.NebulaChronicles;
import io.github.nebulachroniclesteam.nch.item.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static io.github.nebulachroniclesteam.nch.register.NchCreativeModeTab.*;
import static io.github.nebulachroniclesteam.nch.register.NchCreativeModeTab.NCH_WORLD;

public class NchItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NebulaChronicles.MOD_ID);

    public static final RegistryObject<Item>
            // NCH_MISC_ITEMS
            WHITE_BUD_STEW = ITEMS.register("white_bud_stew", () -> new WhiteBudStew(new Item.Properties().tab(NCH_MISC_ITEMS).food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).build()))),
            LANTERN_BERRIES = ITEMS.register("lantern_berries", () -> new LanternBerries(new Item.Properties().tab(NCH_MISC_ITEMS).food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).effect(new MobEffectInstance(MobEffects.GLOWING, 300, 0), 1.0F).effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0), 1.0F).build()))),
            BUG_FLESH = ITEMS.register("bug_flesh", () -> new BugFlesh(new Item.Properties().tab(NCH_MISC_ITEMS).food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).build()))),

    // NCH_INDUSTRIAL_ITEMS
    RAW_BLACK_TUNGSTEN = ITEMS.register("raw_black_tungsten", () -> new RawBlackTungsten(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS))),
            BLACK_TUNGSTEN_INGOT = ITEMS.register("black_tungsten_ingot", () -> new BlackTungstenIngot(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS))),
            BLACK_TUNGSTEN_NUGGET = ITEMS.register("black_tungsten_nugget", () -> new BlackTungstenNugget(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS))),
            BLACK_TUNGSTEN_DUST = ITEMS.register("black_tungsten_dust", () -> new BlackTungstenDust(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

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
