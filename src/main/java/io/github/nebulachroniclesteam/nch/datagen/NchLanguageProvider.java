package io.github.nebulachroniclesteam.nch.datagen;

import io.github.nebulachroniclesteam.nch.NebulaChronicles;
import io.github.nebulachroniclesteam.nch.register.NchBlocks;
import io.github.nebulachroniclesteam.nch.register.NchItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;

import java.io.IOException;
import java.util.function.Supplier;

public class NchLanguageProvider implements DataProvider {

    private final LanguageProvider en, zh;

    public NchLanguageProvider(DataGenerator generator) {
        this.en = new SubProvider(generator, "en_us");
        this.zh = new SubProvider(generator, "zh_cn");
    }

    private void addTranslations() {
        addItem(NchItems.WHITE_BUD_LEAVES, "White Bud Leaves", "白芽叶片");
        addBlock(NchBlocks.WHITE_BUD_BUSH, "White Bud", "白芽灌木");
    }

    public void addBlock(Supplier<? extends Block> key, String en, String zh) {
        this.zh.addBlock(key, zh);
        this.en.addBlock(key, en);
    }

    public void addItem(Supplier<? extends Item> key, String en, String zh) {
        this.zh.addItem(key, zh);
        this.en.addItem(key, en);
    }

    @Override
    public void run(HashCache pCache) throws IOException {
        addTranslations();
        en.run(pCache);
        zh.run(pCache);
    }

    @Override
    public String getName() {
        return "Languages: en_us & zh_cn";
    }

    protected static class SubProvider extends LanguageProvider {

        public SubProvider(DataGenerator gen, String locale) {
            super(gen, NebulaChronicles.MOD_ID, locale);
        }

        @Override
        protected void addTranslations() {
        }
    }
}
