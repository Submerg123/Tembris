package net.submerg.tembris.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.submerg.tembris.block.ModBlocks;
import net.submerg.tembris.util.ModTags;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        planksFromLogs(consumer, ModBlocks.DAWNWOOD_PLANKS.get(), ModTags.Items.SUNWOOD_LOGS, 4);
        woodFromLogs(consumer, ModBlocks.DAWNWOOD_WOOD.get(), ModBlocks.DAWNWOOD_LOG.get());
        woodFromLogs(consumer, ModBlocks.STRIPPED_DAWNWOOD_WOOD.get(), ModBlocks.STRIPPED_DAWNWOOD_LOG.get());
    }
}
