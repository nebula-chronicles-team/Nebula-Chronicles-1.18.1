package io.github.nebulachroniclesteam.nch;

import io.github.nebulachroniclesteam.nch.register.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(NebulaChronicles.MOD_ID)
public class NebulaChronicles {
    public static final String MOD_ID = "nch";

    // register
    public NebulaChronicles() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        NchBlocks.BLOCKS.register(bus);
        NchItems.ITEMS.register(bus);
        NchBlockEntities.BLOCK_ENTITIES.register(bus);
        NchBiomes.BIOMES.register(bus);
        NchCommands.COMMANDS.register();
    }
}
