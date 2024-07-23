package net.submerg.tembris.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.submerg.tembris.Tembris;

public class ModItems {
    public  static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Tembris.MOD_ID);

    public static final RegistryObject<Item> TEMBRAL_COPPER_INGOT = ITEMS.register("tembral_copper_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TEMBRAL_IRON_INGOT = ITEMS.register("tembral_iron_ingot",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
