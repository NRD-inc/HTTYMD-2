package com.httymd.item;

import com.httymd.HTTYMD;
import com.httymd.Ref;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemTool;

import java.util.Set;

public class ItemModAxe extends ItemTool {
    protected String name;
    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[]{Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.OAK_DOOR, Blocks.WOODEN_PRESSURE_PLATE});

    public ItemModAxe(ToolMaterial toolmaterial, String name) {
        super(toolmaterial, EFFECTIVE_ON);
        this.name = name;
        setTranslationKey(name);
        setRegistryName(Ref.MOD_ID + ":" + name);
        setCreativeTab(HTTYMD.PROXY.HTTYMD_TAB);
    }

    public void registerItemModel() {
        HTTYMD.PROXY.registerItemRenderer(this, 0, name);
    }
}
