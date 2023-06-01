package com.httymd2.world.level.block;

import com.httymd2.HTTYMD;
import com.httymd2.world.item.HTTYMDItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class HTTYMDBlocks {
    public static final DeferredRegister<Block> REGISTRAR = DeferredRegister.create(ForgeRegistries.BLOCKS, HTTYMD.MOD_ID);

    private static <T extends Block> RegistryObject<T> registerWithItem(String name, Supplier<T> block) {
        RegistryObject<T> registryObject = REGISTRAR.register(name, block);
        HTTYMDItems.REGISTRAR.register(name, () -> new BlockItem(registryObject.get(), new Item.Properties().tab(HTTYMD.HTTYMD_GROUP)));
        return registryObject;
    }
}
