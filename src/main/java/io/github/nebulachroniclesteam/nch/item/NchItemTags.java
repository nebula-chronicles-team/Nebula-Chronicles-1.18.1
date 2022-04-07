package io.github.nebulachroniclesteam.nch.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class NchItemTags {
    public static final TagKey<Item> AXES_TOOLS = ItemTags.create(new ResourceLocation("forge", "tools/axes"));
    public static final TagKey<Item> AXES = ItemTags.create(new ResourceLocation("forge", "axes"));
}
