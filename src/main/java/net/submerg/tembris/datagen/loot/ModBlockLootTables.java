package net.submerg.tembris.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.submerg.tembris.block.ModBlocks;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.DAWNWOOD_LOG.get());
        this.dropSelf(ModBlocks.DAWNWOOD_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_DAWNWOOD_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_DAWNWOOD_WOOD.get());
        this.dropSelf(ModBlocks.DAWNWOOD_PLANKS.get());

        this.add(ModBlocks.DAWNWOOD_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.DAWNWOOD_LOG.get(), NORMAL_LEAVES_SAPLING_CHANCES)); // TODO change to `sunwood_sapling`
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
