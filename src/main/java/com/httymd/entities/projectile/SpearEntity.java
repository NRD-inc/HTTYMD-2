package com.httymd.entities.projectile;

import com.google.common.collect.Lists;
import com.httymd.lists.Entities;
import com.httymd.lists.ItemList;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public class SpearEntity extends AbstractArrowEntity {
    private IntOpenHashSet hash;
    private SoundEvent hitSound = this.getHitSound();
    public PickupStatus pickupStatus = PickupStatus.ALLOWED;
    private List<Entity> EntityList;
    private int ticksInAir;
    Item SPEAR;

    public SpearEntity(EntityType<? extends SpearEntity> entity, World worldIn) {
        super(entity, worldIn);
    }

    public SpearEntity(EntityType<? extends SpearEntity> entity, double X, double Y, double Z, World worldIn, LivingEntity shooter) {
        super(entity, X, Y, Z, worldIn);
    }

    public SpearEntity(World worldIn, LivingEntity shooter, Item spear) {
        super(Entities.SPEAR, shooter, worldIn);
        this.SPEAR = spear;
    }

    Map<Enchantment, Integer> ench;

    public void recieveEnch(Map<Enchantment, Integer> enchMap) {
        ench = enchMap;
    }

    @Override
    public void onCollideWithPlayer(PlayerEntity entityIn) {
        if (!this.world.isRemote && (this.inGround || this.func_203047_q()) && this.arrowShake <= 0) {
            boolean flag = this.pickupStatus == AbstractArrowEntity.PickupStatus.ALLOWED || this.pickupStatus == AbstractArrowEntity.PickupStatus.CREATIVE_ONLY && entityIn.abilities.isCreativeMode || this.func_203047_q() && this.getShooter().getUniqueID() == entityIn.getUniqueID();
            if (this.pickupStatus == AbstractArrowEntity.PickupStatus.ALLOWED && !entityIn.inventory.addItemStackToInventory(this.getArrowStack())) {
                flag = false;
            }

            if (flag) {
                entityIn.onItemPickup(this, 1);
                this.remove();
            }

        }
    }

    @Override
    protected ItemStack getArrowStack() {
        return new ItemStack(this.SPEAR);
    }

    @Override
    public void setHitSound(SoundEvent sound) {
        this.hitSound = sound;
    }

    protected SoundEvent getHitSound() {
        return SoundEvents.ENTITY_ARROW_HIT;
    }

    public void tick() {
        super.tick();
        if (this.world.isRemote) {
        } else if (this.inGround && this.timeInGround != 0 && this.timeInGround >= 600) {
            this.world.setEntityState(this, (byte) 0);
        }

    }

    @Nullable
    protected EntityRayTraceResult func_213866_a(Vec3d p_213866_1_, Vec3d p_213866_2_) {
        return ProjectileHelper.func_221271_a(this.world, this, p_213866_1_, p_213866_2_, this.getBoundingBox().expand(this.getMotion()).grow(1.0D), (p_213871_1_) -> {
            return !p_213871_1_.isSpectator() && p_213871_1_.isAlive() && p_213871_1_.canBeCollidedWith() && (p_213871_1_ != this.getShooter() || this.ticksInAir >= 5) && (this.hash == null || !this.hash.contains(p_213871_1_.getEntityId()));
        });
    }

    BlockPos pos = this.getShooter().getPosition();
    LivingEntity posEntity = (LivingEntity) this.getShooter();

    protected void func_213868_a(EntityRayTraceResult result) {
        Entity entity = result.getEntity();
        float f = (float) this.getMotion().length();
        int i = MathHelper.ceil(Math.max((double) f * this.getSpearDamage((LivingEntity) this.getShooter()), 1.0D));
        if (this.func_213874_s() > 0) {
            if (this.hash == null) {
                this.hash = new IntOpenHashSet(5);
            }

            if (this.EntityList == null) {
                this.EntityList = Lists.newArrayListWithCapacity(5);
            }

            if (this.hash.size() >= this.func_213874_s() + 1) {
                this.remove();
                return;
            }

            this.hash.add(entity.getEntityId());
        }

        if (this.getIsCritical()) {
            i += this.rand.nextInt(i / 2 + 2);
        }

        Entity entity1 = this.getShooter();
        DamageSource damagesource;
        if (entity1 == null) {
            damagesource = DamageSource.causeArrowDamage(this, this);
        } else {
            damagesource = DamageSource.causeArrowDamage(this, entity1);
            if (entity1 instanceof LivingEntity) {
                ((LivingEntity) entity1).setLastAttackedEntity(entity);
            }
        }

        int j = entity.func_223314_ad();
        if (this.isBurning() && !(entity instanceof EndermanEntity)) {
            entity.setFire(5);
        }

        if (entity.attackEntityFrom(damagesource, (float) i)) {
            if (entity instanceof LivingEntity) {
                LivingEntity livingentity = (LivingEntity) entity;

                pos = livingentity.getPosition();
                posEntity = livingentity;

                Vec3d vec3d = this.getMotion().mul(1.0D, 0.0D, 1.0D).normalize().scale(1.0 * 0.6D);
                if (vec3d.lengthSquared() > 0.0D) {
                    livingentity.addVelocity(vec3d.x, 0.1D, vec3d.z);
                }

                if (!this.world.isRemote && entity1 instanceof LivingEntity) {
                    EnchantmentHelper.applyThornEnchantments(livingentity, entity1);
                    EnchantmentHelper.applyArthropodEnchantments((LivingEntity) entity1, livingentity);
                }

                this.arrowHit(livingentity);
                if (entity1 != null && livingentity != entity1 && livingentity instanceof PlayerEntity && entity1 instanceof ServerPlayerEntity) {
                    ((ServerPlayerEntity) entity1).connection.sendPacket(new SChangeGameStatePacket(6, 0.0F));
                }

                if (!entity.isAlive() && this.EntityList != null) {
                    this.EntityList.add(livingentity);
                }
            }

            this.playSound(this.hitSound, 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
            if (this.func_213874_s() <= 0 && !(entity instanceof EndermanEntity)) {
                this.setLocationAndAngles(pos.getX(), posEntity.getEyeHeight() - posEntity.getEyeHeight(), pos.getZ(), 0.0F, 180F);
            }
        } else {
            entity.func_223308_g(j);
            this.setMotion(this.getMotion().scale(-0.1D));
            this.rotationYaw += 180.0F;
            this.prevRotationYaw += 180.0F;
            this.ticksInAir = 0;
            if (!this.world.isRemote && this.getMotion().lengthSquared() < 1.0E-7D) {
                if (this.pickupStatus == PickupStatus.ALLOWED) {
                    this.entityDropItem(this.getArrowStack(), 0.1F);
                }
                this.remove();
            }
        }
    }

    private double getSpearDamage(LivingEntity entity) {
        double tool = 0;
        Item[] spearItems = {ItemList.wood_spear, ItemList.stone_spear, ItemList.iron_spear, ItemList.gronckle_iron_spear, ItemList.gold_spear, ItemList.diamond_spear};
        for (Item spear : spearItems) {
            int i = 0;
            if (entity.getActiveItemStack().getItem() == spear) {
                tool = i;
            }
            i++;
        }
        switch ((int) tool) {
            case 0:
            default:
                tool = 2.5F;
                break;
            case 1:
                tool = 3.5F;
                break;
            case 2:
                tool = 4.5F;
                break;
            case 3:
                tool = 5.0F;
                break;
            case 4:
                tool = 2.5F;
                break;
            case 5:
                tool = 5.5F;
                break;
        }
        return tool;
    }

    public int getVariant() {
        int tool = 0;
        Item[] spearItems = {ItemList.wood_spear, ItemList.stone_spear, ItemList.iron_spear, ItemList.gronckle_iron_spear, ItemList.gold_spear, ItemList.diamond_spear};
        for (Item spear : spearItems) {
            int i = 0;
            if (posEntity.getActiveItemStack().getItem() == spear) {
                tool = i;
            }
            i++;
        }
        return tool;
    }
}
