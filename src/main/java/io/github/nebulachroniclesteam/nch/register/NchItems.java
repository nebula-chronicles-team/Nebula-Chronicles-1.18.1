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

public class NchItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NebulaChronicles.MOD_ID);

    public static final RegistryObject<Item>
            // NCH_MISC_ITEMS
            WHITE_BUD_LEAVES = ITEMS.register("white_bud_leaves", () -> new WhiteBudLeaves(new Item.Properties().tab(NchCreativeModeTab.NCH_MISC_ITEMS))),
            WHITE_BUD_STEW = ITEMS.register("white_bud_stew", () -> new WhiteBudStew(new Item.Properties().tab(NchCreativeModeTab.NCH_MISC_ITEMS).food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).build()))),
            LANTERN_BERRIES = ITEMS.register("lantern_berries", () -> new LanternBerries(new Item.Properties().tab(NchCreativeModeTab.NCH_MISC_ITEMS).food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).effect(new MobEffectInstance(MobEffects.GLOWING, 300, 0), 1.0F).effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0), 1.0F).build()))),
            BUG_FLESH = ITEMS.register("bug_flesh", () -> new BugFlesh(new Item.Properties().tab(NchCreativeModeTab.NCH_MISC_ITEMS).food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).build()))),

    // NCH_INDUSTRIAL_ITEMS
    RAW_BLACK_TUNGSTEN = ITEMS.register("raw_black_tungsten", () -> new RawBlackTungsten(new Item.Properties().tab(NchCreativeModeTab.NCH_INDUSTRIAL_ITEMS))),
            BLACK_TUNGSTEN_INGOT = ITEMS.register("black_tungsten_ingot", () -> new BlackTungstenIngot(new Item.Properties().tab(NchCreativeModeTab.NCH_INDUSTRIAL_ITEMS))),
            BLACK_TUNGSTEN_NUGGET = ITEMS.register("black_tungsten_nugget", () -> new BlackTungstenNugget(new Item.Properties().tab(NchCreativeModeTab.NCH_INDUSTRIAL_ITEMS))),
            BLACK_TUNGSTEN_DUST = ITEMS.register("black_tungsten_dust", () -> new BlackTungstenDust(new Item.Properties().tab(NchCreativeModeTab.NCH_INDUSTRIAL_ITEMS)));


}
