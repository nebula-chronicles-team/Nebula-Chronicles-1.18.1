package io.github.nebulachroniclesteam.nch.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeTagHandler;
import net.minecraftforge.registries.ForgeRegistries;

public class NchItemTags {

    public static final Tag.Named<Item> AXES_TOOLS = ForgeTagHandler.createOptionalTag(ForgeRegistries.ITEMS, new ResourceLocation("forge", "tools/axes"));
    public static final Tag.Named<Item> AXES = ForgeTagHandler.createOptionalTag(ForgeRegistries.ITEMS, new ResourceLocation("forge", "axes"));
}
