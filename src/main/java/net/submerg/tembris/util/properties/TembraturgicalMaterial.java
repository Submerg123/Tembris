package net.submerg.tembris.util.properties;

import net.minecraft.network.chat.Component;

import java.util.Map;

public class TembraturgicalMaterial {
    public static final PrefixScalingSystem<Double> SI_SCALING_SYSTEM = new PrefixScalingSystem<>(
            Map.entry(10e12, "T"), Map.entry(10e9, "G"), Map.entry(10e6, "M"),
            Map.entry(10e3, "k"), Map.entry(1d, ""), Map.entry(10e-3, "m"),
            Map.entry(10e-6, "μ"));
    public static final PrefixScalingSystem<Double> SI_SCALING_SYS_FULL = new PrefixScalingSystem<>(
            Map.entry(10e12, "T"), Map.entry(10e9, "G"), Map.entry(10e6, "M"),
            Map.entry(10e3, "k"), Map.entry(10e2, "h"), Map.entry(10e1, "da"),
            Map.entry(10e0, ""), Map.entry(10e-1, "d"), Map.entry(10e-2, "c"),
            Map.entry(10e-3, "m"), Map.entry(10e-6, "μ"), Map.entry(10e-9, "n"),
            Map.entry(10e-12, "p"), Map.entry(10e-15, "f"), Map.entry(10e-18, "a"),
            Map.entry(10e-21, "z"), Map.entry(10e-24, "y"), Map.entry(10e-27, "r"),
            Map.entry(10e-30, "q"));
    public static final Map<String, PropertyDef<?>> PROPERTY_DEFS = Map.ofEntries(
            Map.entry("absorbent", new BooleanPropertyDef("absorbent")),
            Map.entry("max_throughput", new NumericPropertyDef<Double>("max_throughput", Component.literal("W"))),
            Map.entry("max_capacity", new NumericPropertyDef<Double>("max_capacity", Component.literal("J")))
    );
}
