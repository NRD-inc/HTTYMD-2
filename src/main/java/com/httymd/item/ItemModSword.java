package com.httymd.item;

import com.httymd.HTTYMD;
import com.httymd.Ref;
import net.minecraft.item.ItemSword;

public class ItemModSword extends ItemSword {
    protected String name;

    public ItemModSword(ToolMaterial toolmaterial, String name) {
        super(toolmaterial);
        this.name = name;
        setTranslationKey(name);
        setRegistryName(Ref.MOD_ID + ":" + name);
        setCreativeTab(HTTYMD.PROXY.HTTYMD_TAB);
    }

    public void registerItemModel() {
        HTTYMD.PROXY.registerItemRenderer(this, 0, name);
    }
}
