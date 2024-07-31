package net.submerg.tembris.util.tproperty;

import net.minecraft.network.chat.Component;

public class NumericPropertyDef<N extends Number> extends PropertyDef<N> {
    public final Component symbol;
    public final ScalingSystem scalingSystem;

    public NumericPropertyDef(String name, Component symbol, ScalingSystem scalingSystem) {
        super(name);

        this.symbol = symbol;
        this.scalingSystem = scalingSystem;
    }

    public NumericPropertyDef(String name, Component symbol) {
        super(name);

        this.symbol = symbol;
        this.scalingSystem = TProperties.SI_SCALING_SYSTEM;
    }

    @Override
    public Component makeTooltip(Object value) {
        return Component.literal(this.displayName().getString()
                + ": "
                + scalingSystem.scale((Number) value)
                + this.symbol.getString());
    }
}
