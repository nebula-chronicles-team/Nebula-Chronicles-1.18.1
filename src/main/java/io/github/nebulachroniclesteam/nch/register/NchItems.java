package io.github.nebulachroniclesteam.nch.register;

import io.github.nebulachroniclesteam.nch.NebulaChronicles;
import io.github.nebulachroniclesteam.nch.item.LanternBerries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NchItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NebulaChronicles.MOD_ID);


    public static final RegistryObject<Item>
            WHITE_BUD_LEAVES = ITEMS.register("white_bud_leaves", () -> new Item(new Item.Properties().tab(NchCreativeModeTab.NCH_ITEMS))),
            WHITE_BUD_STEW = ITEMS.register("white_bud_stew", () -> new Item(new Item.Properties().tab(NchCreativeModeTab.NCH_ITEMS).food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).build()))),
            LANTERN_BERRIES = ITEMS.register("lantern_berries", LanternBerries::new),
            BUG_FLESH = ITEMS.register("bug_flesh", () -> new Item(new Item.Properties().tab(NchCreativeModeTab.NCH_ITEMS).food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).build())));


}
