package com.Httymd.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;

public class CustomDragonEntityType<T extends Entity> extends net.minecraftforge.registries.ForgeRegistryEntry<EntityType<?>>  {
	 //public static final EntityType<EntityTerribleTerror> TERRIBLE_TERROR = register("terrible_terror", EntityType.Builder.create(EntityTerribleTerror::new, EntityClassification.CREATURE).immuneToFire().size(2.25F, 5.0F));
	 public static final EntityType<TerribleTerrorFireShot> TERRIBLE_TERROR_FIRE = register("terrible_terror_fire", EntityType.Builder.<TerribleTerrorFireShot>create(TerribleTerrorFireShot::new, EntityClassification.MISC).size(0.25F, 0.25F));
	 
	 @SuppressWarnings("deprecation")
	private static <T extends Entity> EntityType<T> register(String key, EntityType.Builder<T> builder) {
	      return Registry.register(Registry.ENTITY_TYPE, key, builder.build(key));
	   }
}
