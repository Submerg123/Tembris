package net.submerg.tembris.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.submerg.tembris.Tembris;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> SUNWOOD_LOGS = tag("sunwood_logs");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Tembris.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Tembris.MOD_ID, name));
        }
    }
}
