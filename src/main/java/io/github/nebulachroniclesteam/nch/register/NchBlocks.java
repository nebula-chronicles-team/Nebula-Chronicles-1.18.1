package io.github.nebulachroniclesteam.nch.register;

import io.github.nebulachroniclesteam.nch.NebulaChronicles;
import io.github.nebulachroniclesteam.nch.block.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NchBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NebulaChronicles.MOD_ID);

    public static final RegistryObject<Block> COSMIC_SAND = BLOCKS.register("cosmic_sand", CosmicSand::new);
    public static final RegistryObject<Block> COSMIC_SANDSTONE = BLOCKS.register("cosmic_sandstone", CosmicSandstone::new);
    public static final RegistryObject<Block> SILVERBLANC_STONE = BLOCKS.register("silverblanc_stone", SilverblancStone::new);
    public static final RegistryObject<Block> MOSS_SILVERBLANC_STONE = BLOCKS.register("moss_silverblanc_stone", MossSilverblancStone::new);
    public static final RegistryObject<Block> SILVERBLANC_STONE_BRICKS = BLOCKS.register("silverblanc_stone_bricks", SilverblancStoneBricks::new);
    public static final RegistryObject<Block> CHISELED_SILVERBLANC_STONE_BRICKS = BLOCKS.register("chiseled_silverblanc_stone_bricks", SilverblancStoneBricks::new);
    public static final RegistryObject<Block> SILVERBLANC_IRON_ORE = BLOCKS.register("silverblanc_iron_ore", SilverblancIronOre::new);
    public static final RegistryObject<Block> SILVERBLANC_GOLD_ORE = BLOCKS.register("silverblanc_gold_ore", SilverblancGoldOre::new);
    public static final RegistryObject<Block> SILVERBLANC_BLACK_TUNGSTEN_ORE = BLOCKS.register("silverblanc_black_tungsten_ore", SilverblancBlackTungstenOre::new);
    public static final RegistryObject<Block> SILVERBLANC_BEDROCK_DIAMOND_ORE = BLOCKS.register("silverblanc_bedrock_diamond_ore", SilverblancBlackTungstenOre::new);
    public static final RegistryObject<Block> WHITE_BUD = BLOCKS.register("white_bud", WhiteBud::new);
    public static final RegistryObject<Block> WHITE_BUD_BUSH = BLOCKS.register("white_bud_bush", WhiteBudBush::new);
/*
white_bud_leaf_block
strange_fern
lantern_berries_plant
coarse_cactus
blue_kodoku_flower
purple_kodoku_flower
white_kodoku_flower
*/

}
