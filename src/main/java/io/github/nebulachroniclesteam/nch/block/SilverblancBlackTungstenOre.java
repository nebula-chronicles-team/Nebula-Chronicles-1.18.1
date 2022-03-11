package io.github.nebulachroniclesteam.nch.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MaterialColor;

public class SilverblancBlackTungstenOre extends Block {
    public SilverblancBlackTungstenOre() {
        super(Properties.copy(Blocks.IRON_ORE)
                .color(MaterialColor.CLAY)
                .strength(2, 6));
    }
}
