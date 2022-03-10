package io.github.nebulachroniclesteam.nch.datagen;

import io.github.nebulachroniclesteam.nch.NebulaChronicles;
import io.github.nebulachroniclesteam.nch.register.NchBlocks;
import io.github.nebulachroniclesteam.nch.register.NchCreativeModeTab;
import io.github.nebulachroniclesteam.nch.register.NchItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.data.LanguageProvider;

public class NchLangProviderZh extends LanguageProvider {

    public NchLangProviderZh(DataGenerator gen) {
        super(gen, NebulaChronicles.MOD_ID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        addGroup(NchCreativeModeTab.NCH_WORLD, "星云纪事 - 世界");
        addGroup(NchCreativeModeTab.NCH_MISC_ITEMS, "星云纪事 - 杂项");
        addGroup(NchCreativeModeTab.NCH_INDUSTRIAL_ITEMS, "星云纪事 - 工业物品");
        addGroup(NchCreativeModeTab.NCH_INDUSTRIAL_BLOCKS, "星云纪事 - 工业方块");

        addItem(NchItems.BUG_FLESH, "虫肉");
        addItem(NchItems.WHITE_BUD_STEW, "白芽炖");
        addItem(NchItems.WHITE_BUD_LEAVES, "白芽叶片");
        addItem(NchItems.LANTERN_BERRIES, "灯笼浆果");
//        addItem(NchItems.RAW_IRON, "Raw Iron");
//        addItem(NchItems.RAW_Gold, "Raw Gold");
        addItem(NchItems.RAW_BLACK_TUNGSTEN, "粗青钨");
        addItem(NchItems.BLACK_TUNGSTEN_DUST, "青钨粉");
        addItem(NchItems.BLACK_TUNGSTEN_INGOT, "青钨锭");
        addItem(NchItems.BLACK_TUNGSTEN_NUGGET, "青钨粒");

        addBlock(NchBlocks.WHITE_BUD_BUSH, "白芽灌木");
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
