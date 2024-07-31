package net.submerg.tembris.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.submerg.tembris.util.tproperty.PropertyDef;
import net.submerg.tembris.util.tproperty.TProperties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import oshi.util.tuples.Pair;

import java.util.List;

public class TembraturgicalMaterialItem extends Item {
    public final List<Pair<String, Object>> PROPERTIES = List.of();

    public TembraturgicalMaterialItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip,
                                @NotNull TooltipFlag isAdvanced) {
        PROPERTIES.forEach(pair -> {
            String property = pair.getA();
            Object value = pair.getB();
            PropertyDef<?> propertyDef = TProperties.PROPERTY_DEFS.get(property);
            tooltip.add(propertyDef.makeTooltip(value));
        });

        super.appendHoverText(itemStack, level, tooltip, isAdvanced);
    }
}
