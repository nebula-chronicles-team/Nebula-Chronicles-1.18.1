package io.github.nebulachroniclesteam.nch.handler;

import io.github.nebulachroniclesteam.nch.register.NchBlocks;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.GrassColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientRegisterEventHandler {

    @SubscribeEvent
    public static void onRegisterBlockRenderType(ModelRegistryEvent event) {
        ItemBlockRenderTypes.setRenderLayer(NchBlocks.WHITE_BUD_BUSH.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(NchBlocks.WHITE_BUD.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(NchBlocks.STRANGE_FERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(NchBlocks.LANTERN_BERRIES_PLANT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(NchBlocks.COARSE_CACTUS.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(NchBlocks.COARSE_CACTUS_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(NchBlocks.COARSE_CACTUS_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(NchBlocks.BLUE_KODOKU_FLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(NchBlocks.PURPLE_KODOKU_FLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(NchBlocks.WHITE_KODOKU_FLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(NchBlocks.POTTED_BLUE_KODOKU_FLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(NchBlocks.POTTED_PURPLE_KODOKU_FLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(NchBlocks.POTTED_WHITE_KODOKU_FLOWER.get(), RenderType.cutout());
    }

    @SubscribeEvent
    public static void onRegisterBlockColor(ColorHandlerEvent.Block event) {
        event.getBlockColors().register((pState, pLevel, pPos, pTintIndex) ->
                        getBiomeColor(pLevel, pPos, GrassColor.get(0.5, 1)), NchBlocks.WHITE_BUD_BUSH.get());
    }

    private static int getBiomeColor(@Nullable BlockAndTintGetter level, @Nullable BlockPos pos, int defColor) {
        return level != null && pos != null ? BiomeColors.getAverageGrassColor(level, pos) : defColor;
    }
}
