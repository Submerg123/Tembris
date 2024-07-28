package net.submerg.tembris.block.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.submerg.tembris.util.properties.PropertyDef;
import net.submerg.tembris.util.properties.TembraturgicalMaterial;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import oshi.util.tuples.Pair;

import java.util.List;
import java.util.Map;

public class DawnstoneBlock extends AbsorbentBlock {
    public final Map<String, ?> PROPERTIES = Map.ofEntries(
            Map.entry("absorbent", true),
            Map.entry("max_throughput", 10d),
            Map.entry("max_capacity", 10d)
    );


    public DawnstoneBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @Nullable BlockGetter level,
                                @NotNull List<Component> tooltip, @NotNull TooltipFlag isAdvanced) {
        this.PROPERTIES.forEach((property, value) -> {
            PropertyDef<?> propertyDef = TembraturgicalMaterial.PROPERTY_DEFS.get(property);
            tooltip.add(propertyDef.makeTooltip(value));
        });
    }
}
