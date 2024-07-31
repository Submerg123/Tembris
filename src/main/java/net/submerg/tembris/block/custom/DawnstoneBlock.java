package net.submerg.tembris.block.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.submerg.tembris.util.tproperty.PropertyDef;
import net.submerg.tembris.util.tproperty.TProperties;
import net.submerg.tembris.util.tproperty.TPropertyMaterial;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class DawnstoneBlock extends PropertyBlock {
    public DawnstoneBlock(Map<String, ?> tProperties, Properties pProperties) {
        super(tProperties, pProperties);
    }
}
