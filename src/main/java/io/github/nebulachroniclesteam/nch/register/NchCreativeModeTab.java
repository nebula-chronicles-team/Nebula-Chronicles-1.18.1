package io.github.nebulachroniclesteam.nch.register;

import io.github.nebulachroniclesteam.nch.NebulaChronicles;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class NchCreativeModeTab {

    public static final CreativeModeTab NCH_ITEMS = new CreativeModeTab(getLabel("nch_items")) {
        public ItemStack makeIcon() {
            return new ItemStack(NchItems.WHITE_BUD_LEAVES.get());
        }
    };

    public static final CreativeModeTab NCH_WORLD = new CreativeModeTab(getLabel("nch_world")) {
        public ItemStack makeIcon() {
            return new ItemStack(Items.STONE);
        }
    };

    public static String getLabel(String name) {
        return NebulaChronicles.MOD_ID + "." + name;
    }
}
