package net.submerg.tembris.block.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.submerg.tembris.util.tproperty.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public  abstract class PropertyBlock extends Block {
    public Map<String, ?> PROPERTIES;

    public PropertyBlock(Map<String, ?> tProperties, Properties pProperties) {
        super(pProperties);
        this.PROPERTIES = tProperties;
    }

    protected Map<String, ?> getPROPERTIES() { return this.PROPERTIES; }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @Nullable BlockGetter level,
                                @NotNull List<Component> tooltip, @NotNull TooltipFlag isAdvanced) {
        this.getPROPERTIES().forEach((property, value) -> {
            PropertyDef<?> propertyDef = TProperties.PROPERTY_DEFS.get(property);
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
