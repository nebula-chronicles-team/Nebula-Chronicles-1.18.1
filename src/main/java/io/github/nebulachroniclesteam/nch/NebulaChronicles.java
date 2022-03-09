package io.github.nebulachroniclesteam.nch;

import io.github.nebulachroniclesteam.nch.register.NchBlocks;
import io.github.nebulachroniclesteam.nch.register.NchItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(NebulaChronicles.MOD_ID)
public class NebulaChronicles {
    public static final String MOD_ID = "nch";

    // register
    public NebulaChronicles() {
        NchBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        NchItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
