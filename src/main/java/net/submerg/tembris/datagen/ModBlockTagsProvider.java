package net.submerg.tembris.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.submerg.tembris.Tembris;
import net.submerg.tembris.block.ModBlocks;
import net.submerg.tembris.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Tembris.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.SUNWOOD_LOGS)
                .add(ModBlocks.DAWNWOOD_LOG.get(),
                        ModBlocks.DAWNWOOD_WOOD.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.DAWNWOOD_LOG.get(),
                        ModBlocks.DAWNWOOD_WOOD.get(),
                        ModBlocks.STRIPPED_DAWNWOOD_LOG.get(),
                        ModBlocks.STRIPPED_DAWNWOOD_WOOD.get());
        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.DAWNWOOD_PLANKS.get());
        this.tag(BlockTags.LEAVES)
                .add(ModBlocks.DAWNWOOD_LEAVES.get());
    }
}
