package com.httymd.lists;

import com.httymd.Httymd;
import com.httymd.entities.*;
import com.httymd.entities.projectile.SpearEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.RegistryEvent;

public class Entities {
    //The entities
    public static final EntityType<EntityTerribleTerror> TERRIBLE_TERROR = register("terrible_terror", EntityType.Builder.create(EntityTerribleTerror::new, EntityClassification.CREATURE).immuneToFire().size(0.5F, 0.5F).setShouldReceiveVelocityUpdates(false));
    public static final EntityType<NonAbstractDragonEntityBase> DRAGON_BASE = register("dragon_base", EntityType.Builder.create(NonAbstractDragonEntityBase::new, EntityClassification.CREATURE).immuneToFire().setShouldReceiveVelocityUpdates(true));
    public static final EntityType<TerribleTerrorFireShot> TERRIBLE_TERROR_FIRE = register("terrible_terror_fire", EntityType.Builder.<TerribleTerrorFireShot>create(TerribleTerrorFireShot::new, EntityClassification.MISC).size(0.125F, 0.125F));
    public static final EntityType<EntityYak> YAK = register("yak", EntityType.Builder.create(EntityYak::new, EntityClassification.CREATURE).size(2.5F, 2.25F));
    public static final EntityType<EntityBoar> BOAR = register("boar", EntityType.Builder.create(EntityBoar::new, EntityClassification.CREATURE).size(0.75F, 1F));
    public static final EntityType<SpearEntity> SPEAR = register("spear", EntityType.Builder.<SpearEntity>create(SpearEntity::new, EntityClassification.MISC).size(0.25F, 0.25F));
    public static final EntityType<EntityEel> EEL = register("eel", EntityType.Builder.create(EntityEel::new, EntityClassification.WATER_CREATURE).size(0.25F, 0.5F));

    //The entity spawn egg calls
    public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                ItemList.terrible_terror_egg = registerEntitySpawnEgg(TERRIBLE_TERROR, 0x0f4d2a, 0xab5a20, "terrible_terror_spawn_egg"),
                ItemList.yak_egg = registerEntitySpawnEgg(YAK, 0x6b463a, 0x9c6452, "yak_spawn_egg"),
                ItemList.boar_egg = registerEntitySpawnEgg(BOAR, 0x261f1f, 0xffffff, "boar_spawn_egg"),
                ItemList.eel_egg = registerEntitySpawnEgg(EEL, 0x000000, 0xfcba03, "eel_spawn_egg")
        );
    }

    //The spawn init calls for the entities
    public static void registerEntityWorldSpawns() {
        registerEntityWorldSpawn(TERRIBLE_TERROR, 10, 6, EntityClassification.CREATURE, Biomes.BAMBOO_JUNGLE, Biomes.BAMBOO_JUNGLE_HILLS, Biomes.BEACH, Biomes.FOREST, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS, Biomes.MOUNTAINS, Biomes.MOUNTAIN_EDGE);
        registerEntityWorldSpawn(YAK, 25, 3, EntityClassification.CREATURE, Biomes.MOUNTAINS, Biomes.MOUNTAIN_EDGE);
        registerEntityWorldSpawn(BOAR, 25, 3, EntityClassification.CREATURE, Biomes.MOUNTAINS, Biomes.MOUNTAIN_EDGE);
        registerEntityWorldSpawn(EEL, 30, 1, EntityClassification.WATER_CREATURE, Biomes.COLD_OCEAN, Biomes.DEEP_COLD_OCEAN);
    }

    //The egg specifications
    public static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, String name) {
        SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(Httymd.DragonItemGroup));
        item.setRegistryName(Httymd.location(name));
        return item;
    }

    //The spawn init specifications
    public static void registerEntityWorldSpawn(EntityType<?> entity, int spawnRate, int maxGroup, EntityClassification classification, Biome... biomes) {
        for (Biome biome : biomes) {
            if (biome != null) {
                biome.getSpawns(classification).add(new SpawnListEntry(entity, spawnRate, 1, maxGroup));
            }
        }
    }

    @SuppressWarnings("deprecation")
    private static <T extends Entity> EntityType<T> register(String key, EntityType.Builder<T> builder) {
        return Registry.register(Registry.ENTITY_TYPE, key, builder.build(key));
    }
}
