package io.github.nebulachroniclesteam.nch.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class WhiteBudLeafBlock extends Block {

    public WhiteBudLeafBlock() {
        super(Properties.of(Material.WOOL, MaterialColor.QUARTZ)
                .sound(SoundType.WOOL)
                .strength(0.7f, 0.7f));
    }
}
