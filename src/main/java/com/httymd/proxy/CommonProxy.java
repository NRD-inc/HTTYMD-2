package com.httymd.proxy;

import com.httymd.HTTYMD;
import com.httymd.HTTYMDEvents;
import com.httymd.Ref;
import com.httymd.entity.EntityTerribleTerror;
import com.httymd.init.ModBlocks;
import com.httymd.init.ModItems;
import com.httymd.message.MessageExtendedReachAttack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber
public class CommonProxy {
    public final CreativeTabs HTTYMD_TAB = new CreativeTabs(Ref.MOD_ID + ".tab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.BAKED_POTATO);
        }
    };

    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new HTTYMDEvents());
        //FMLCommonHandler.instance().bus().register(new HTTYMDEvents());

        HTTYMD.NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel(Ref.MOD_ID);
        int PACKET_ID = 0;
        HTTYMD.NETWORK.registerMessage(MessageExtendedReachAttack.Handler.class, MessageExtendedReachAttack.class, PACKET_ID++, Side.SERVER);

        int ENTITY_ID = 0;
        EntityRegistry.registerModEntity(new ResourceLocation(Ref.MOD_ID + ":terrible_terror"), EntityTerribleTerror.class, "terrible_terror", ENTITY_ID++, HTTYMD.INSTANCE, 80, 1, true, 0x000000, 0x000000);
    }

    public void init(FMLInitializationEvent event) {
        ModItems.initOreDict();
        ModBlocks.initOreDict();
    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    public void registerItemRenderer(Item item, int meta, String id) {

    }
}
