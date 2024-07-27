package net.submerg.tembris.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.submerg.tembris.Tembris;
import net.submerg.tembris.block.ModBlocks;
import net.submerg.tembris.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, Tembris.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Items.SUNWOOD_LOGS)
                .add(ModBlocks.DAWNWOOD_LOG.get().asItem(),
                        ModBlocks.DAWNWOOD_WOOD.get().asItem());

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.DAWNWOOD_LOG.get().asItem(),
                        ModBlocks.DAWNWOOD_WOOD.get().asItem(),
                        ModBlocks.STRIPPED_DAWNWOOD_LOG.get().asItem(),
                        ModBlocks.STRIPPED_DAWNWOOD_WOOD.get().asItem());
        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.DAWNWOOD_PLANKS.get().asItem());
        this.tag(ItemTags.LEAVES)
                .add(ModBlocks.DAWNWOOD_LEAVES.get().asItem());
    }
}
