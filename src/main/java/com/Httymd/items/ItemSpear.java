package com.Httymd.items;

import java.util.Map;
import java.util.UUID;

import com.Httymd.entities.projectile.SpearEntity;
import com.google.common.collect.Multimap;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Hand;
import net.minecraft.world.World;


public class ItemSpear extends CustomTridentItem {
	public static final IAttribute SPEAR_REACH = new RangedAttribute((IAttribute)null, "generic.reachDistance", 3.0D, 0.0D, 1024.0D).setShouldWatch(true);
	protected static final UUID ATTACK_RANGE_MODIFIER = UUID.fromString("8b8956d2-7051-11ea-bc55-0242ac130003");
	/*If you need to copy and paste this, change the UUID here: ----------^^^^^^^ to a randomly generated UUID from the Internet and change the 
	 * attackRange value here: ---------\/\/
	 */
	private final double attackRange = +1.0D;
	public ItemSpear(IItemTier tier, float attackDamage, int attackSpeedIn, Properties builder) {
		super(tier, attackDamage, attackSpeedIn, builder);
	}
	
	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
	      Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);
	      if (equipmentSlot == EquipmentSlotType.MAINHAND) {
	         multimap.put(ItemSpear.SPEAR_REACH.getName(), new AttributeModifier(ATTACK_RANGE_MODIFIER, "Tool modifier", this.attackRange, AttributeModifier.Operation.ADDITION));
	      }

	return multimap;
	}
	
	public SpearEntity createSpear(World worldIn, ItemStack stack, LivingEntity shooter, Item spear){
	    SpearEntity spearentity = new SpearEntity(worldIn, shooter, spear);
	    return spearentity;
	   }
}