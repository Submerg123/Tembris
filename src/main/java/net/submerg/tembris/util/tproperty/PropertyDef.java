package net.submerg.tembris.util.tproperty;

import net.minecraft.network.chat.Component;

public abstract class PropertyDef<T> {
    public final String name;

    public PropertyDef(String name) {
        this.name = name;
    }

    public Component displayName() {
        return Component.translatable("tooltip.tembris.property." + name);
    }

    public abstract Component makeTooltip(Object value);
}
