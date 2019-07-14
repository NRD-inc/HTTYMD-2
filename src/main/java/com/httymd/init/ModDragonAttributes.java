package com.httymd.init;

import com.httymd.Ref;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;

public class ModDragonAttributes {
    public static final IAttribute FIRE_POWER = new RangedAttribute(
            null, Ref.MOD_ID + ".fire_power", 10.0D, 0.0D, Double.MAX_VALUE).setShouldWatch(true);
    public static final IAttribute SHOT_LIMIT = new RangedAttribute(
            null, Ref.MOD_ID + "shot_limit", 1.0D, 0.0D, Double.MAX_VALUE).setShouldWatch(true);
    public static final IAttribute VENOM = new RangedAttribute(
            null, Ref.MOD_ID + "venom", 0.0D, 0.0D, Double.MAX_VALUE).setShouldWatch(true);
    public static final IAttribute JAW_STRENGTH = new RangedAttribute(
            null, Ref.MOD_ID + "jaw_strength", 10.0D, 0.0D, Double.MAX_VALUE).setShouldWatch(true);
    public static final IAttribute STEALTH = new RangedAttribute(
            null, Ref.MOD_ID + "stealth", 0.0D, 0.0D, Double.MAX_VALUE).setShouldWatch(true);
}
