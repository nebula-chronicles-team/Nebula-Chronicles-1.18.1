package io.github.nebulachroniclesteam.nch.datagen;

import io.github.nebulachroniclesteam.nch.NebulaChronicles;
import io.github.nebulachroniclesteam.nch.register.NchBlocks;
import io.github.nebulachroniclesteam.nch.register.NchItems;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.EnterBlockTrigger;
import net.minecraft.core.Registry;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class NchRecipeProvider extends RecipeProvider {

    private Map<BlockFamily.Variant, BiFunction<ItemLike, ItemLike, RecipeBuilder>> shapeBuilders = Collections.emptyMap();

    public NchRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
        for (Field field : RecipeProvider.class.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers()) && Map.class.isAssignableFrom(field.getType())) {
                field.setAccessible(true);
                try {
                    shapeBuilders = (Map<BlockFamily.Variant, BiFunction<ItemLike, ItemLike, RecipeBuilder>>) field.get(null);
                    break;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        generateRecipes(pFinishedRecipeConsumer, addBlockFamily(NchBlocks.COARSE_CACTUS_PLANKS.get())
                .fence(NchBlocks.COARSE_CACTUS_FENCE.get())
                .fenceGate(NchBlocks.COARSE_CACTUS_FENCE_GATE.get())
                .slab(NchBlocks.COARSE_CACTUS_SLABS.get())
                .stairs(NchBlocks.COARSE_CACTUS_STAIRS.get())
                .door(NchBlocks.COARSE_CACTUS_DOOR.get())
                .trapdoor(NchBlocks.COARSE_CACTUS_TRAPDOOR.get())
                // begin use birch
                .pressurePlate(Blocks.BIRCH_PRESSURE_PLATE)
                .button(Blocks.BIRCH_BUTTON)
                .sign(Blocks.BIRCH_SIGN, Blocks.BIRCH_WALL_SIGN)
                // end use birch
                .dontGenerateModel()
                .recipeGroupPrefix("wooden")
                .recipeUnlockedBy("has_planks"));
        generateRecipes(pFinishedRecipeConsumer, addBlockFamily(NchBlocks.SILVERBLANC_STONE_BRICKS.get())
                .stairs(NchBlocks.SILVERBLANC_STONE_BRICKS_STAIRS.get())
                .slab(NchBlocks.SILVERBLANC_STONE_BRICKS_SLAB.get())
                .dontGenerateModel()
                .recipeGroupPrefix("silverblanc")
                .recipeUnlockedBy("has_items"));

        EnterBlockTrigger.TriggerInstance inWater = EnterBlockTrigger.TriggerInstance.entersBlock(Blocks.WATER);

        ShapelessRecipeBuilder.shapeless(NchBlocks.COARSE_CACTUS_PLANKS.get(), 4)
                .group("planks")
                .requires(NchBlocks.COARSE_CACTUS.get())
                .unlockedBy("has_log", has(NchBlocks.COARSE_CACTUS.get()))
                .save(pFinishedRecipeConsumer);

        RenamedRecipeBuilder.mod(ShapedRecipeBuilder.shaped(Items.BIRCH_BOAT)
                .group("boat")
                .define('#', NchBlocks.COARSE_CACTUS_PLANKS.get())
                .pattern("# #")
                .pattern("###")
                .unlockedBy("in_water", inWater))
                .save(pFinishedRecipeConsumer);

        RenamedRecipeBuilder.mod(ShapelessRecipeBuilder.shapeless(Items.GREEN_DYE)
                .group("dye")
                .requires(NchBlocks.STRANGE_FERN.get())
                .unlockedBy("has_item", has(NchBlocks.STRANGE_FERN.get())))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(NchItems.LANTERN_BERRIES.get())
                .group("food")
                .requires(NchBlocks.LANTERN_BERRIES_PLANT.get())
                .unlockedBy("has_item", has(NchBlocks.LANTERN_BERRIES_PLANT.get()))
                .save(pFinishedRecipeConsumer);
    }

    private void generateRecipes(Consumer<FinishedRecipe> consumer, BlockFamily.Builder pFamily) {
        BlockFamily family = pFamily.getFamily();
        family.getVariants().forEach((variant, block) -> {
            BiFunction<ItemLike, ItemLike, RecipeBuilder> biFunction = shapeBuilders.get(variant);
            ItemLike itemlike = getBaseBlock(family, variant);
            if (biFunction != null) {
                BiFunction<ItemLike, ItemLike, RecipeBuilder> function = (i1, i2) ->
                        RenamedRecipeBuilder.mod(shapeBuilders.get(variant).apply(i1, i2));
                RecipeBuilder recipebuilder = function.apply(block, itemlike);
                family.getRecipeGroupPrefix().ifPresent((s) ->
                        recipebuilder.group(s + (variant == BlockFamily.Variant.CUT ? "" : "_" + variant.getName())));
                recipebuilder.unlockedBy(family.getRecipeUnlockedBy()
                        .orElseGet(() -> "has_" + Registry.ITEM.getKey(itemlike.asItem()).getPath()), has(itemlike));
                recipebuilder.save(consumer);
            }

            if (variant == BlockFamily.Variant.CRACKED) {
                SimpleCookingRecipeBuilder.smelting(Ingredient.of(itemlike), block, 0.1F, 200)
                        .unlockedBy("has_" + Registry.ITEM.getKey(itemlike.asItem()).getPath(), has(itemlike))
                        .save(consumer);
            }

        });
    }

    private static Block getBaseBlock(BlockFamily pFamily, BlockFamily.Variant pVariant) {
        if (pVariant == BlockFamily.Variant.CHISELED) {
            if (!pFamily.getVariants().containsKey(BlockFamily.Variant.SLAB)) {
                throw new IllegalStateException("Slab is not defined for the family.");
            } else {
                return pFamily.get(BlockFamily.Variant.SLAB);
            }
        } else {
            return pFamily.getBaseBlock();
        }
    }

    private BlockFamily.Builder addBlockFamily(Block block) {
        for (Method method : BlockFamilies.class.getDeclaredMethods()) {
            // function like BlockFamily.Builder xxx(Block);
            if (Modifier.isStatic(method.getModifiers())
                    && method.getReturnType() == BlockFamily.Builder.class
                    && method.getParameterCount() == 1
                    && method.getParameterTypes()[0] == Block.class) {
                method.setAccessible(true);
                try {
                    return (BlockFamily.Builder) method.invoke(null, block);
                } catch (InvocationTargetException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        throw new RuntimeException("Not found method like BlockFamily.Builder xxx(Block);");
    }

    record RenamedRecipeBuilder(RecipeBuilder builder,
                                Function<ResourceLocation, ResourceLocation> name) implements RecipeBuilder {

        static RenamedRecipeBuilder mod(RecipeBuilder builder) {
            return new RenamedRecipeBuilder(builder, name -> new ResourceLocation(NebulaChronicles.MOD_ID, name.getPath()));
        }

        @Override

        public RecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
            return builder.unlockedBy(pCriterionName, pCriterionTrigger);
        }

        @Override
        public RecipeBuilder group(@Nullable String pGroupName) {
            return builder.group(pGroupName);
        }

        @Override
        public Item getResult() {
            return builder.getResult();
        }

        @Override
        public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
            builder.save(pFinishedRecipeConsumer, name.apply(pRecipeId));
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (RenamedRecipeBuilder) obj;
            return Objects.equals(this.builder, that.builder);
        }

        @Override
        public int hashCode() {
            return Objects.hash(builder);
        }

        @Override
        public String toString() {
            return "RenamedRecipeBuilder[" +
                    "builder=" + builder + ']';
        }

    }
}
