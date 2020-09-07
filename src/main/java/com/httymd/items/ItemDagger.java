package com.httymd.items;

import com.google.common.collect.Multimap;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.SwordItem;

import java.util.UUID;


public class ItemDagger extends SwordItem {
    public static final IAttribute DAGGER_REACH = new RangedAttribute((IAttribute) null, "generic.reachDistance", 3.0D, 0.0D, 1024.0D).setShouldWatch(true);
    protected static final UUID ATTACK_RANGE_MODIFIER = UUID.fromString("bb361548-6b13-11ea-bc55-0242ac130003");
    /*If you need to copy and paste this, change the UUID here: ----------^^^^^^^ to a randomly generated UUID from the Internet and change the
     * attackRange value here: ---------\/\/
     */
    private final double attackRange = -1.0D;

    public ItemDagger(IItemTier tier, int attackDamage, float attackSpeedIn, Properties builder) {
        super(tier, attackDamage, attackSpeedIn, builder);
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);
        if (equipmentSlot == EquipmentSlotType.MAINHAND) {
            multimap.put(ItemDagger.DAGGER_REACH.getName(), new AttributeModifier(ATTACK_RANGE_MODIFIER, "Tool modifier", this.attackRange, AttributeModifier.Operation.ADDITION));
        }

        return multimap;
    }
}
