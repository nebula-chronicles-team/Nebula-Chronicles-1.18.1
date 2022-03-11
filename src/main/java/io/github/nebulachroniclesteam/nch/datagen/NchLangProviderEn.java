package io.github.nebulachroniclesteam.nch.datagen;

import io.github.nebulachroniclesteam.nch.NebulaChronicles;
import io.github.nebulachroniclesteam.nch.register.NchBlocks;
import io.github.nebulachroniclesteam.nch.register.NchCreativeModeTab;
import io.github.nebulachroniclesteam.nch.register.NchItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

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

        addItem(NchItems.BUG_FLESH);
        addItem(NchItems.WHITE_BUD_STEW);
        addItem(NchItems.WHITE_BUD_LEAVES);
        addItem(NchItems.LANTERN_BERRIES);
//        addItem(NchItems.RAW_IRON, "Raw Iron");
//        addItem(NchItems.RAW_Gold, "Raw Gold");
        addItem(NchItems.RAW_BLACK_TUNGSTEN);
        addItem(NchItems.BLACK_TUNGSTEN_DUST);
        addItem(NchItems.BLACK_TUNGSTEN_INGOT);
        addItem(NchItems.BLACK_TUNGSTEN_NUGGET);

        addBlock(NchBlocks.WHITE_BUD_BUSH, "White Bud");
        addBlock(NchBlocks.COSMIC_SAND);
        addBlock(NchBlocks.COSMIC_SANDSTONE);
        addBlock(NchBlocks.SILVERBLANC_STONE);
        addBlock(NchBlocks.MOSS_SILVERBLANC_STONE);
        addBlock(NchBlocks.SILVERBLANC_STONE_BRICKS);
        addBlock(NchBlocks.CHISELED_SILVERBLANC_STONE_BRICKS);
        addBlock(NchBlocks.SILVERBLANC_IRON_ORE);
        addBlock(NchBlocks.SILVERBLANC_GOLD_ORE);
        addBlock(NchBlocks.SILVERBLANC_BLACK_TUNGSTEN_ORE);
        addBlock(NchBlocks.SILVERBLANC_BEDROCK_DIAMOND_ORE);
        addBlock(NchBlocks.WHITE_BUD);
    }

    private void addGroup(CreativeModeTab tab, String name) {
        add(((TranslatableComponent) tab.getDisplayName()).getKey(), name);
    }

    private void addItem(RegistryObject<? extends Item> object) {
        addItem(object, nameFromId(object.getId().getPath()));
    }

    private void addBlock(RegistryObject<? extends Block> object) {
        addBlock(object, nameFromId(object.getId().getPath()));
    }

    private String nameFromId(String id) {
        return Arrays.stream(id.split("_"))
                .map(s -> s.charAt(0) + s.substring(1).toLowerCase(Locale.ROOT))
                .collect(Collectors.joining(" "));
    }
}
