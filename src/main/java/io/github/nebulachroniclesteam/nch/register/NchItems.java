package io.github.nebulachroniclesteam.nch.register;

import io.github.nebulachroniclesteam.nch.NebulaChronicles;
import io.github.nebulachroniclesteam.nch.item.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import static io.github.nebulachroniclesteam.nch.register.NchCreativeModeTab.*;

public class NchItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NebulaChronicles.MOD_ID);

    public static final RegistryObject<Item> // NCH_MISC_ITEMS
    // NCH_INDUSTRIAL_ITEMS
    // NCH_INDUSTRIAL_ITEMS
    // NCH_INDUSTRIAL_ITEMS
    WHITE_BUD_STEW = ITEMS.register("white_bud_stew", () -> new WhiteBudStew(new Item.Properties().tab(NCH_MISC_ITEMS).food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).build()))), LANTERN_BERRIES = ITEMS.register("lantern_berries", () -> new LanternBerries(new Item.Properties().tab(NCH_MISC_ITEMS).food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).effect(new MobEffectInstance(MobEffects.GLOWING, 300, 0), 1.0F).effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0), 1.0F).build()))), BUG_FLESH = ITEMS.register("bug_flesh", () -> new BugFlesh(new Item.Properties().tab(NCH_MISC_ITEMS).food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).build())));

    // resource raw_black_tungsten.png
    public static final RegistryObject<Item> RAW_BLACK_TUNGSTEN = ITEMS.register("raw_black_tungsten", () -> new RawBlackTungsten(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource black_tungsten_ingot.png
    public static final RegistryObject<Item> BLACK_TUNGSTEN_INGOT = ITEMS.register("black_tungsten_ingot", () -> new BlackTungstenIngot(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource black_tungsten_nugget.png
    public static final RegistryObject<Item> BLACK_TUNGSTEN_NUGGET = ITEMS.register("black_tungsten_nugget", () -> new BlackTungstenNugget(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

    // resource black_tungsten_dust.png
    public static final RegistryObject<Item> BLACK_TUNGSTEN_DUST = ITEMS.register("black_tungsten_dust", () -> new BlackTungstenDust(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));

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

    // resource raw_zoga_block.png
    public static final RegistryObject<Item> RAW_ZOGA_BLOCK = ITEMS.register("raw_zoga_block", () -> new Item(new Item.Properties().tab(NCH_INDUSTRIAL_ITEMS)));
}
