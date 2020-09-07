package com.httymd.entities;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityTerribleTerror extends DragonEntity //implements IFlyingAnimal 
{
    public EntityTerribleTerror(EntityType<? extends DragonEntity> type, World worldIn) {
        super(type, worldIn, 20.0D, 8.0D, 10.0D, 6.0D, 12.0D, 10.0D, 12.0D, 2.0D, 12.0D, 300, 6);
    }

    int ShotsLeft;

    @Override
    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        int ShotsLeft = (int) this.getShotLimit();
        if (ShotsLeft > 0) {
            this.fireAt(target);
            ShotsLeft -= 1;
        }
    }

    protected void fireAt(LivingEntity target) {
        TerribleTerrorFireShot shot = new TerribleTerrorFireShot(this.world, this);
        double d0 = target.posX - this.posX;
        double d1 = target.getBoundingBox().minY + (double) (target.getHeight() / 3.0F) - shot.posY;
        double d2 = target.posZ - this.posZ;
        float f = MathHelper.sqrt(d0 * d0 + d2 * d2) * 0.2F;
        shot.shoot(d0, d1 + (double) f, d2, 1.5F, 10.0F);
        this.world.playSound((PlayerEntity) null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_BLAZE_BURN, this.getSoundCategory(), 1.0F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F);
        this.world.addEntity(shot);
        tick(this);
    }

    int rechargeTime;

    private void tick(LivingEntity entityIn) {
        int rechargeTime = (int) this.getRechargeTime();
        if (rechargeTime <= 0) {
            this.ShotsLeft += 1;
        } else {
            --this.rechargeTime;
        }
    }

    @Override
    public AgeableEntity createChild(AgeableEntity entity) {
        return entity;
    }
}
