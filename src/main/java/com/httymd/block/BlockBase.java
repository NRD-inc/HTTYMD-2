package com.httymd.block;

import com.httymd.HTTYMD;
import com.httymd.Ref;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block {
    protected String name;

    public BlockBase(String name, Material material) {
        super(material);
        this.name = name;
        setTranslationKey(name);
        setRegistryName(Ref.MOD_ID + ":" + name);
        setCreativeTab(HTTYMD.PROXY.HTTYMD_TAB);
    }

    public void registerItemModel(Item itemBlock) {
        HTTYMD.PROXY.registerItemRenderer(itemBlock, 0, name);
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }
}
