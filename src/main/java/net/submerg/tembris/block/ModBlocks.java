package net.submerg.tembris.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.submerg.tembris.Tembris;
import net.submerg.tembris.block.custom.ModLeavesBlock;
import net.submerg.tembris.block.custom.PlanksBlock;
import net.submerg.tembris.block.custom.WoodLikeBlock;
import net.submerg.tembris.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Tembris.MOD_ID);

    // TODO add dawnwood decorative blocks
    public static final RegistryObject<Block> DAWNWOOD_LOG = registerBlock("dawnwood_log",
            () -> new WoodLikeBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> DAWNWOOD_WOOD = registerBlock("dawnwood_wood",
            () -> new WoodLikeBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_DAWNWOOD_LOG = registerBlock("stripped_dawnwood_log",
            () -> new WoodLikeBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_DAWNWOOD_WOOD = registerBlock("stripped_dawnwood_wood",
            () -> new WoodLikeBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> DAWNWOOD_PLANKS = registerBlock("dawnwood_planks",
            () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> DAWNWOOD_LEAVES = registerBlock("dawnwood_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));

// TODO add dawnstone decorative blocks
    public static final RegistryObject<Block> DAWNSTONE = registerBlock("dawnstone",
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> COBBLED_DAWNSTONE = registerBlock("cobbled_dawnstone",
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
