package com.httymd;

import com.httymd.init.ModBlocks;
import com.httymd.init.ModItems;
import com.httymd.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod(
        modid = Ref.MOD_ID,
        name = Ref.NAME,
        version = Ref.VERSION,
		acceptedMinecraftVersions = Ref.ACCEPTED_VERSIONS
)
public class HTTYMD {
    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance
    public static HTTYMD INSTANCE;

    @SidedProxy(serverSide = Ref.SERVER_PROXY, clientSide = Ref.CLIENT_PROXY)
    public static CommonProxy PROXY;

    public static SimpleNetworkWrapper NETWORK;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
		PROXY.preInit(event);
    }

    /**
     * This is the second initialization event. Register custom recipes here.
     */
    @EventHandler
    public void init(FMLInitializationEvent event) {
		PROXY.init(event);
    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @EventHandler
    public void postinit(FMLPostInitializationEvent event) {
		PROXY.postInit(event);
    }

    /*/**
     * Forge will automatically look up and bind blocks to the fields in this class
     * based on their registry name.
     */
    /*@GameRegistry.ObjectHolder(MOD_ID)
    public static class Blocks {
          public static final MySpecialBlock mySpecialBlock = null; // placeholder for special block below
    }*/

    /*/**
     * Forge will automatically look up and bind items to the fields in this class
     * based on their registry name.
     */
    /*@GameRegistry.ObjectHolder(MOD_ID)
    public static class Items {
          public static final ItemBlock mySpecialBlock = null; // itemblock for the block above
          public static final MySpecialItem mySpecialItem = null; // placeholder for special item below
    }*/

    /**
     * This is a special class that listens to registry events, to allow creation of mod blocks and items at the proper time.
     */
    @Mod.EventBusSubscriber
    public static class ObjectRegistryHandler {
        /**
         * Listen for the register event for creating custom blocks
         */
        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            ModBlocks.register(event.getRegistry());
			/*event.getRegistry().register(new MySpecialBlock().setRegistryName(MOD_ID, "mySpecialBlock"));*/
        }
		
        /**
         * Listen for the register event for creating custom items
         */
        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ModItems.register(event.getRegistry());
            ModBlocks.registerItemBlocks(event.getRegistry());
			/*event.getRegistry().register(new ItemBlock(Blocks.myBlock).setRegistryName(MOD_ID, "myBlock"));
             event.getRegistry().register(new MySpecialItem().setRegistryName(MOD_ID, "mySpecialItem"));*/
        }
		
		/**
		 * Listen for the register event for creating custom item and block models
		 */
		@SubscribeEvent
        public static void registerModels(ModelRegistryEvent event) {
            ModItems.registerModels();
            ModBlocks.registerModels();
        }
    }
	
    /* EXAMPLE ITEM AND BLOCK - you probably want these in separate files
    public static class MySpecialItem extends Item {

    }

    public static class MySpecialBlock extends Block {

    }
    */
}
