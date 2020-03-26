package com.Httymd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.Httymd.client.render.HttymdRenderRegistry;
import com.Httymd.items.ItemDagger;
import com.Httymd.lists.ArmorMaterialList;
import com.Httymd.lists.BlockList;
import com.Httymd.lists.Entities;
import com.Httymd.lists.ItemList;
import com.Httymd.lists.ToolMaterialList;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/*
 * Mod ID is currently set to HTTYMD, if you need to change it, 
 * change it here, on line 18(public static final String modid = "HTTYMD";), and in mods.toml
*/
@Mod("httymd")
public class Httymd {
	//used to reference the class Hyytmd() outside of the class
	public static Httymd instance;
	public static final String modid = "httymd";
	/*Used for console output, example:
	 * Logger.into("print statement here");
	*/
	private static final Logger logger = LogManager.getLogger(modid);
	
	//registering the custom creative tab and naming the 'variable' to DragonItemGroup
	public static final ItemGroup DragonItemGroup = new HttymdItemGroup("DragonItemGroup");
	
	public Httymd() {
		MinecraftForge.EVENT_BUS.register(this);
		
		//sets instance equal to this class so it can be referenced elsewhere
		instance = this;
		
		//Loading setup and client registries when this mod loads initially
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
	}
	
	//Mod initialization
	private void setup(final FMLCommonSetupEvent event) {
		
	}
	
	//Client initialization
	private void clientRegistries(final FMLClientSetupEvent event) {
		
	}
	
	//Registry Events
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents{
		
		//Item Registry
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			event.getRegistry().registerAll(
					//This is the item list with properties and registries
					ItemList.gronckle_iron = new Item(new Item.Properties().group(DragonItemGroup)).setRegistryName(location("gronckle_iron")),
					ItemList.gronckle_iron_nugget = new Item(new Item.Properties().group(DragonItemGroup)).setRegistryName(location("gronckle_iron_nugget")),
					
					//Tools
					ItemList.gronckle_iron_axe = new AxeItem(ToolMaterialList.Gronckle, +1.0F, 6.0F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("gronckle_iron_axe")),
					ItemList.gronckle_iron_pickaxe = new PickaxeItem(ToolMaterialList.Gronckle, -1, 4.5F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("gronckle_iron_pickaxe")),
					ItemList.gronckle_iron_sword = new SwordItem(ToolMaterialList.Gronckle, 1, 6.0F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("gronckle_iron_sword")),
					ItemList.gronckle_iron_shovel = new ShovelItem(ToolMaterialList.Gronckle, -1.5F, 6.0F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("gronckle_iron_shovel")),
					ItemList.gronckle_iron_hoe = new HoeItem(ToolMaterialList.Gronckle, 0, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("gronckle_iron_hoe")),
					ItemList.gronckle_iron_dagger = new ItemDagger(ToolMaterialList.Gronckle, -2, 3.5F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("gronckle_iron_dagger")),
					ItemList.gronckle_iron_warhammer = new SwordItem(ToolMaterialList.Gronckle, +3, -3.0F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("gronckle_iron_warhammer")),
					ItemList.gronckle_iron_battleaxe = new SwordItem(ToolMaterialList.Gronckle, +2, -2.5F, new  Item.Properties().group(DragonItemGroup)).setRegistryName(location("gronckle_iron_battleaxe")),
					ItemList.gronckle_iron_club = new SwordItem(ToolMaterialList.Gronckle, +2, -2.5F, new  Item.Properties().group(DragonItemGroup)).setRegistryName(location("gronckle_iron_club")),
					ItemList.gronckle_iron_mace = new SwordItem(ToolMaterialList.Gronckle, +2, -2.5F, new  Item.Properties().group(DragonItemGroup)).setRegistryName(location("gronckle_iron_mace")),
					
					//Defalt Minecraft material tools
					//To use default minecraft materials, do this: \/ \/
					ItemList.stone_dagger = new ItemDagger(ItemTier.STONE, -0, 3.5F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("stone_dagger")),
					ItemList.wood_dagger = new ItemDagger(ItemTier.WOOD, -0, 3.5F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("wood_dagger")),
					ItemList.iron_dagger = new ItemDagger(ItemTier.IRON, -0, 3.5F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("iron_dagger")),
					ItemList.gold_dagger = new ItemDagger(ItemTier.GOLD, -0, 3.5F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("gold_dagger")),
					ItemList.diamond_dagger = new ItemDagger(ItemTier.DIAMOND, -0, 3.5F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("diamond_dagger")),
					ItemList.stone_battleaxe = new SwordItem(ItemTier.STONE, +5, -2.8F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("stone_battleaxe")),
					ItemList.wood_battleaxe = new SwordItem(ItemTier.WOOD, +4, -2.8F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("wood_battleaxe")),
					ItemList.iron_battleaxe = new SwordItem(ItemTier.IRON, +4, -2.8F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("iron_battleaxe")),
					ItemList.gold_battleaxe = new SwordItem(ItemTier.GOLD, +4, -2.8F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("gold_battleaxe")),
					ItemList.diamond_battleaxe = new SwordItem(ItemTier.DIAMOND, +4, -2.8F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("diamond_battleaxe")),
					ItemList.stone_club = new SwordItem(ItemTier.STONE, +4, -2.8F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("stone_club")),
					ItemList.wood_club = new SwordItem(ItemTier.WOOD, +3, -2.8F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("wood_club")),
					ItemList.iron_club = new SwordItem(ItemTier.IRON, +3, -2.8F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("iron_club")),
					ItemList.gold_club = new SwordItem(ItemTier.GOLD, +3, -2.8F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("gold_club")),
					ItemList.diamond_club = new SwordItem(ItemTier.DIAMOND, +3, -2.8F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("diamond_club")),
					ItemList.stone_mace = new SwordItem(ItemTier.STONE, +4, -2.8F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("stone_mace")),
					ItemList.wood_mace = new SwordItem(ItemTier.WOOD, +3, -2.8F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("wood_mace")),
					ItemList.iron_mace = new SwordItem(ItemTier.IRON, +3, -2.8F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("iron_mace")),
					ItemList.gold_mace = new SwordItem(ItemTier.GOLD, +3, -2.8F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("gold_mace")),
					ItemList.diamond_mace = new SwordItem(ItemTier.DIAMOND, +3, -2.8F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("diamond_mace")),
					
					//Armor
					ItemList.gronckle_iron_helmet = new ArmorItem(ArmorMaterialList.GronckleArmor, EquipmentSlotType.HEAD, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("gronckle_iron_helmet")),
					ItemList.gronckle_iron_chestplate = new ArmorItem(ArmorMaterialList.GronckleArmor, EquipmentSlotType.CHEST, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("gronckle_iron_chestplate")),
					ItemList.gronckle_iron_leggings = new ArmorItem(ArmorMaterialList.GronckleArmor, EquipmentSlotType.LEGS, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("gronckle_iron_leggings")),
					ItemList.gronckle_iron_boots = new ArmorItem(ArmorMaterialList.GronckleArmor, EquipmentSlotType.FEET, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("gronckle_iron_boots")),
					
					//This section of item imports is used for importing blocks as items
					ItemList.mud_block = new BlockItem(BlockList.mud_block, new Item.Properties().group(DragonItemGroup)).setRegistryName(BlockList.mud_block.getRegistryName())
			);			
			Entities.registerEntitySpawnEggs(event);
			
			logger.info("Items Registered");
		}
		
		//Block Registry
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			event.getRegistry().registerAll(
					//Register all blocks here
					BlockList.mud_block = new Block(Block.Properties.create(Material.SAND).hardnessAndResistance(0.5f).sound(SoundType.GROUND)).setRegistryName(location("mud_block"))
			);
			logger.info("Blocks Registered");
		}
		
		//Entity Registry
		@SubscribeEvent
		public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
			event.getRegistry().registerAll(
					Entities.TERRIBLE_TERROR
			);
			Entities.registerEntityWorldSpawns();
			
			logger.info("Entities Registered");
		}
		
		@SubscribeEvent
		public static void registerRenders(final ModelRegistryEvent event) {
			HttymdRenderRegistry.registerEntityRenders();
		}
	}
		
	//This is a function that replaces what would normally be in .setRegistryName to keep things cleaner
	public static ResourceLocation location(String name) {
		return new ResourceLocation(modid, name);
	}
}
