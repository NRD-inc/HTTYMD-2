package com.Httymd.items;

import java.util.function.Predicate;

import com.Httymd.entities.projectile.SpearEntity;
import com.Httymd.lists.ItemList;
import com.google.common.collect.Multimap;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BowItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TieredItem;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class CustomTridentItem extends TieredItem {
	protected final float attackDamage, attackSpeed;
	
	public CustomTridentItem(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, builder);
		this.attackDamage = attackDamageIn + tier.getAttackDamage();
	    this.attackSpeed = attackSpeedIn;
	    this.addPropertyOverride(new ResourceLocation("ready"), (ItemStack, World, LivingEntity) -> {
	         if (LivingEntity == null) {
	            return 0.0F;
	         } else {
	            return !(LivingEntity.getActiveItemStack().getItem() instanceof BowItem) ? 0.0F : (float)(ItemStack.getUseDuration() - LivingEntity.getItemInUseCount()) / 20.0F;
	         }
	      });
	      this.addPropertyOverride(new ResourceLocation("readying"), (ItemStack, World, LivingEntity) -> {
	         return LivingEntity != null && LivingEntity.isHandActive() && LivingEntity.getActiveItemStack() == ItemStack ? 1.0F : 0.0F;
	      });
	}
	
	//Needs nbt so it saves data after being thrown
	
	public int getUseDuration(ItemStack stack) {
	      return 72000;
	   }
	
	public UseAction getUseAction(ItemStack stack) {
	      return UseAction.BOW;
	   }
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {		
	      ItemStack itemstack = playerIn.getHeldItem(handIn);	
	      boolean flag = !findAmmo(itemstack, playerIn).isEmpty();
	      
	      ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldIn, playerIn, handIn, flag);
	      if (ret != null) return ret;

	      if (!playerIn.abilities.isCreativeMode && !flag) {
	         return flag ? new ActionResult<>(ActionResultType.PASS, itemstack) : new ActionResult<>(ActionResultType.FAIL, itemstack);
	      } else {
	         playerIn.setActiveHand(handIn);
	         return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
	      }
	   }
	
	public Predicate<ItemStack> getInventoryAmmoPredicate() {
		Predicate<ItemStack> spears = spear -> (spear.getItem() == ItemList.wood_spear || spear.getItem() == ItemList.stone_spear || spear.getItem() == ItemList.iron_spear || spear.getItem() == ItemList.gronckle_iron_spear || spear.getItem() == ItemList.gold_spear || spear.getItem() == ItemList.diamond_spear);
		return spears;
	   }
	
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
	      if (entityLiving instanceof PlayerEntity) {
	         PlayerEntity playerentity = (PlayerEntity)entityLiving;
	         boolean flag = playerentity.abilities.isCreativeMode;
	         ItemStack itemstack = findAmmo(stack, playerentity);
	         
	         int i = this.getUseDuration(stack) - timeLeft;
	         i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerentity, i, !itemstack.isEmpty() || flag);
	         if (i < 0) return;

	         if (!itemstack.isEmpty() || flag) {
	            if (itemstack.isEmpty()) {
	               itemstack = new ItemStack(entityLiving.getActiveItemStack().getItem());
	            }

	            float f = getSpearVelocity(i);
	            if (!((double)f < 0.1D)) {
	               boolean flag1 = playerentity.abilities.isCreativeMode || (itemstack.getItem() == ItemList.wood_spear || itemstack.getItem() == ItemList.stone_spear || itemstack.getItem() == ItemList.iron_spear || itemstack.getItem() == ItemList.gronckle_iron_spear || itemstack.getItem() == ItemList.gold_spear || itemstack.getItem() == ItemList.diamond_spear);
	               if (!worldIn.isRemote) {
	            	   ItemSpear spear;
	            	   if(itemstack.getItem() == ItemList.wood_spear) {
	            		   spear = (ItemSpear)ItemList.wood_spear;
	            	   }else if(itemstack.getItem() == ItemList.stone_spear) {
	            		   spear = (ItemSpear)ItemList.stone_spear;
	            	   }else if(itemstack.getItem() == ItemList.iron_spear) {
	            		   spear = (ItemSpear)ItemList.iron_spear;
	            	   }else if(itemstack.getItem() == ItemList.gronckle_iron_spear) {
	            		   spear = (ItemSpear)ItemList.gronckle_iron_spear;
	            	   }else if(itemstack.getItem() == ItemList.gold_spear) {
	            		   spear = (ItemSpear)ItemList.gold_spear;
	            	   }else if(itemstack.getItem() == ItemList.diamond_spear) {
	            		   spear = (ItemSpear)ItemList.diamond_spear;
	            	   }else {
	            		   spear = (ItemSpear)ItemList.wood_spear;
	            	   }
	                  SpearEntity spearEntity = spear.createSpear(worldIn, itemstack, playerentity, spear);
	                  spearEntity = customSpear(spearEntity);
	                  spearEntity.shoot(playerentity, playerentity.rotationPitch, playerentity.rotationYaw, 0.0F, f * 3.0F, 1.0F);
	                  if (f == 1.0F) {
	                     spearEntity.setIsCritical(true);
	                  }

	                  int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
	                  if (j > 0) {
	                     spearEntity.setDamage(spearEntity.getDamage() + (double)j * 0.5D + 0.5D);
	                  }

	                  int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
	                  if (k > 0) {
	                     spearEntity.setKnockbackStrength(k);
	                  }

	                  if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0) {
	                     spearEntity.setFire(100);
	                  }

	                  stack.damageItem(1, playerentity, (entity) -> {
	                     entity.sendBreakAnimation(playerentity.getActiveHand());
	                  });

	                  worldIn.addEntity(spearEntity);
	               }
	               itemstack.shrink(1);
	               if (itemstack.isEmpty()) {
	                     playerentity.inventory.deleteStack(itemstack);
	                  }
	               worldIn.playSound((PlayerEntity)null, playerentity.posX, playerentity.posY, playerentity.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
	               if (!flag1 && !playerentity.abilities.isCreativeMode) {
	                  itemstack.shrink(1);
	                  if (itemstack.isEmpty()) {
	                     playerentity.inventory.deleteStack(itemstack);
	                  }
	               }

	               playerentity.addStat(Stats.ITEM_USED.get(this));
	            }
	         }
	      }
	   }
	
	public static float getSpearVelocity(int charge) {
	      float f = (float)charge / 20.0F;
	      f = (f * f + f * 2.0F) / 3.0F;
	      if (f > 1.0F) {
	         f = 1.0F;
	      }

	      return f;
	   }
	
	public SpearEntity customSpear(SpearEntity spear) {
	      return spear;
	   }
	
	public ItemStack findAmmo(ItemStack shootable, PlayerEntity entity) {
	      if (!(shootable.getItem() == ItemList.wood_spear || shootable.getItem() == ItemList.stone_spear || shootable.getItem() == ItemList.iron_spear || shootable.getItem() == ItemList.gronckle_iron_spear || shootable.getItem() == ItemList.gold_spear || shootable.getItem() == ItemList.diamond_spear)) {
	         return ItemStack.EMPTY;
	      } else {
	          ItemStack itemstack = getHeldAmmo(entity);
	          if (!itemstack.isEmpty()) {
	             return itemstack;
	          } else {
	            for(int i = 0; i < entity.inventory.getSizeInventory(); ++i) {
	               ItemStack itemstack1 = entity.inventory.getStackInSlot(i);
	               		if (shootable.getItem() == ItemList.wood_spear || shootable.getItem() == ItemList.stone_spear || shootable.getItem() == ItemList.iron_spear || shootable.getItem() == ItemList.gronckle_iron_spear || shootable.getItem() == ItemList.gold_spear || shootable.getItem() == ItemList.diamond_spear) {
	               			return itemstack1;
	               		}
	               }
	          }
	     return entity.abilities.isCreativeMode ? new ItemStack(shootable.getItem()) : ItemStack.EMPTY;
	     }
	}
	
	private ItemStack getHeldAmmo(PlayerEntity entity) {
		ItemStack ammo = ItemStack.EMPTY;
		if(entity.getHeldItemMainhand().getItem() == ItemList.wood_spear || entity.getHeldItemMainhand().getItem() == ItemList.stone_spear || entity.getHeldItemMainhand().getItem() == ItemList.iron_spear || entity.getHeldItemMainhand().getItem() == ItemList.gronckle_iron_spear || entity.getHeldItemMainhand().getItem() == ItemList.gold_spear || entity.getHeldItemMainhand().getItem() == ItemList.diamond_spear) {
			ammo = entity.getHeldItemMainhand();
		}else if(entity.getHeldItemOffhand().getItem() == ItemList.wood_spear || entity.getHeldItemOffhand().getItem() == ItemList.stone_spear || entity.getHeldItemOffhand().getItem() == ItemList.iron_spear || entity.getHeldItemOffhand().getItem() == ItemList.gronckle_iron_spear || entity.getHeldItemOffhand().getItem() == ItemList.gold_spear || entity.getHeldItemOffhand().getItem() == ItemList.diamond_spear) {
			ammo = entity.getHeldItemOffhand();
		}
		return ammo;
	}

	@SuppressWarnings("deprecation")
	public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
		Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);
	    if (equipmentSlot == EquipmentSlotType.MAINHAND) {
	    	multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", (double)this.attackDamage, AttributeModifier.Operation.ADDITION));
	        multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", (double)this.attackSpeed, AttributeModifier.Operation.ADDITION));
	    }

	return multimap;
	}
}
