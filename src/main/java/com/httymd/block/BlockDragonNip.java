package com.httymd.block;

import com.httymd.HTTYMD;
import com.httymd.Ref;
import com.httymd.init.ModItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockDragonNip extends BlockCrops {
    public BlockDragonNip(String name) {
        setTranslationKey(name);
        setRegistryName(Ref.MOD_ID + ":" + name);
        setCreativeTab(HTTYMD.PROXY.HTTYMD_TAB);
    }

    @Override
    protected Item getSeed() {
        return ModItems.DRAGON_NIP_SEED;
    }

    @Override
    protected Item getCrop() {
        return ModItems.DRAGON_NIP;
    }
}
