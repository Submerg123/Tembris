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

/**
 * <!----------------------------------------------------------------------------->
 * A Block which implements the TProperty system.
 * <p>
 * All Implementers MUST define a Public Static Field called {@code PROPERTIES} of
 * type {@code Map<String, ?>}.  {@code PROPERTIES} defines the values of the
 * Implementer's TProperties.  The Keys are Strings representing the internal names
 * of the TProperties (as defined by {@link TProperties#PROPERTY_DEFS}) and the
 * Values are Objects of the appropriate type for the corresponding TProperty (also
 * as defined by {@code TProperties.PROPERTY_DEFS}).  See
 * {@code TProperties.PROPERTY_DEFS} for more information on TProperties.  If
 * {@code PROPERTIES} is not defined, {@link #generateTooltip(Map, List)} will
 * raise an Error. {@code PROPERTIES} SHOULD be accessed via the Getter Method
 * {@link #getProperties}.
 */
public interface PropertyBlock {

//    public PropertyBlock(Properties pProperties) {
//        super(pProperties);
//    }

    Map<String, ?> properties();

    static void generateTooltip(Map<String, ?> tProperties, List<Component> tooltip) {
        tProperties.forEach((property, value) -> {
            PropertyDef<?> propertyDef = TProperties.PROPERTY_DEFS.get(property);
            tooltip.add(propertyDef.makeTooltip(value));
        });
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
