package net.submerg.tembris.util.tproperty;

import net.minecraft.network.chat.Component;

public class BooleanPropertyDef extends PropertyDef<Boolean> {
    public BooleanPropertyDef(String name) {
        super(name);
    }

    @Override
    public Component makeTooltip(Object value) {
        if ((boolean) value) {
            return this.displayName();
        } else {
            return Component.empty();
        }
    }
}
