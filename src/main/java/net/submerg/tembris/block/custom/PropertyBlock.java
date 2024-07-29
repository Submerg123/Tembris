package net.submerg.tembris.block.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.submerg.tembris.util.properties.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import oshi.util.tuples.Pair;

import java.util.List;

public abstract class PropertyBlock extends Block {
    public final List<Pair<String, ?>> PROPERTIES = List.of();

    public PropertyBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @Nullable BlockGetter level,
                                @NotNull List<Component> tooltip, @NotNull TooltipFlag isAdvanced) {
        this.PROPERTIES.forEach(pair -> {
            String property = pair.getA();
            Object value = pair.getB();
            PropertyDef<?> propertyDef = PropertyMaterial.PROPERTY_DEFS.get(property);
            tooltip.add(propertyDef.makeTooltip(value));
        });

        super.appendHoverText(itemStack, level, tooltip, isAdvanced);
    }

    //    public static class KeywordPropertyDef extends PropertyDef {
//        public final String[] values;
//
//        public KeywordPropertyDef(String name, String[] values) {
//            super(name);
//
//            this.values = values;
//        }
//    }

}
