package io.github.nebulachroniclesteam.nch;

import io.github.nebulachroniclesteam.nch.register.NchBlocks;
import io.github.nebulachroniclesteam.nch.register.NchItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.Logger;

@Mod(NebulaChronicles.MOD_ID)
public class NebulaChronicles {
    public static final String MOD_ID = "nch";
    // private static final Logger LOGGER = LogManager.getLogger();

    // register
    public NebulaChronicles() {
        NchBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        NchItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        // NchTileEntityTypes.TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        // NchContainerTypes.CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(this);
    }

}
