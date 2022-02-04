package io.github.nebulachroniclesteam.nch.item;

import io.github.nebulachroniclesteam.nch.register.NchCreativeModeTab;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class LanternBerries extends Item {
    public LanternBerries() {
        super(
                new Item.Properties().
                        tab(NchCreativeModeTab.NCH_ITEMS).food(
                                (new FoodProperties.Builder())
                                        .nutrition(3)
                                        .saturationMod(0.3F)
                                        .effect(new MobEffectInstance(MobEffects.GLOWING, 300, 0), 1.0F)
                                        .effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0), 1.0F)
                                        .build()
                        )
        );
    }
}
