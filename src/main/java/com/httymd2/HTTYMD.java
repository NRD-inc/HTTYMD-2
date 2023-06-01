package com.httymd2;

import com.httymd2.world.entity.HTTYMDEntities;
import com.httymd2.world.level.block.HTTYMDBlocks;
import com.httymd2.world.item.HTTYMDItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(HTTYMD.MOD_ID)
public class HTTYMD {
    public static final String MOD_ID = "httymd";

    public static final CreativeModeTab HTTYMD_GROUP = new CreativeModeTab("httymd") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(HTTYMDItems.GRONCKLE_IRON_INGOT.get());
        }
    };

    public HTTYMD() {
        IEventBus eventbus = FMLJavaModLoadingContext.get().getModEventBus();

        HTTYMDEntities.REGISTRAR.register(eventbus);
        HTTYMDBlocks.REGISTRAR.register(eventbus);
        HTTYMDItems.REGISTRAR.register(eventbus);
    }
}
