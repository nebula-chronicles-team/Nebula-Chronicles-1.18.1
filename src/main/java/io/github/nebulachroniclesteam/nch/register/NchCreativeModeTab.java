package io.github.nebulachroniclesteam.nch.register;

import io.github.nebulachroniclesteam.nch.NebulaChronicles;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class NchCreativeModeTab {

    public static final CreativeModeTab NCH_MISC_ITEMS = new CreativeModeTab(getLabel("nch_misc_items")) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(NchBlockItems.WHITE_BUD_LEAVES.get());
        }
    };

    public static final CreativeModeTab NCH_INDUSTRIAL_ITEMS = new CreativeModeTab(getLabel("nch_industrial_items")) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(NchItems.RAW_BLACK_TUNGSTEN.get());
        }
    };

    public static final CreativeModeTab NCH_WORLD = new CreativeModeTab(getLabel("nch_world")) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.STONE);
        }
    };

    public static final CreativeModeTab NCH_INDUSTRIAL_BLOCKS = new CreativeModeTab(getLabel("nch_industrial_blocks")) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.STONE);
        }
    };

    public static String getLabel(String name) {
        return NebulaChronicles.MOD_ID + "." + name;
    }
}
