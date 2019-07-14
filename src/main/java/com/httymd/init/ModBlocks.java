package com.httymd.init;

import com.httymd.Ref;
import com.httymd.block.BlockBase;
import com.httymd.block.BlockDragonNip;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {
    @GameRegistry.ObjectHolder(Ref.MOD_ID + ":crop_dragon_nip")
    public static BlockDragonNip CROP_DRAGON_NIP = new BlockDragonNip("crop_dragon_nip");
    @GameRegistry.ObjectHolder(Ref.MOD_ID + ":gronckle_iron_block")
    public static BlockBase GRONCKLE_IRON_BLOCK = new BlockBase("gronckle_iron_block", Material.IRON);;

    public static void initOreDict() {
        OreDictionary.registerOre("blockGronckleIron", GRONCKLE_IRON_BLOCK);
    }

    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
                CROP_DRAGON_NIP,
                GRONCKLE_IRON_BLOCK
        );
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.registerAll(
                GRONCKLE_IRON_BLOCK.createItemBlock()
        );
    }

    public static void registerModels() {
        GRONCKLE_IRON_BLOCK.registerItemModel(Item.getItemFromBlock(GRONCKLE_IRON_BLOCK));
    }
}
