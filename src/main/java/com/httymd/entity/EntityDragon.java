package com.httymd.entity;

import com.google.common.base.Predicate;
import com.httymd.init.ModDragonAttributes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public abstract class EntityDragon extends EntityTameable {
    private static final DataParameter<Integer> VARIANT;

    private final double HEALTH, ATTACK, SPEED, ARMOR, FIRE_POWER, SHOT_LIMIT, VENOM, JAW_STRENGTH, STEALTH;

    public EntityDragon(World worldIn, double health, double attack, double speed, double armor, double firePower, double shotLimit, double venom, double jawStrength, double stealth) {
        super(worldIn);
        this.HEALTH = health;
        this.ATTACK = attack;
        this.SPEED = speed;
        this.ARMOR = armor;
        this.FIRE_POWER = firePower;
        this.SHOT_LIMIT = shotLimit;
        this.VENOM = venom;
        this.JAW_STRENGTH = jawStrength;
        this.STEALTH = stealth;
        this.setTextureVariant(this.getRNG().nextInt(this.setVariants()));
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(VARIANT, 0);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(this.HEALTH);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1D * this.SPEED);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0.1D * this.ARMOR);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.1D * this.ATTACK);
        this.getAttributeMap().registerAttribute(ModDragonAttributes.FIRE_POWER);
        this.getEntityAttribute(ModDragonAttributes.FIRE_POWER).setBaseValue(this.FIRE_POWER);
        this.getAttributeMap().registerAttribute(ModDragonAttributes.SHOT_LIMIT);
        this.getEntityAttribute(ModDragonAttributes.SHOT_LIMIT).setBaseValue(this.SHOT_LIMIT);
        this.getAttributeMap().registerAttribute(ModDragonAttributes.VENOM);
        this.getEntityAttribute(ModDragonAttributes.VENOM).setBaseValue(this.VENOM);
        this.getAttributeMap().registerAttribute(ModDragonAttributes.JAW_STRENGTH);
        this.getEntityAttribute(ModDragonAttributes.JAW_STRENGTH).setBaseValue(this.JAW_STRENGTH);
        this.getAttributeMap().registerAttribute(ModDragonAttributes.STEALTH);
        this.getEntityAttribute(ModDragonAttributes.STEALTH).setBaseValue(this.STEALTH);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.0, true));
        this.tasks.addTask(4, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityLiving.class, 6.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true, new Class[0]));
        this.targetTasks.addTask(4, new EntityAITargetNonTamed<>(this, EntityAnimal.class, false, new Predicate<Entity>() {
            @Override
            public boolean apply(@Nullable Entity input) {
                return input instanceof EntityChicken || input instanceof EntityRabbit;
            }
        }));
        this.targetTasks.addTask(5, new EntityAINearestAttackableTarget<>(this, AbstractSkeleton.class, false));
    }

    @Override
    public boolean attackEntityAsMob(Entity target) {
        switch (new Random().nextInt(3)) {
            case 0:
            default:
                return target.attackEntityFrom(DamageSource.causeMobDamage(this), ((int) this.getEntityAttribute(ModDragonAttributes.FIRE_POWER).getAttributeValue()));
            case 1:
                return target.attackEntityFrom(DamageSource.causeMobDamage(this), ((int) this.getEntityAttribute(ModDragonAttributes.JAW_STRENGTH).getAttributeValue()));
            case 2:
                return target.attackEntityFrom(DamageSource.causeMobDamage(this), ((int) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));
        }
    }

    @Override
    public void setAttackTarget(@Nullable EntityLivingBase target) {
        super.setAttackTarget(target);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isEntityInvulnerable(source))
            return false;
        else {
            return super.attackEntityFrom(source, amount);
        }
    }

    public abstract int setVariants();

    public int getTextureVariant() {
        return this.dataManager.get(VARIANT);
    }

    public void setTextureVariant(int variant) {
        this.dataManager.set(VARIANT, variant);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt) {
        super.writeEntityToNBT(nbt);
        nbt.setInteger("Variant", this.getTextureVariant());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt) {
        super.readEntityFromNBT(nbt);
        this.setTextureVariant(nbt.getInteger("Variant"));
    }

    static {
        VARIANT = EntityDataManager.createKey(EntityDragon.class, DataSerializers.VARINT);
    }
}
