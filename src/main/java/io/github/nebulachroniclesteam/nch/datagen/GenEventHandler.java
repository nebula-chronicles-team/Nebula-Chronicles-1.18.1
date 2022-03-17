package io.github.nebulachroniclesteam.nch.datagen;

import io.github.nebulachroniclesteam.nch.NebulaChronicles;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = NebulaChronicles.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GenEventHandler {

    @SubscribeEvent
    public static void onGather(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        NchBlockTagsProvider bp;

        generator.addProvider(new NchBlockStateProvider(generator, existingFileHelper));
        generator.addProvider(new NchItemModelProvider(generator, existingFileHelper));
        generator.addProvider(new NchLangProviderEn(generator));
        generator.addProvider(new NchLangProviderZh(generator));
        generator.addProvider(bp = new NchBlockTagsProvider(generator, existingFileHelper));
        generator.addProvider(new NchItemTagsProvider(generator, bp, existingFileHelper));
        generator.addProvider(new NchLootProvider(generator));
        generator.addProvider(new NchRecipeProvider(generator));
    }
}
