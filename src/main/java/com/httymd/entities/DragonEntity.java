package com.httymd.entities;

import com.httymd.Httymd;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.function.Predicate;

public abstract class DragonEntity extends TameableEntity implements IRangedAttackMob {
    private static final DataParameter<Integer> VARIANT = EntityDataManager.createKey(DragonEntity.class, DataSerializers.VARINT);
    public static final Predicate<LivingEntity> TARGET_PREDICATE = (livingEntity) -> {
        EntityType<?> entitytype = livingEntity.getType();
        return entitytype == EntityType.SHEEP || entitytype == EntityType.RABBIT;
    };
    protected double HEALTH, ATTACK, SPEED, ARMOR, FIRE_POWER, SHOT_LIMIT, VENOM, JAW_STRENGTH, STEALTH, RECHARGE_TIME;

    public DragonEntity(EntityType<? extends DragonEntity> type, World worldIn, double health, double attack, double speed, double armor, double firePower, double shotLimit, double venom, double jawStrength, double stealth, double rechargeTime) {
        super(type, worldIn);
        //this.HEALTH = health;
        this.ATTACK = attack;
        this.SPEED = speed;
        this.ARMOR = armor;
        this.FIRE_POWER = firePower;
        this.SHOT_LIMIT = shotLimit;
        this.VENOM = venom;
        this.JAW_STRENGTH = jawStrength;
        this.STEALTH = stealth;
        this.RECHARGE_TIME = rechargeTime;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.2D));
        this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, PlayerEntity.class, 8.0F, 1.2D, 1.1D));
        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new RangedAttackGoal(this, 2.0D, 1, 3.5F));
        this.goalSelector.addGoal(6, new TemptGoal(this, 1.1D, Ingredient.fromItems(Items.COD, Items.SALMON, Items.TROPICAL_FISH), false));
        this.goalSelector.addGoal(7, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F));
        this.goalSelector.addGoal(8, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(9, new WaterAvoidingRandomWalkingGoal(this, 1.2));
        this.goalSelector.addGoal(10, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(11, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setCallsForHelp());
        this.targetSelector.addGoal(3, new NonTamedTargetGoal<>(this, AnimalEntity.class, false, TARGET_PREDICATE));
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData data, CompoundNBT nbt) {
        this.setVariant(this.rand.nextInt(getMaxVariants()));
        return super.onInitialSpawn(world, difficulty, reason, data, nbt);
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(VARIANT, 0);
    }

    // USE FOR FLYING DRAGONS, ALSO implement IFlyingAnimal
    /*protected PathNavigator createNavigator(World worldIn) {
        FlyingPathNavigator flyingpathnavigator = new FlyingPathNavigator(this, worldIn);
        flyingpathnavigator.setCanOpenDoors(false);
        flyingpathnavigator.setCanSwim(true);
        flyingpathnavigator.setCanEnterDoors(true);
        return flyingpathnavigator;
    }*/

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (isInvulnerableTo(source))
            return false;
        else {
            if (!world.isRemote)
                Httymd.LOGGER.info((this.getHealth()-amount) + "/" + this.getMaxHealth());
            return super.attackEntityFrom(source, amount);
        }
    }

    /*protected PathNavigator createNavigator(World worldIn) {
          FlyingPathNavigator flyingpathnavigator = new FlyingPathNavigator(this, this.WORLD);
          flyingpathnavigator.setCanOpenDoors(false);
          flyingpathnavigator.setCanSwim(true);
          flyingpathnavigator.setCanEnterDoors(true);
          return flyingpathnavigator;
    }*/
    public boolean isFish(Item item) {
        if (item == Items.COD || item == Items.SALMON || item == Items.TROPICAL_FISH)
            return true;
        else
            return false;
    }

    @Override
    public boolean processInteract(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        Item item = itemstack.getItem();
        if (this.isTamed()) {
            if (!itemstack.isEmpty()) {
                if (item.isFood()) {
                    if (isFish(item)) {
                        if (!player.abilities.isCreativeMode) {
                            itemstack.shrink(1);
                        }

                        this.heal((float) item.getFood().getHealing());
                        return true;
                    }
                }
            }

            /*if (this.isOwner(player) && !this.world.isRemote && !this.isBreedingItem(itemstack)) {
                this.sitGoal.setSitting(!this.isSitting());
                this.isJumping = false;
                this.navigator.clearPath();
                this.setAttackTarget(null);
            }*/
        } else if (isFish(item)) {
            if (!player.abilities.isCreativeMode) {
                itemstack.shrink(1);
            }

            if (!this.world.isRemote) {
                if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                    this.setTamedBy(player);
                    this.navigator.clearPath();
                    this.setAttackTarget(null);
                    //this.sitGoal.setSitting(true); //todo, add sitting goal
                    this.playTameEffect(true);
                    this.world.setEntityState(this, (byte) 7);
                } else {
                    this.playTameEffect(false);
                    this.world.setEntityState(this, (byte) 6);
                }
            }

            return true;
        }

        return super.processInteract(player, hand);
    }

    @Override
    public void writeAdditional(CompoundNBT nbt) {
        super.writeAdditional(nbt);
        nbt.putInt("Variant", this.getVariant());
    }

    @Override
    public void readAdditional(CompoundNBT nbt) {
        super.readAdditional(nbt);
        this.setVariant(nbt.getInt("Variant"));
    }

    public abstract int getMaxVariants();

    public int getVariant() {
        return this.dataManager.get(VARIANT);
    }

    public void setVariant(int variant) {
        if (variant < 0 || variant >= getMaxVariants())
            variant = this.rand.nextInt(getMaxVariants());
        this.dataManager.set(VARIANT, variant);
    }

    public double getVenom() {
        return this.VENOM;
    }

    public double getFirePower() {
        return this.FIRE_POWER;
    }

    public double getShotLimit() {
        return this.SHOT_LIMIT;
    }

    public double getRechargeTime() {
        return this.RECHARGE_TIME;
    }

    public double getSpeed() {
        return this.SPEED;
    }

    public double getHealthStat() {
        return this.HEALTH;
    }

    public void setHealthStat(double health) {
        this.HEALTH = health;
    }

    public double getAttack() {
        return this.ATTACK;
    }

    public double getArmor() {
        return this.ARMOR;
    }

    public double getJawStrength() {
        return this.JAW_STRENGTH;
    }

    public double getStealth() {
        return this.STEALTH;
    }
}