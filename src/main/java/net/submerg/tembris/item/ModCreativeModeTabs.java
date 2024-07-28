package net.submerg.tembris.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.submerg.tembris.Tembris;
import net.submerg.tembris.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Tembris.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TEMBRIS_TAB = CREATIVE_MODE_TABS.register("tembris_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TEMBRAL_IRON_INGOT.get()))
                    .title(Component.translatable("creativetab.tembris_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.TEMBRAL_COPPER_INGOT.get());
                        output.accept(ModItems.TEMBRAL_IRON_INGOT.get());
                        
                        output.accept(ModBlocks.DAWNWOOD_LOG.get());
                        output.accept(ModBlocks.DAWNWOOD_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_DAWNWOOD_LOG.get());
                        output.accept(ModBlocks.STRIPPED_DAWNWOOD_WOOD.get());
                        output.accept(ModBlocks.DAWNWOOD_PLANKS.get());
                        output.accept(ModBlocks.DAWNWOOD_LEAVES.get());

                        output.accept(ModBlocks.DAWNSTONE.get());
                        output.accept(ModBlocks.COBBLED_DAWNSTONE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
