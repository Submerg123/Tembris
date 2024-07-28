package net.submerg.tembris.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.submerg.tembris.Tembris;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = Tembris.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput pOutput = generator.getPackOutput();
        ExistingFileHelper existingFH = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new ModRecipeProvider(pOutput));
        generator.addProvider(event.includeServer(), ModLootTableProvider.create(pOutput));

        generator.addProvider(event.includeClient(), new ModBlockStateProvider(pOutput, existingFH));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(pOutput, existingFH));

        ModBlockTagsProvider blockTagsProvider = generator.addProvider(event.includeServer(),
                new ModBlockTagsProvider(pOutput, lookupProvider, existingFH));
        generator.addProvider(event.includeServer(), new ModItemTagsProvider(pOutput, lookupProvider,
                blockTagsProvider.contentsGetter(), existingFH));

        generator.addProvider(event.includeServer(), new ModWorldgenProvider(pOutput, lookupProvider));
    }
}
