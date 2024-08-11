package net.submerg.tembris.block.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class DawnstoneBlock extends Block implements PropertyBlock {

    public DawnstoneBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public Map<String, ?> properties() {
        return Map.ofEntries(
                Map.entry("amb_accumulation", 10d),
                Map.entry("max_throughput", 10d),
                Map.entry("max_capacity", 10d)
        );
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @Nullable BlockGetter level,
                                @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        PropertyBlock.generateTooltip(this.properties(), tooltip);
        super.appendHoverText(itemStack, level, tooltip, flag);
    }
}
