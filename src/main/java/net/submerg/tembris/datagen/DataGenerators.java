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
        DataGenerator gen = event.getGenerator();
        PackOutput pOutput = gen.getPackOutput();
        ExistingFileHelper existingFH = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        gen.addProvider(event.includeServer(), new ModRecipeProvider(pOutput));
        gen.addProvider(event.includeServer(), ModLootTableProvider.create(pOutput));

        gen.addProvider(event.includeClient(), new ModBlockStateProvider(pOutput, existingFH));
        gen.addProvider(event.includeClient(), new ModItemModelProvider(pOutput, existingFH));

        ModBlockTagsProvider blockTagsProvider = gen.addProvider(event.includeServer(),
                new ModBlockTagsProvider(pOutput, lookupProvider, existingFH));
        gen.addProvider(event.includeServer(), new ModItemTagsProvider(pOutput, lookupProvider,
                blockTagsProvider.contentsGetter(), existingFH));
    }
}
