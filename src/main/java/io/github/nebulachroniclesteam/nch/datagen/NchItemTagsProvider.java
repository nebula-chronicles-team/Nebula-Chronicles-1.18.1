package io.github.nebulachroniclesteam.nch.datagen;

import io.github.nebulachroniclesteam.nch.NebulaChronicles;
import io.github.nebulachroniclesteam.nch.item.NchItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class NchItemTagsProvider extends ItemTagsProvider {

    public NchItemTagsProvider(DataGenerator pGenerator, BlockTagsProvider pBlockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, pBlockTagsProvider, NebulaChronicles.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(NchItemTags.AXES_TOOLS).add(Items.WOODEN_AXE, Items.IRON_AXE, Items.DIAMOND_AXE, Items.GOLDEN_AXE, Items.NETHERITE_AXE, Items.STONE_AXE);
        tag(NchItemTags.AXES).addTag(NchItemTags.AXES_TOOLS);
    }
}
