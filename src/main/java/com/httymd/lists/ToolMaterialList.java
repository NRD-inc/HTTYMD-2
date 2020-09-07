package com.httymd.lists;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum ToolMaterialList implements IItemTier {
    //Custom Materials
    Gronckle(2.5F, 12.0F, 600, 2, 8, ItemList.gronckle_iron);//Use a comma between tool materials instead of semi-colons

    //Base Material variables and sets
    private float attackDamage, efficiency;
    private int durability, harvestLevel, enchantability;
    private Item repairMaterial;

    ToolMaterialList(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Item repairMaterial) {
        this.attackDamage = attackDamage;
        this.efficiency = efficiency;
        this.durability = durability;
        this.harvestLevel = harvestLevel;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }


    @Override
    public float getAttackDamage() {
        // TODO Auto-generated method stub
        return attackDamage;
    }

    @Override
    public float getEfficiency() {
        // TODO Auto-generated method stub
        return efficiency;
    }

    @Override
    public int getEnchantability() {
        // TODO Auto-generated method stub
        return enchantability;
    }

    @Override
    public int getHarvestLevel() {
        // TODO Auto-generated method stub
        return harvestLevel;
    }

    @Override
    public int getMaxUses() {
        // TODO Auto-generated method stub
        return durability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        // TODO Auto-generated method stub
        return Ingredient.fromItems(this.repairMaterial);
    }
}
