package net.submerg.tembris.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.submerg.tembris.Tembris;
import net.submerg.tembris.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Tembris.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        logBlockWithItem(((RotatedPillarBlock) ModBlocks.DAWNWOOD_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.DAWNWOOD_WOOD.get()), blockTexture(ModBlocks.DAWNWOOD_LOG.get()),
                blockTexture(ModBlocks.DAWNWOOD_LOG.get()));
        blockItem(ModBlocks.DAWNWOOD_WOOD.get());
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_DAWNWOOD_LOG.get()), blockTexture(ModBlocks.STRIPPED_DAWNWOOD_LOG.get()),
                new ResourceLocation(Tembris.MOD_ID, "block/" + ModBlocks.STRIPPED_DAWNWOOD_LOG.getId().getPath() + "_top"));
        blockItem(ModBlocks.STRIPPED_DAWNWOOD_LOG.get());
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_DAWNWOOD_WOOD.get()), blockTexture(ModBlocks.STRIPPED_DAWNWOOD_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_DAWNWOOD_LOG.get()));
        blockItem(ModBlocks.STRIPPED_DAWNWOOD_WOOD.get());
        blockWithItem(ModBlocks.DAWNWOOD_PLANKS.get());
        leavesBlock(ModBlocks.DAWNWOOD_LEAVES.get());
    }

    private void blockItem(Block block) {
        simpleBlockItem(block, new ModelFile.UncheckedModelFile(Tembris.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(block).getPath()));
    }

    private void blockWithItem(Block block) {
        simpleBlockWithItem(block, cubeAll(block));
    }

    private void logBlockWithItem(RotatedPillarBlock block) {
        logBlock(block);
        blockItem(block);
    }

    private void leavesBlock(Block block) {
        simpleBlockWithItem(block,
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(block).getPath(),
                        new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(block)).renderType("cutout"));
    }
}