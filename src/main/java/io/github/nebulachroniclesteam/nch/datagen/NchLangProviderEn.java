package io.github.nebulachroniclesteam.nch.datagen;

import io.github.nebulachroniclesteam.nch.NebulaChronicles;
import io.github.nebulachroniclesteam.nch.register.NchBlocks;
import io.github.nebulachroniclesteam.nch.register.NchCreativeModeTab;
import io.github.nebulachroniclesteam.nch.register.NchItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.data.LanguageProvider;

public class NchLangProviderEn extends LanguageProvider {

    public NchLangProviderEn(DataGenerator gen) {
        super(gen, NebulaChronicles.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addGroup(NchCreativeModeTab.NCH_WORLD, "Nebula Chronicles - World");
        addGroup(NchCreativeModeTab.NCH_MISC_ITEMS, "Nebula Chronicles - Misc");
        addGroup(NchCreativeModeTab.NCH_INDUSTRIAL_ITEMS, "Nebula Chronicles - Industrial Items");
        addGroup(NchCreativeModeTab.NCH_INDUSTRIAL_BLOCKS, "Nebula Chronicles - Industrial Blocks");

        addItem(NchItems.BUG_FLESH, "Bug Flesh");
        addItem(NchItems.WHITE_BUD_STEW, "White Bud Stew");
        addItem(NchItems.WHITE_BUD_LEAVES, "White Bud Leaves");
        addItem(NchItems.LANTERN_BERRIES, "Lantern Berries");
//        addItem(NchItems.RAW_IRON, "Raw Iron");
//        addItem(NchItems.RAW_Gold, "Raw Gold");
        addItem(NchItems.RAW_BLACK_TUNGSTEN, "Raw Black Tungsten");
        addItem(NchItems.BLACK_TUNGSTEN_DUST, "Black Tungsten Dust");
        addItem(NchItems.BLACK_TUNGSTEN_INGOT, "Black Tungsten Ingot");
        addItem(NchItems.BLACK_TUNGSTEN_NUGGET, "Black Tungsten Nugget");

        addBlock(NchBlocks.WHITE_BUD_BUSH, "White Bud");
//        addBlock(NchBlocks.SILVERBLANC_STONE, "Silverblanc Stone");
//        addBlock(NchBlocks.SILVERBLANC_IRON_ORE, "Silverblanc Iron Ore");
//        addBlock(NchBlocks.SILVERBLANC_BLOCK_TUNGSTEN_ORE, "Silverblanc Black Tungsten Ore");
//        addBlock(NchBlocks.SILVERBLANC_GOLD_ORE, "Silverblanc Gold Ore");
//        addBlock(NchBlocks.SILVERBLANC_DIAMOND_ORE, "Silverblanc Diamond Ore");
//        addBlock(NchBlocks.COSMIC_SAND, "Cosmic Sand");
    }

    private void addGroup(CreativeModeTab tab, String name) {
        add(((TranslatableComponent) tab.getDisplayName()).getKey(), name);
    }
}
