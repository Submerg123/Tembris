package net.submerg.tembris.block.custom;

import net.minecraft.network.chat.Component;
import oshi.util.tuples.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbsorbentBlock extends TembraturgicalMaterialBlock {
    public final List<Pair<String, ?>> PROPERTIES = List.of(
            new Pair<>("absorbent", true),
            new Pair<>("max_throughput", 0d));

    public AbsorbentBlock(Properties pProperties) {
        super(pProperties);
    }
}
