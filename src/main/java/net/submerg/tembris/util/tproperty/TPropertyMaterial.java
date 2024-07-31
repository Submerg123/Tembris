package net.submerg.tembris.util.tproperty;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import oshi.util.tuples.Pair;

import java.util.List;
import java.util.Map;

public interface TPropertyMaterial {
     Map<String, ?> PROPERTIES = Map.of();

//    default void makeTooltip(List<Component> tooltip) {
//        PROPERTIES.forEach(pair -> {
//            String property = pair.getA();
//            Object value = pair.getB();
//            PropertyDef<?> propertyDef = TProperties.PROPERTY_DEFS.get(property);
//            tooltip.add(propertyDef.makeTooltip(value));
//        });
//    }

    default void makeTooltip(@NotNull ItemStack itemStack, @Nullable BlockGetter level,
                                @NotNull List<Component> tooltip, @NotNull TooltipFlag isAdvanced) {
        this.PROPERTIES.forEach((property, value) -> {
            PropertyDef<?> propertyDef = TProperties.PROPERTY_DEFS.get(property);
            tooltip.add(propertyDef.makeTooltip(value));
        });
    }
}
