package com.httymd.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityTerribleTerror extends EntityDragon {
    public EntityTerribleTerror(World worldIn) {
        super(worldIn, 10.0D,
                8.0D, 10.0D, 6.0D, 12.0D,
                10.0D, 12.0D, 2.0D, 12.0D);
        this.setSize(1.0F, 0.6F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.2D);
        getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32.0D);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
    }

    @Override
    public int setVariants() {
        return 2;
    }

    @Nullable
    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return null;
    }

    @Override
    public float getEyeHeight() {
        return 0.5F;
    }
}
