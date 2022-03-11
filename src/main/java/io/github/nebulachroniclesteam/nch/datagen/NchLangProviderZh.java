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
        addBlock(NchBlocks.COSMIC_SAND, "太空砂");
        addBlock(NchBlocks.COSMIC_SANDSTONE, "太空砂岩");
        addBlock(NchBlocks.SILVERBLANC_STONE, "银白岩");
        addBlock(NchBlocks.MOSS_SILVERBLANC_STONE, "苔藓银白岩");
        addBlock(NchBlocks.SILVERBLANC_STONE_BRICKS, "银白石砖");
        addBlock(NchBlocks.CHISELED_SILVERBLANC_STONE_BRICKS, "錾制银白石砖");
        addBlock(NchBlocks.SILVERBLANC_IRON_ORE, "银白铁矿");
        addBlock(NchBlocks.SILVERBLANC_GOLD_ORE, "银白金矿");
        addBlock(NchBlocks.SILVERBLANC_BLACK_TUNGSTEN_ORE, "银白青钨矿");
        addBlock(NchBlocks.SILVERBLANC_BEDROCK_DIAMOND_ORE, "银白基岩钻石矿");
        addBlock(NchBlocks.WHITE_BUD, "白芽");
    }

    private void addGroup(CreativeModeTab tab, String name) {
        add(((TranslatableComponent) tab.getDisplayName()).getKey(), name);
    }
}
