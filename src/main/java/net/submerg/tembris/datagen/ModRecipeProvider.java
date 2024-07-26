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
        planksFromLogs(consumer, ModBlocks.SUNWOOD_PLANKS.get(), ModTags.Items.SUNWOOD_LOGS, 4);
        woodFromLogs(consumer, ModBlocks.SUNWOOD_WOOD.get(), ModBlocks.SUNWOOD_LOG.get());
    }
}
