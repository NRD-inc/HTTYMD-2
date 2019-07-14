package com.httymd.init;

import com.httymd.Ref;
import com.httymd.item.*;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
    public static Item.ToolMaterial GRONCKLE_IRON_TOOLS = EnumHelper.addToolMaterial("GRONCKLE_IRON", 2, 600, 12.0F, 2.5F, 8);
    public static ItemArmor.ArmorMaterial GRONCKLE_IRON_ARMOR = EnumHelper.addArmorMaterial("GRONCKLE_IRON", Ref.MOD_ID + ":gronckle_iron", 24, new int[]{2, 5, 7, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.5F);

    // ITEMS
    @GameRegistry.ObjectHolder(Ref.MOD_ID + ":dragon_nip_seed")
    public static ItemDragonNipSeed DRAGON_NIP_SEED = new ItemDragonNipSeed("dragon_nip_seed");
    @GameRegistry.ObjectHolder(Ref.MOD_ID + ":dragon_nip")
    public static ItemBase DRAGON_NIP = new ItemBase("dragon_nip");
    @GameRegistry.ObjectHolder(Ref.MOD_ID + ":gronckle_iron_ingot")
    public static ItemBase GRONCKLE_IRON_INGOT = new ItemBase("gronckle_iron_ingot");
    @GameRegistry.ObjectHolder(Ref.MOD_ID + ":gronckle_iron_nugget")
    public static ItemBase GRONCKLE_IRON_NUGGET = new ItemBase("gronckle_iron_nugget");

    // VANILLA TOOLS
    @GameRegistry.ObjectHolder(Ref.MOD_ID + ":gronckle_iron_sword")
    public static ItemModSword GRONCKLE_IRON_SWORD = new ItemModSword(GRONCKLE_IRON_TOOLS, "gronckle_iron_sword");
    @GameRegistry.ObjectHolder(Ref.MOD_ID + ":gronckle_iron_axe")
    public static ItemModAxe GRONCKLE_IRON_AXE = new ItemModAxe(GRONCKLE_IRON_TOOLS, "gronckle_iron_axe");
    @GameRegistry.ObjectHolder(Ref.MOD_ID + ":gronckle_iron_pickaxe")
    public static ItemModPickaxe GRONCKLE_IRON_PICKAXE = new ItemModPickaxe(GRONCKLE_IRON_TOOLS, "gronckle_iron_pickaxe");
    @GameRegistry.ObjectHolder(Ref.MOD_ID + ":gronckle_iron_shovel")
    public static ItemModShovel GRONCKLE_IRON_SHOVEL = new ItemModShovel(GRONCKLE_IRON_TOOLS, "gronckle_iron_shovel");
    @GameRegistry.ObjectHolder(Ref.MOD_ID + ":gronckle_iron_hoe")
    public static ItemModHoe GRONCKLE_IRON_HOE = new ItemModHoe(GRONCKLE_IRON_TOOLS, "gronckle_iron_hoe");

    // CUSTOM TOOLS
    @GameRegistry.ObjectHolder(Ref.MOD_ID + ":dagger_wood")
    public static ItemModDagger DAGGER_WOOD = new ItemModDagger(Item.ToolMaterial.WOOD, "dagger_wood");
    @GameRegistry.ObjectHolder(Ref.MOD_ID + ":dagger_stone")
    public static ItemModDagger DAGGER_STONE = new ItemModDagger(Item.ToolMaterial.STONE, "dagger_stone");
    @GameRegistry.ObjectHolder(Ref.MOD_ID + ":dagger_iron")
    public static ItemModDagger DAGGER_IRON = new ItemModDagger(Item.ToolMaterial.IRON, "dagger_iron");
    @GameRegistry.ObjectHolder(Ref.MOD_ID + ":dagger_gronckle_iron")
    public static ItemModDagger DAGGER_GRONCKLE_IRON = new ItemModDagger(GRONCKLE_IRON_TOOLS, "dagger_gronckle_iron");
    @GameRegistry.ObjectHolder(Ref.MOD_ID + ":dagger_diamond")
    public static ItemModDagger DAGGER_DIAMOND = new ItemModDagger(Item.ToolMaterial.DIAMOND, "dagger_diamond");
    @GameRegistry.ObjectHolder(Ref.MOD_ID + ":dagger_gold")
    public static ItemModDagger DAGGER_GOLD = new ItemModDagger(Item.ToolMaterial.GOLD, "dagger_gold");

    // VANILLA ARMOR
    @GameRegistry.ObjectHolder(Ref.MOD_ID + ":gronckle_iron_helmet")
    public static ItemModArmor GRONCKLE_IRON_HELMET = new ItemModArmor(GRONCKLE_IRON_ARMOR, "gronckle_iron_helmet", 1, EntityEquipmentSlot.HEAD);
    @GameRegistry.ObjectHolder(Ref.MOD_ID + ":gronckle_iron_chestplate")
    public static ItemModArmor GRONCKLE_IRON_CHESTPLATE = new ItemModArmor(GRONCKLE_IRON_ARMOR, "gronckle_iron_chestplate", 1, EntityEquipmentSlot.CHEST);
    @GameRegistry.ObjectHolder(Ref.MOD_ID + ":gronckle_iron_leggings")
    public static ItemModArmor GRONCKLE_IRON_LEGGINGS = new ItemModArmor(GRONCKLE_IRON_ARMOR, "gronckle_iron_leggings", 2, EntityEquipmentSlot.LEGS);
    @GameRegistry.ObjectHolder(Ref.MOD_ID + ":gronckle_iron_boots")
    public static ItemModArmor GRONCKLE_IRON_BOOTS = new ItemModArmor(GRONCKLE_IRON_ARMOR, "gronckle_iron_boots", 1, EntityEquipmentSlot.FEET);

    public static void initOreDict() {
        OreDictionary.registerOre("cropDragonNip", DRAGON_NIP);
        OreDictionary.registerOre("ingotGronckleIron", GRONCKLE_IRON_INGOT);
        OreDictionary.registerOre("nuggetGronckleIron", GRONCKLE_IRON_NUGGET);
    }

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                DRAGON_NIP_SEED,
                DRAGON_NIP,
                GRONCKLE_IRON_INGOT,
                GRONCKLE_IRON_NUGGET,

                GRONCKLE_IRON_SWORD,
                GRONCKLE_IRON_AXE,
                GRONCKLE_IRON_PICKAXE,
                GRONCKLE_IRON_SHOVEL,
                GRONCKLE_IRON_HOE,

                DAGGER_WOOD,
                DAGGER_STONE,
                DAGGER_IRON,
                DAGGER_GRONCKLE_IRON,
                DAGGER_DIAMOND,
                DAGGER_GOLD,

                GRONCKLE_IRON_HELMET,
                GRONCKLE_IRON_CHESTPLATE,
                GRONCKLE_IRON_LEGGINGS,
                GRONCKLE_IRON_BOOTS
        );
    }

    public static void registerModels() {
        DRAGON_NIP_SEED.registerItemModel();
        DRAGON_NIP.registerItemModel();
        GRONCKLE_IRON_INGOT.registerItemModel();
        GRONCKLE_IRON_NUGGET.registerItemModel();

        GRONCKLE_IRON_SWORD.registerItemModel();
        GRONCKLE_IRON_AXE.registerItemModel();
        GRONCKLE_IRON_PICKAXE.registerItemModel();
        GRONCKLE_IRON_SHOVEL.registerItemModel();
        GRONCKLE_IRON_HOE.registerItemModel();

        DAGGER_WOOD.registerItemModel();
        DAGGER_STONE.registerItemModel();
        DAGGER_IRON.registerItemModel();
        DAGGER_GRONCKLE_IRON.registerItemModel();
        DAGGER_DIAMOND.registerItemModel();
        DAGGER_GOLD.registerItemModel();

        GRONCKLE_IRON_HELMET.registerItemModel();
        GRONCKLE_IRON_CHESTPLATE.registerItemModel();
        GRONCKLE_IRON_LEGGINGS.registerItemModel();
        GRONCKLE_IRON_BOOTS.registerItemModel();
    }
}
