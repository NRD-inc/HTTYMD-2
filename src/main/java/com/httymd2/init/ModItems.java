package com.httymd2.init;

import com.httymd2.HTTYMD;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HTTYMD.MOD_ID);

    public static final RegistryObject<Item> GRONCKLE_IRON_INGOT = ITEMS.register("gronckle_iron_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.HTTYMD_ITEMS)));
    public static final RegistryObject<Item> GRONCKLE_IRON_NUGGET = ITEMS.register("gronckle_iron_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.HTTYMD_ITEMS)));

    public static final RegistryObject<Item> GRONCKLE_IRON_SWORD = ITEMS.register("gronckle_iron_sword",
            () -> new SwordItem(Tiers.DIAMOND, 6, 0.5f,
                    new Item.Properties().tab(ModCreativeModeTab.HTTYMD_ITEMS)));
    public static final RegistryObject<Item> GRONCKLE_IRON_PICKAXE = ITEMS.register("gronckle_iron_pickaxe",
            () -> new PickaxeItem(Tiers.DIAMOND, 4, -3.5f,
                    new Item.Properties().tab(ModCreativeModeTab.HTTYMD_ITEMS)));
    public static final RegistryObject<Item> GRONCKLE_IRON_AXE = ITEMS.register("gronckle_iron_axe",
            () -> new AxeItem(Tiers.DIAMOND, 6, 1.5f,
                    new Item.Properties().tab(ModCreativeModeTab.HTTYMD_ITEMS)));
    public static final RegistryObject<Item> GRONCKLE_IRON_SHOVEL = ITEMS.register("gronckle_iron_shovel",
            () -> new ShovelItem(Tiers.DIAMOND, 2, 3f,
                    new Item.Properties().tab(ModCreativeModeTab.HTTYMD_ITEMS)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
}
