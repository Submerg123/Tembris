package net.submerg.tembris;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.submerg.tembris.block.ModBlocks;
import net.submerg.tembris.item.ModCreativeModeTabs;
import net.submerg.tembris.item.ModItems;
import org.slf4j.Logger;

// <------------------------------------------------------------------------------>
// The following describes the idiosyncratic conventions of this mod's Doc comments.
//
// The keywords "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT", "SHOULD",
// "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL" in this mod's Doc Comments
// are to be interpreted as described in RFC 2119.
//
// The capitalization of various terms is simply a personal preference.
//
// The term "Implementer" in the documentation of Interfaces refers to a class
// which is Implementing the Interface.
@Mod(Tembris.MOD_ID)
public class Tembris {
    public static final String MOD_ID = "tembris";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Tembris() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
