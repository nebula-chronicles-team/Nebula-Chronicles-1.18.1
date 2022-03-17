package io.github.nebulachroniclesteam.nch.register;

import io.github.nebulachroniclesteam.nch.NebulaChronicles;
import io.github.nebulachroniclesteam.nch.blockentity.CoarseCactusBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NchBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, NebulaChronicles.MOD_ID);

    public static final RegistryObject<BlockEntityType<?>> COARSE_CACTUS = register(NchBlocks.COARSE_CACTUS, CoarseCactusBlockEntity::new);

    private static <T extends BlockEntity> RegistryObject<BlockEntityType<?>> register(RegistryObject<Block> block,
                                                                                       BlockEntityType.BlockEntitySupplier<T> entity) {
        return BLOCK_ENTITIES.register(block.getId().getPath(), () -> BlockEntityType.Builder.of(entity, block.get()).build(null));
    }
}
