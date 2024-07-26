package net.submerg.tembris.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.submerg.tembris.Tembris;
import net.submerg.tembris.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Tembris.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        logBlockWithItem(ModBlocks.SUNWOOD_LOG);
        woodBlockWithItem(ModBlocks.SUNWOOD_WOOD, ModBlocks.SUNWOOD_LOG);
        blockWithItem(ModBlocks.SUNWOOD_PLANKS);
    }

    private void blockWithItem(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }

    private void logBlockWithItem(RegistryObject<RotatedPillarBlock> block) {
        logBlock(block.get());
        simpleBlockItem(block.get(), cubeAll(block.get()));
    }

    private void woodBlockWithItem(RegistryObject<RotatedPillarBlock> wood, RegistryObject<RotatedPillarBlock> log) {
        ResourceLocation logName = log.getKey().location();
        ResourceLocation texture = new ResourceLocation(logName.getNamespace(), "block/" + logName.getPath());
        ModelFile model = models().cubeColumn(wood.getKey().location().getPath(),
                texture, texture);
        axisBlock(wood.get(), model, model);
        simpleBlockItem(wood.get(), model);
    }
}