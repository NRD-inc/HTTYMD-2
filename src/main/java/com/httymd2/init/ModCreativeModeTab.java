package com.httymd2.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab HTTYMD_ITEMS = new CreativeModeTab("httymditems") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.GRONCKLE_IRON_INGOT.get());
        }
    };
}