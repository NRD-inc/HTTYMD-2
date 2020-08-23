package com.Httymd.entities;

import java.util.function.Predicate;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NonTamedTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtByTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtTargetGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
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

public abstract class DragonEntity extends TameableEntity implements IRangedAttackMob{
	
	private final double HEALTH, ATTACK, SPEED, ARMOR, FIRE_POWER, SHOT_LIMIT, VENOM, JAW_STRENGTH, STEALTH, RECHARGE_TIME;
	private int MAX_VARS;
	public DragonEntity(EntityType<? extends DragonEntity> type, World worldIn, double health, double attack, double speed, double armor, double firePower, double shotLimit, double venom, double jawStrength, double stealth, double rechargeTime, int maxVars) {
	super(type, worldIn);
	this.setTamed(false);
	this.HEALTH = health;
    this.ATTACK = attack;
    this.SPEED = speed;
    this.ARMOR = armor;
    this.FIRE_POWER = firePower;
    this.SHOT_LIMIT = shotLimit;
    this.VENOM = venom;
    this.JAW_STRENGTH = jawStrength;
    this.STEALTH = stealth;
    this.RECHARGE_TIME = rechargeTime;
    this.MAX_VARS = maxVars;
	}
	
	/* USE FOR FLYING DRAGONS, ALSO implement IFlyingAnimal
	protected PathNavigator createNavigator(World worldIn) {
	      FlyingPathNavigator flyingpathnavigator = new FlyingPathNavigator(this, worldIn);
	      flyingpathnavigator.setCanOpenDoors(false);
	      flyingpathnavigator.setCanSwim(true);
	      flyingpathnavigator.setCanEnterDoors(true);
	      return flyingpathnavigator;
	   }
	*/
	
	public int getVars() {
		if(this.MAX_VARS >= 1) {
			return this.MAX_VARS;
		}else{
			//make sure this is set to the smallest number of dragon skins there are
			return 6;
		}
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
	
	public float getHealth() {
		return (float)this.HEALTH;
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
	
	protected void updateAITasks() {
	      super.updateAITasks();
	   }

	   public void livingTick() {
		   super.livingTick();
	   }
	
	protected static final DataParameter<Integer> VARIANT = EntityDataManager.createKey(DragonEntity.class, DataSerializers.VARINT);
	private int maxVariants = getVars();
	
	public static World WORLD;
	
	 @Override
	    public boolean attackEntityFrom(DamageSource source, float amount) {
	        if (isInvulnerableTo(source))
	            return false;
	        else {
	            return super.attackEntityFrom(source, amount);
	        }
	    }

	public static World getWorld() {
		return WORLD;
	}
	/*
	protected PathNavigator createNavigator(World worldIn) {
	      FlyingPathNavigator flyingpathnavigator = new FlyingPathNavigator(this, this.WORLD);
	      flyingpathnavigator.setCanOpenDoors(false);
	      flyingpathnavigator.setCanSwim(true);
	      flyingpathnavigator.setCanEnterDoors(true);
	      return flyingpathnavigator;
	}
	*/
	public static final Predicate<LivingEntity> DragonPredicate = (DragonPredicate) -> {
	      EntityType<?> entitytype = DragonPredicate.getType();
	      return entitytype == EntityType.SHEEP || entitytype == EntityType.RABBIT;
	   };
	      
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 0.6 + (this.getSpeed()) / 50));
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
	    this.targetSelector.addGoal(3, new HurtByTargetGoal(this, new Class[0]));
	    this.targetSelector.addGoal(3, new NonTamedTargetGoal<>(this, AnimalEntity.class, false, DragonPredicate));
	}
	
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.1D * this.getAttack());
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(((this.getSpeed() * 2) / this.getStealth()) * 5);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0.1D * this.getArmor());
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2 + (this.getSpeed() / 50));
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_SPEED);
		this.getAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(((this.getHealth() /2 ) / this.getJawStrength()) * 0.3);
	}
	
	@Override
	public void setAttackTarget(LivingEntity target) {
		super.setAttackTarget(target);
	}

	public boolean isFish(Item item){
		if(item == Items.COD || item == Items.SALMON || item == Items.TROPICAL_FISH) {
			return true;
		}else {
			return false;
		}
	}
	
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

	                  this.heal((float)item.getFood().getHealing());
	                  return true;
	               }
	            }
	         }

	         if (this.isOwner(player) && !this.world.isRemote && !this.isBreedingItem(itemstack)) {
	            this.sitGoal.setSitting(!this.isSitting());
	            this.isJumping = false;
	            this.navigator.clearPath();
	            this.setAttackTarget((LivingEntity)null);
	         }
	      } else if (isFish(item)) {
	         if (!player.abilities.isCreativeMode) {
	            itemstack.shrink(1);
	         }

	         if (!this.world.isRemote) {
	            if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
	               this.setTamedBy(player);
	               this.navigator.clearPath();
	               this.setAttackTarget((LivingEntity)null);
	               this.sitGoal.setSitting(true);
	               this.setHealth(20.0F);
	               this.playTameEffect(true);
	               this.world.setEntityState(this, (byte)7);
	            } else {
	               this.playTameEffect(false);
	               this.world.setEntityState(this, (byte)6);
	            }
	         }

	         return true;
	      }

	      return super.processInteract(player, hand);
	   }
	   
	   //Attempt at making variants for textures
	   @Override
	   public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData data, CompoundNBT nbt) {
		   this.setVariant(this.getRNG().nextInt(maxVariants));
		   return super.onInitialSpawn(world, difficulty, reason, data, nbt);
	   }
	   
	   @Override
	   protected void registerData() {
		   super.registerData();
		   this.getDataManager().register(VARIANT, 0);
	   }
	   
	   public int getVariant() {
		   return this.dataManager.get(VARIANT);
	   }
	   
	   public void setVariant(int variant) {
		   this.dataManager.set(VARIANT, variant);
	   }
	   
	   @Override
	    public boolean writeUnlessRemoved(CompoundNBT nbt) {
	        super.writeAdditional(nbt);
	        nbt.putInt("Variant", this.getVariant());
	        return super.writeUnlessRemoved(nbt);
	    }

	    @Override
	    public void read(CompoundNBT nbt) {
	        super.read(nbt);
	        this.dataManager.set(VARIANT, nbt.getInt("Variant"));
	    }
	
}