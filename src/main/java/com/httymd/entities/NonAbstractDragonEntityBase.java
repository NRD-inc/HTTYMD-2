package com.httymd.entities;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;

public class NonAbstractDragonEntityBase extends DragonEntity {

    public NonAbstractDragonEntityBase(EntityType<? extends DragonEntity> type, World worldIn) {
        super(type, worldIn, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    @Override
    public int getMaxVariants() {
        return 0;
    }

    public void attackEntityWithRangedAttack(LivingEntity arg0, float arg1) {

    }

    public AgeableEntity createChild(AgeableEntity arg0) {
        return arg0;
    }

}
