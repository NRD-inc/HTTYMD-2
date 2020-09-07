package com.httymd;

import com.httymd.block.CustomDoor;
import com.httymd.block.CustomSapling;
import com.httymd.block.trees.LokiTree;
import com.httymd.block.trees.PineTree;
import com.httymd.client.render.HttymdRenderRegistry;
import com.httymd.items.ItemDagger;
import com.httymd.items.ItemSpear;
import com.httymd.lists.*;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

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
                    ItemList.gronckle_iron_battleaxe = new SwordItem(ToolMaterialList.Gronckle, +2, -2.5F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("gronckle_iron_battleaxe")),
                    ItemList.gronckle_iron_club = new SwordItem(ToolMaterialList.Gronckle, +2, -2.5F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("gronckle_iron_club")),
                    ItemList.gronckle_iron_mace = new SwordItem(ToolMaterialList.Gronckle, +2, -2.5F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("gronckle_iron_mace")),
                    ItemList.gronckle_iron_spear = new ItemSpear(ToolMaterialList.Gronckle, +1.5F, -2, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("gronckle_iron_spear")),

                    //Defalt Minecraft material tools
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
                    ItemList.iron_mace = new SwordItem(ItemTier.IRON, +3, -2.8F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("iron_mace")),
                    ItemList.gold_mace = new SwordItem(ItemTier.GOLD, +3, -2.8F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("gold_mace")),
                    ItemList.diamond_mace = new SwordItem(ItemTier.DIAMOND, +3, -2.8F, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("diamond_mace")),
                    ItemList.wood_spear = new ItemSpear(ItemTier.WOOD, +1.5F, -2, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("wood_spear")),
                    ItemList.stone_spear = new ItemSpear(ItemTier.STONE, +1.5F, -2, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("stone_spear")),
                    ItemList.iron_spear = new ItemSpear(ItemTier.IRON, +1.5F, -2, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("iron_spear")),
                    ItemList.gold_spear = new ItemSpear(ItemTier.GOLD, +1.5F, -2, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("gold_spear")),
                    ItemList.diamond_spear = new ItemSpear(ItemTier.DIAMOND, +1.5F, -2, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("diamond_spear")),

                    //Armor
                    ItemList.gronckle_iron_helmet = new ArmorItem(ArmorMaterialList.GronckleArmor, EquipmentSlotType.HEAD, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("gronckle_iron_helmet")),
                    ItemList.gronckle_iron_chestplate = new ArmorItem(ArmorMaterialList.GronckleArmor, EquipmentSlotType.CHEST, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("gronckle_iron_chestplate")),
                    ItemList.gronckle_iron_leggings = new ArmorItem(ArmorMaterialList.GronckleArmor, EquipmentSlotType.LEGS, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("gronckle_iron_leggings")),
                    ItemList.gronckle_iron_boots = new ArmorItem(ArmorMaterialList.GronckleArmor, EquipmentSlotType.FEET, new Item.Properties().group(DragonItemGroup)).setRegistryName(location("gronckle_iron_boots")),

                    //This section of item imports is used for importing blocks as items
                    ItemList.mud_block = new BlockItem(BlockList.mud_block, new Item.Properties().group(DragonItemGroup)).setRegistryName(BlockList.mud_block.getRegistryName()),
                    ItemList.loki_sapling = new BlockItem(BlockList.loki_sapling, new Item.Properties().group(DragonItemGroup)).setRegistryName(BlockList.loki_sapling.getRegistryName()),
                    ItemList.loki_log = new BlockItem(BlockList.loki_log, new Item.Properties().group(DragonItemGroup)).setRegistryName(BlockList.loki_log.getRegistryName()),
                    ItemList.loki_plank = new BlockItem(BlockList.loki_plank, new Item.Properties().group(DragonItemGroup)).setRegistryName(BlockList.loki_plank.getRegistryName()),
                    ItemList.loki_stair = new BlockItem(BlockList.loki_stair, new Item.Properties().group(DragonItemGroup)).setRegistryName(BlockList.loki_stair.getRegistryName()),
                    ItemList.loki_door = new BlockItem(BlockList.loki_door, new Item.Properties().group(DragonItemGroup)).setRegistryName(BlockList.loki_door.getRegistryName()),
                    ItemList.loki_leaves = new BlockItem(BlockList.loki_leaves, new Item.Properties().group(DragonItemGroup)).setRegistryName(BlockList.loki_leaves.getRegistryName()),
                    ItemList.pine_sapling = new BlockItem(BlockList.pine_sapling, new Item.Properties().group(DragonItemGroup)).setRegistryName(BlockList.pine_sapling.getRegistryName()),
                    ItemList.pine_log = new BlockItem(BlockList.pine_log, new Item.Properties().group(DragonItemGroup)).setRegistryName(BlockList.pine_log.getRegistryName()),
                    ItemList.pine_plank = new BlockItem(BlockList.pine_plank, new Item.Properties().group(DragonItemGroup)).setRegistryName(BlockList.pine_plank.getRegistryName()),
                    ItemList.pine_stair = new BlockItem(BlockList.pine_stair, new Item.Properties().group(DragonItemGroup)).setRegistryName(BlockList.pine_stair.getRegistryName()),
                    ItemList.pine_door = new BlockItem(BlockList.pine_door, new Item.Properties().group(DragonItemGroup)).setRegistryName(BlockList.pine_door.getRegistryName()),
                    ItemList.pine_leaves = new BlockItem(BlockList.pine_leaves, new Item.Properties().group(DragonItemGroup)).setRegistryName(BlockList.pine_leaves.getRegistryName())
            );
            Entities.registerEntitySpawnEggs(event);

            logger.info("Items Registered");
        }

        //Block Registry
        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            event.getRegistry().registerAll(
                    //Register all blocks here
                    BlockList.mud_block = new Block(Block.Properties.create(Material.SAND).hardnessAndResistance(0.5f).sound(SoundType.GROUND)).setRegistryName(location("mud_block")),
                    BlockList.loki_log = new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f).sound(SoundType.WOOD)).setRegistryName(location("loki_log")),
                    BlockList.loki_plank = new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(1.8f).sound(SoundType.WOOD)).setRegistryName(location("loki_plank")),
                    BlockList.loki_stair = new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.8f).sound(SoundType.WOOD)).setRegistryName(location("loki_stair")),
                    BlockList.loki_door = new CustomDoor(Block.Properties.create(Material.WOOD).hardnessAndResistance(3.0f).sound(SoundType.WOOD)).setRegistryName(location("loki_door")),
                    BlockList.loki_leaves = new Block(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.9f).sound(SoundType.PLANT)).setRegistryName(location("loki_leaves")),
                    BlockList.pine_sapling = new CustomSapling(new PineTree(), Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.0f).sound(SoundType.PLANT).doesNotBlockMovement().tickRandomly()).setRegistryName(location("pine_sapling")),
                    BlockList.pine_log = new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f).sound(SoundType.WOOD)).setRegistryName(location("pine_log")),
                    BlockList.pine_plank = new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.8f).sound(SoundType.WOOD)).setRegistryName(location("pine_plank")),
                    BlockList.pine_stair = new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.8f).sound(SoundType.WOOD)).setRegistryName(location("pine_stair")),
                    BlockList.pine_door = new CustomDoor(Block.Properties.create(Material.WOOD).hardnessAndResistance(3.0f).sound(SoundType.WOOD)).setRegistryName(location("pine_door")),
                    BlockList.pine_leaves = new Block(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.9f).sound(SoundType.PLANT)).setRegistryName(location("pne_leaves")),
                    BlockList.loki_sapling = new CustomSapling(new LokiTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0f).sound(SoundType.PLANT)).setRegistryName(location("loki_sapling"))
            );

            logger.info("Blocks Registered");
        }

        //Particle Registry


        //Entity Registry
        @SubscribeEvent
        public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
            event.getRegistry().registerAll(
                    Entities.TERRIBLE_TERROR,
                    Entities.YAK,
                    Entities.BOAR,
                    Entities.SPEAR,
                    Entities.TERRIBLE_TERROR_FIRE,
                    Entities.EEL
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
