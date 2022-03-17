package io.github.nebulachroniclesteam.nch.register;

import io.github.nebulachroniclesteam.nch.NebulaChronicles;
import io.github.nebulachroniclesteam.nch.block.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class NchBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NebulaChronicles.MOD_ID);

    public static final RegistryObject<Block> COSMIC_SAND = register("cosmic_sand", CosmicSand::new);
    public static final RegistryObject<Block> COSMIC_SANDSTONE = register("cosmic_sandstone", CosmicSandstone::new);
    public static final RegistryObject<Block> SILVERBLANC_STONE = register("silverblanc_stone", SilverblancStone::new);
    public static final RegistryObject<Block> MOSS_SILVERBLANC_STONE = register("moss_silverblanc_stone", MossSilverblancStone::new);
    public static final RegistryObject<Block> SILVERBLANC_STONE_BRICKS = register("silverblanc_stone_bricks", SilverblancStoneBricks::new);
    public static final RegistryObject<Block> CHISELED_SILVERBLANC_STONE_BRICKS = register("chiseled_silverblanc_stone_bricks", SilverblancStoneBricks::new);
    public static final RegistryObject<Block> SILVERBLANC_IRON_ORE = register("silverblanc_iron_ore", SilverblancIronOre::new);
    public static final RegistryObject<Block> SILVERBLANC_GOLD_ORE = register("silverblanc_gold_ore", SilverblancGoldOre::new);
    public static final RegistryObject<Block> SILVERBLANC_BLACK_TUNGSTEN_ORE = register("silverblanc_black_tungsten_ore", SilverblancBlackTungstenOre::new);
    public static final RegistryObject<Block> SILVERBLANC_BEDROCK_DIAMOND_ORE = register("silverblanc_bedrock_diamond_ore", SilverblancBlackTungstenOre::new);
    public static final RegistryObject<Block> WHITE_BUD = register("white_bud", WhiteBud::new);
    public static final RegistryObject<Block> WHITE_BUD_BUSH = register("white_bud_bush", WhiteBudBush::new);
    public static final RegistryObject<Block> WHITE_BUD_LEAF_BLOCK = register("white_bud_leaf_block", WhiteBudLeafBlock::new);
    public static final RegistryObject<Block> STRANGE_FERN = register("strange_fern", StrangeFern::new);
    public static final RegistryObject<Block> LANTERN_BERRIES_PLANT = register("lantern_berries_plant", LanternBerriesPlant::new);
    public static final RegistryObject<Block> COARSE_CACTUS = register("coarse_cactus", CoarseCactus::new);
    public static final RegistryObject<Block> COARSE_CACTUS_PLANKS = register("coarse_cactus_planks", CoarseCactusPlanks::new);
    public static final RegistryObject<Block> COARSE_CACTUS_STAIRS = register("coarse_cactus_stairs", CoarseCactusStairs::new);
    public static final RegistryObject<Block> COARSE_CACTUS_SLABS = register("coarse_cactus_slabs", CoarseCactusSlabs::new);
    public static final RegistryObject<Block> COARSE_CACTUS_FENCE = register("coarse_cactus_fence", CoarseCactusFence::new);
    public static final RegistryObject<Block> COARSE_CACTUS_FENCE_GATE = register("coarse_cactus_fence_gate", CoarseCactusFenceGate::new);
    public static final RegistryObject<Block> COARSE_CACTUS_TRAPDOOR = register("coarse_cactus_trapdoor", CoarseCactusTrapdoor::new);
    public static final RegistryObject<Block> COARSE_CACTUS_DOOR = register("coarse_cactus_door", CoarseCactusDoor::new);
    public static final RegistryObject<Block> BLUE_KODOKU_FLOWER = register("blue_kodoku_flower", BlueKodokuFlower::new);
    public static final RegistryObject<Block> PURPLE_KODOKU_FLOWER = register("purple_kodoku_flower", PurpleKodokuFlower::new);
    public static final RegistryObject<Block> WHITE_KODOKU_FLOWER = register("white_kodoku_flower", WhiteKodokuFlower::new);
    public static final RegistryObject<Block> POTTED_BLUE_KODOKU_FLOWER = register("potted_blue_kodoku_flower", () -> new NchPottedFlower(BLUE_KODOKU_FLOWER));
    public static final RegistryObject<Block> POTTED_PURPLE_KODOKU_FLOWER = register("potted_purple_kodoku_flower", () -> new NchPottedFlower(PURPLE_KODOKU_FLOWER));
    public static final RegistryObject<Block> POTTED_WHITE_KODOKU_FLOWER = register("potted_white_kodoku_flower", () -> new NchPottedFlower(WHITE_KODOKU_FLOWER));
    public static final RegistryObject<Block> SILVERBLANC_BEDROCK = register("silverblanc_bedrock", SilverblancBedrock::new);
    public static final RegistryObject<Block> SILVERBLANC_BEDROCK_IRON_ORE = register("silverblanc_bedrock_iron_ore", SilverblancBedrockIronOre::new);
    public static final RegistryObject<Block> SILVERBLANC_BEDROCK_GOLD_ORE = register("silverblanc_bedrock_gold_ore", SilverblancBedrockGoldOre::new);
    public static final RegistryObject<Block> SILVERBLANC_BEDROCK_BLACK_TUNGSTEN_ORE = register("silverblanc_bedrock_black_tungsten_ore", SilverblancBedrockBlackTungstenOre::new);
    public static final RegistryObject<Block> SILVERBLANC_STONE_BRICKS_STAIRS = register("silverblanc_stone_bricks_stair", SilverblancStoneBricksStair::new);
    public static final RegistryObject<Block> SILVERBLANC_STONE_BRICKS_SLAB = register("silverblanc_stone_bricks_slab", SilverblancStoneBricksSlab::new);

    private static RegistryObject<Block> register(String name, Supplier<? extends Block> supplier) {
        return BLOCKS.register(name, supplier);
    }
}
