package com.httymd2.world.item;

import com.httymd2.HTTYMD;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HTTYMDItems {
    public static final DeferredRegister<Item> REGISTRAR = DeferredRegister.create(ForgeRegistries.ITEMS, HTTYMD.MOD_ID);

    public static final RegistryObject<Item> GRONCKLE_IRON_INGOT = REGISTRAR.register("gronckle_iron_ingot", () -> new Item(new Item.Properties().tab(HTTYMD.HTTYMD_GROUP)));
    public static final RegistryObject<Item> GRONCKLE_IRON_NUGGET = REGISTRAR.register("gronckle_iron_nugget", () -> new Item(new Item.Properties().tab(HTTYMD.HTTYMD_GROUP)));

    public static final RegistryObject<Item> GRONCKLE_IRON_SWORD = REGISTRAR.register("gronckle_iron_sword", () -> new SwordItem(Tiers.DIAMOND, 6, 0.5f, new Item.Properties().tab(HTTYMD.HTTYMD_GROUP)));
    public static final RegistryObject<Item> GRONCKLE_IRON_PICKAXE = REGISTRAR.register("gronckle_iron_pickaxe", () -> new PickaxeItem(Tiers.DIAMOND, 4, -3.5f, new Item.Properties().tab(HTTYMD.HTTYMD_GROUP)));
    public static final RegistryObject<Item> GRONCKLE_IRON_AXE = REGISTRAR.register("gronckle_iron_axe", () -> new AxeItem(Tiers.DIAMOND, 6, 1.5f, new Item.Properties().tab(HTTYMD.HTTYMD_GROUP)));
    public static final RegistryObject<Item> GRONCKLE_IRON_SHOVEL = REGISTRAR.register("gronckle_iron_shovel", () -> new ShovelItem(Tiers.DIAMOND, 2, 3f, new Item.Properties().tab(HTTYMD.HTTYMD_GROUP)));
}
