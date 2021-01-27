package com.httymd.lists;

import com.httymd.Httymd;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public enum ArmorMaterialList implements IArmorMaterial {
    GronckleArmor("gronckle_iron", 24, new int[]{2, 5, 7, 2}, 12, ItemList.gronckle_iron, "item.armor.equip_iron", 1.5F);

    private static final int[] max_damage_array = {13, 15, 16, 11};
    private String name, equipSound;
    private int durability, enchantability;
    private float toughness;
    private int[] damageReductionAmounts;
    private Item repairItem;

    private ArmorMaterialList(String name, int durability, int[] damageReductionAmounts, int enchantability, Item repairItem, String equipSound, float toughness) {
        this.name = name;
        this.equipSound = equipSound;
        this.enchantability = enchantability;
        this.repairItem = repairItem;
        this.damageReductionAmounts = damageReductionAmounts;
        this.toughness = toughness;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slot) {
        // TODO Auto-generated method stub
        return this.damageReductionAmounts[slot.getIndex()];
    }

    @Override
    public int getDurability(EquipmentSlotType slot) {
        // TODO Auto-generated method stub
        return max_damage_array[slot.getIndex() * this.durability];
    }

    @Override
    public int getEnchantability() {
        // TODO Auto-generated method stub
        return this.enchantability;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return Httymd.MOD_ID + ":" + this.name;
    }

    @Override
    public Ingredient getRepairMaterial() {
        // TODO Auto-generated method stub
        return Ingredient.fromItems(this.repairItem);
    }

    @Override
    public SoundEvent getSoundEvent() {
        // TODO Auto-generated method stub
        return new SoundEvent(new ResourceLocation(equipSound));
    }

    @Override
    public float getToughness() {
        // TODO Auto-generated method stub
        return this.toughness;
    }

}
