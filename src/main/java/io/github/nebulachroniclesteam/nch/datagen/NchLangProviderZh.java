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
        addBlock(NchBlocks.WHITE_BUD_LEAF_BLOCK, "白芽叶片块");
        addBlock(NchBlocks.STRANGE_FERN, "奇异蕨");
        addBlock(NchBlocks.LANTERN_BERRIES_PLANT, "灯笼浆果");
        addBlock(NchBlocks.COARSE_CACTUS, "太空仙人掌");
        addBlock(NchBlocks.COARSE_CACTUS_PLANKS, "太空仙人掌木板");
        addBlock(NchBlocks.COARSE_CACTUS_STAIRS, "太空仙人掌楼梯");
        addBlock(NchBlocks.COARSE_CACTUS_SLABS, "太空仙人掌台阶");
        addBlock(NchBlocks.COARSE_CACTUS_FENCE, "太空仙人掌栅栏");
        addBlock(NchBlocks.COARSE_CACTUS_FENCE_GATE, "太空仙人掌栅栏门");
        addBlock(NchBlocks.COARSE_CACTUS_TRAPDOOR, "太空仙人掌活板门");
        addBlock(NchBlocks.COARSE_CACTUS_DOOR, "太空仙人掌门");
        addBlock(NchBlocks.BLUE_KODOKU_FLOWER, "蓝色孤独花");
        addBlock(NchBlocks.PURPLE_KODOKU_FLOWER, "紫色孤独花");
        addBlock(NchBlocks.WHITE_KODOKU_FLOWER, "白色孤独花");
        addBlock(NchBlocks.POTTED_BLUE_KODOKU_FLOWER, "蓝色孤独花盆栽");
        addBlock(NchBlocks.POTTED_PURPLE_KODOKU_FLOWER, "紫色孤独花盆栽");
        addBlock(NchBlocks.POTTED_WHITE_KODOKU_FLOWER, "白色孤独花盆栽");
        addBlock(NchBlocks.SILVERBLANC_BEDROCK, "银白基岩");
        addBlock(NchBlocks.SILVERBLANC_BEDROCK_IRON_ORE, "银白基岩铁矿");
        addBlock(NchBlocks.SILVERBLANC_BEDROCK_GOLD_ORE, "银白基岩金矿");
        addBlock(NchBlocks.SILVERBLANC_BEDROCK_BLACK_TUNGSTEN_ORE, "银白基岩青钨矿");
        addBlock(NchBlocks.SILVERBLANC_STONE_BRICKS_STAIRS, "银白石砖楼梯");
        addBlock(NchBlocks.SILVERBLANC_STONE_BRICKS_SLAB, "银白石砖台阶");
    }

    private void addGroup(CreativeModeTab tab, String name) {
        add(((TranslatableComponent) tab.getDisplayName()).getKey(), name);
    }
}
