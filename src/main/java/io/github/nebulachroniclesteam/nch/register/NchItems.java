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

public class NchItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NebulaChronicles.MOD_ID);

    public static final RegistryObject<Item> // NCH_MISC_ITEMS
    // NCH_INDUSTRIAL_ITEMS
    // NCH_INDUSTRIAL_ITEMS
    WHITE_BUD_STEW = ITEMS.register("white_bud_stew", () -> new WhiteBudStew(new Item.Properties().tab(NCH_MISC_ITEMS).food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).build()))), // NCH_INDUSTRIAL_ITEMS
    LANTERN_BERRIES = ITEMS.register("lantern_berries", () -> new LanternBerries(new Item.Properties().tab(NCH_MISC_ITEMS).food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).effect(new MobEffectInstance(MobEffects.GLOWING, 300, 0), 1.0F).effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0), 1.0F).build()))), BUG_FLESH = ITEMS.register("bug_flesh", () -> new BugFlesh(new Item.Properties().tab(NCH_MISC_ITEMS).food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).build())));

    // resource raw_black_tungsten.png
    public static final RegistryObject<Item> RAW_BLACK_TUNGSTEN = ITEMS.register("raw_black_tungsten", () -> new RawBlackTungsten(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource black_tungsten_ingot.png
    public static final RegistryObject<Item> BLACK_TUNGSTEN_INGOT = ITEMS.register("black_tungsten_ingot", () -> new BlackTungstenIngot(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource black_tungsten_nugget.png
    public static final RegistryObject<Item> BLACK_TUNGSTEN_NUGGET = ITEMS.register("black_tungsten_nugget", () -> new BlackTungstenNugget(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource black_tungsten_dust.png
    public static final RegistryObject<Item> BLACK_TUNGSTEN_DUST = ITEMS.register("black_tungsten_dust", () -> new BlackTungstenDust(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

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

    // resource adamantine.png
    public static final RegistryObject<Item> ADAMANTINE = ITEMS.register("adamantine", () -> new Item(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource adamantine_dust.png
    public static final RegistryObject<Item> ADAMANTINE_DUST = ITEMS.register("adamantine_dust", () -> new Item(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource adamantine_nugget.png
    public static final RegistryObject<Item> ADAMANTINE_NUGGET = ITEMS.register("adamantine_nugget", () -> new Item(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource adamantine_plate.png
    public static final RegistryObject<Item> ADAMANTINE_PLATE = ITEMS.register("adamantine_plate", () -> new Item(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource black_tungsten_plate.png
    public static final RegistryObject<Item> BLACK_TUNGSTEN_PLATE = ITEMS.register("black_tungsten_plate", () -> new Item(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource byte.png
    public static final RegistryObject<Item> BYTE = ITEMS.register("byte", () -> new Item(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource byte_dust.png
    public static final RegistryObject<Item> BYTE_DUST = ITEMS.register("byte_dust", () -> new Item(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource byte_nugget.png
    public static final RegistryObject<Item> BYTE_NUGGET = ITEMS.register("byte_nugget", () -> new Item(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource copper_plate.png
    public static final RegistryObject<Item> COPPER_PLATE = ITEMS.register("copper_plate", () -> new Item(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource flourescium_dust.png
    public static final RegistryObject<Item> FLOURESCIUM_DUST = ITEMS.register("flourescium_dust", () -> new Item(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource flourescium_ingot.png
    public static final RegistryObject<Item> FLOURESCIUM_INGOT = ITEMS.register("flourescium_ingot", () -> new Item(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource flourescium_nugget.png
    public static final RegistryObject<Item> FLOURESCIUM_NUGGET = ITEMS.register("flourescium_nugget", () -> new Item(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource gold_plate.png
    public static final RegistryObject<Item> GOLD_PLATE = ITEMS.register("gold_plate", () -> new Item(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource iron_plate.png
    public static final RegistryObject<Item> IRON_PLATE = ITEMS.register("iron_plate", () -> new Item(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource netherite_plate.png
    public static final RegistryObject<Item> NETHERITE_PLATE = ITEMS.register("netherite_plate", () -> new Item(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource raw_byte.png
    public static final RegistryObject<Item> RAW_BYTE = ITEMS.register("raw_byte", () -> new Item(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource raw_flourescium.png
    public static final RegistryObject<Item> RAW_FLOURESCIUM = ITEMS.register("raw_flourescium", () -> new Item(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource raw_zoga.png
    public static final RegistryObject<Item> RAW_ZOGA = ITEMS.register("raw_zoga", () -> new Item(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource thulium_188_dust.png
    public static final RegistryObject<Item> THULIUM_188_DUST = ITEMS.register("thulium_188_dust", () -> new Item(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource thulium_188_ingot.png
    public static final RegistryObject<Item> THULIUM_188_INGOT = ITEMS.register("thulium_188_ingot", () -> new Item(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource thulium_188_nugget.png
    public static final RegistryObject<Item> THULIUM_188_NUGGET = ITEMS.register("thulium_188_nugget", () -> new Item(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource thulium_188_plate.png
    public static final RegistryObject<Item> THULIUM_188_PLATE = ITEMS.register("thulium_188_plate", () -> new Item(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource zoga_dust.png
    public static final RegistryObject<Item> ZOGA_DUST = ITEMS.register("zoga_dust", () -> new Item(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource zoga_ingot.png
    public static final RegistryObject<Item> ZOGA_INGOT = ITEMS.register("zoga_ingot", () -> new Item(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource zoga_nugget.png
    public static final RegistryObject<Item> ZOGA_NUGGET = ITEMS.register("zoga_nugget", () -> new Item(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource zoga_plate.png
    public static final RegistryObject<Item> ZOGA_PLATE = ITEMS.register("zoga_plate", () -> new Item(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));
}
