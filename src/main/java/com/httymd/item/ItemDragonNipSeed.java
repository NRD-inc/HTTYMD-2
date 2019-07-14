package com.httymd.item;

import com.httymd.HTTYMD;
import com.httymd.Ref;
import com.httymd.init.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

public class ItemDragonNipSeed extends ItemSeeds {
    protected String name;

    public ItemDragonNipSeed(String name) {
        super(ModBlocks.CROP_DRAGON_NIP, Blocks.FARMLAND);
        this.name = name;
        setTranslationKey(name);
        setRegistryName(Ref.MOD_ID + ":" + name);
        setCreativeTab(HTTYMD.PROXY.HTTYMD_TAB);
    }

    public void registerItemModel() {
        HTTYMD.PROXY.registerItemRenderer(this, 0, name);
    }
}
