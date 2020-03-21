package com.Httymd;

import com.Httymd.lists.ItemList;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class HttymdItemGroup extends ItemGroup{

		//creative tab name
		public HttymdItemGroup(String label) {
			super("DragonItemGroup");
		}

		//Sets the icon for the creative tab
		@Override
		public ItemStack createIcon() {
			//if you want to use a block for this, use item.BLOCK_TO_ITEM(BlockList.<block_name>)
			return new ItemStack(ItemList.gronckle_iron);
		}
}
