package com.Httymd.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.world.World;

public class EntityBoar extends PolarBearEntity {

	public EntityBoar(EntityType<? extends PolarBearEntity> entity, World worldIn) {
		super(entity, worldIn);
	}
	
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0F);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.5F);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0F);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(1.0F);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.35F);
	}
}
