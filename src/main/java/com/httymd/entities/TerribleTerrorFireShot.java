package com.httymd.entities;

import com.httymd.lists.Entities;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.projectile.DamagingProjectileEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.UUID;

public class TerribleTerrorFireShot extends DamagingProjectileEntity implements IProjectile {
    public EntityTerribleTerror owner;
    private CompoundNBT ownerNBT;

    public TerribleTerrorFireShot(EntityType<? extends TerribleTerrorFireShot> entity, World worldIn) {
        super(entity, worldIn);
    }

    public TerribleTerrorFireShot(World worldIn, EntityTerribleTerror entity) {
        this(Entities.TERRIBLE_TERROR_FIRE, worldIn);
        this.owner = entity;
        this.setPosition(entity.posX - (double) (entity.getWidth() + 1.0F) * 0.5D * (double) MathHelper.sin(entity.renderYawOffset * ((float) Math.PI / 180F)), entity.posY + (double) entity.getEyeHeight() - (double) 0.1F, entity.posZ + (double) (entity.getWidth() + 1.0F) * 0.5D * (double) MathHelper.cos(entity.renderYawOffset * ((float) Math.PI / 180F)));
    }

    @OnlyIn(Dist.CLIENT)
    public TerribleTerrorFireShot(World worldIn, double x, double y, double z, double xMove, double yMove, double zMove) {
        this(Entities.TERRIBLE_TERROR_FIRE, worldIn);
        this.setPosition(x, y, z);

        for (int i = 0; i <= 7; i++) {
            double d0 = 0.4D + 0.1D * (double) i;
            worldIn.addParticle(ParticleTypes.CRIT, x, y, z, xMove * d0, yMove, zMove * d0);
        }
        this.setMotion(xMove, yMove, zMove);
    }

    public void tick() {
        super.tick();
        if (this.ownerNBT != null) {
            this.restoreOwnerFromSave();
        }

        Vec3d vec3d = this.getMotion();
        RayTraceResult raytraceresult = ProjectileHelper.func_221267_a(this, this.getBoundingBox().expand(vec3d).grow(1.0D), (p_213879_1_) -> {
            return !p_213879_1_.isSpectator() && p_213879_1_ != this.owner;
        }, RayTraceContext.BlockMode.OUTLINE, true);
        if (raytraceresult != null && raytraceresult.getType() != RayTraceResult.Type.MISS && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, raytraceresult)) {
            this.onImpact(raytraceresult);
        }

        this.posX += vec3d.x;
        this.posY += vec3d.y;
        this.posZ += vec3d.z;
        float f = MathHelper.sqrt(func_213296_b(vec3d));
        this.rotationYaw = (float) (MathHelper.atan2(vec3d.x, vec3d.z) * (double) (180F / (float) Math.PI));

        for (this.rotationPitch = (float) (MathHelper.atan2(vec3d.y, (double) f) * (double) (180F / (float) Math.PI)); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F) {
            ;
        }

        while (this.rotationPitch - this.prevRotationPitch >= 180.0F) {
            this.prevRotationPitch += 360.0F;
        }

        while (this.rotationYaw - this.prevRotationYaw < -180.0F) {
            this.prevRotationYaw -= 360.0F;
        }

        while (this.rotationYaw - this.prevRotationYaw >= 180.0F) {
            this.prevRotationYaw += 360.0F;
        }

        this.rotationPitch = MathHelper.lerp(0.2F, this.prevRotationPitch, this.rotationPitch);
        this.rotationYaw = MathHelper.lerp(0.2F, this.prevRotationYaw, this.rotationYaw);
        float f1 = 0.99F;
        float f2 = -0.06F;
        if (!this.world.isMaterialInBB(this.getBoundingBox(), Material.AIR)) {
            this.remove();
        } else if (this.isInWaterOrBubbleColumn()) {
            this.remove();
        } else {
            this.setMotion(vec3d.scale((double) f1));
            if (!this.hasNoGravity()) {
                this.setMotion(this.getMotion().add(0.0D, (double) f2, 0.0D));
            }

            this.setPosition(this.posX, this.posY, this.posZ);
        }
    }

    private void restoreOwnerFromSave() {
        if (this.ownerNBT != null && this.ownerNBT.hasUniqueId("OwnerUUID")) {
            UUID uuid = this.ownerNBT.getUniqueId("OwnerUUID");

            for (EntityTerribleTerror entity : this.world.getEntitiesWithinAABB(EntityTerribleTerror.class, this.getBoundingBox().grow(15.0D))) {
                if (entity.getUniqueID().equals(uuid)) {
                    this.owner = entity;
                    break;
                }
            }
        }
        this.ownerNBT = null;
    }

    protected void registerData() {
    }


    public void readAdditional(CompoundNBT compound) {
        if (compound.contains("Owner", 10)) {
            this.ownerNBT = compound.getCompound("Owner");
        }

    }

    public void writeAdditional(CompoundNBT compound) {
        if (this.owner != null) {
            CompoundNBT compoundnbt = new CompoundNBT();
            UUID uuid = this.owner.getUniqueID();
            compoundnbt.putUniqueId("OwnerUUID", uuid);
            compound.put("Owner", compoundnbt);
        }

    }

    public IPacket<?> createSpawnPacket() {
        return new SSpawnObjectPacket(this);
    }

    @Override
    public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
        Vec3d vec3d = (new Vec3d(x, y, z)).normalize().add(this.rand.nextGaussian() * (double) 0.0075F * (double) inaccuracy, this.rand.nextGaussian() * (double) 0.0075F * (double) inaccuracy, this.rand.nextGaussian() * (double) 0.0075F * (double) inaccuracy).scale((double) velocity);
        this.setMotion(vec3d);
        float f = MathHelper.sqrt(func_213296_b(vec3d));
        this.rotationYaw = (float) (MathHelper.atan2(vec3d.x, z) * (double) (180F / (float) Math.PI));
        this.rotationPitch = (float) (MathHelper.atan2(vec3d.y, (double) f) * (double) (180F / (float) Math.PI));
        this.prevRotationYaw = this.rotationYaw;
        this.prevRotationPitch = this.rotationPitch;
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (!this.world.isRemote) {
            if (result.getType() == RayTraceResult.Type.ENTITY) {
                Entity entity = ((EntityRayTraceResult) result).getEntity();
                if (!entity.isImmuneToFire()) {
                    int i = entity.func_223314_ad();
                    entity.setFire(1);
                    boolean flag = entity.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 7.0F);
                    if (flag) {
                        this.applyEnchantments(this.shootingEntity, entity);
                    } else {
                        entity.func_223308_g(i);
                    }
                }
            } else if (this.shootingEntity == null || !(this.shootingEntity instanceof MobEntity) || net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this.shootingEntity)) {
                BlockRayTraceResult blockraytraceresult = (BlockRayTraceResult) result;
                BlockPos blockpos = blockraytraceresult.getPos().offset(blockraytraceresult.getFace());
                if (this.world.isAirBlock(blockpos)) {
                    this.world.setBlockState(blockpos, Blocks.FIRE.getDefaultState());
                }
            }

            this.remove();
        }

    }
}
