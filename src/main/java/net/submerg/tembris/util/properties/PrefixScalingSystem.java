package net.submerg.tembris.util.properties;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicReference;

public class PrefixScalingSystem<N extends Number> extends ScalingSystem {
    public final TreeMap<N, String> prefixes;

    @SafeVarargs
    public PrefixScalingSystem(Map.Entry<N, String>... prefixes) {
        TreeMap<N, String> treeMap = new TreeMap<>();
        for (Map.Entry<N, String> prefix : prefixes) {
            treeMap.put(prefix.getKey(), prefix.getValue());
        }
        this.prefixes = treeMap;
    }

    @Override
    public String scale(Number value) {
        AtomicReference<String> displayValue = new AtomicReference<>();
        AtomicReference<String> symbol = new AtomicReference<>();

        this.prefixes.forEach((factor, prefix) -> {
            if (((double) value) >= ((double) factor)) {
                displayValue.set(String.valueOf(((double) value) / ((double) factor)));
                symbol.set(prefix);
            }
        });
        return displayValue.get() + " " + symbol.get();
    }
}
