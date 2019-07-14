package com.httymd.item;

import com.httymd.HTTYMD;
import com.httymd.Ref;
import net.minecraft.item.Item;

public class ItemBase extends Item {
    protected String name;

    public ItemBase(String name) {
        this.name = name;
        setTranslationKey(name);
        setRegistryName(Ref.MOD_ID + ":" + name);
        setCreativeTab(HTTYMD.PROXY.HTTYMD_TAB);
    }

    public void registerItemModel() {
        HTTYMD.PROXY.registerItemRenderer(this, 0, name);
    }
}
