package com.Httymd.client.render;

import com.Httymd.Httymd;
import com.Httymd.client.models.TerribleTerrorModel;
import com.Httymd.entities.EntityTerribleTerror;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class TerribleTerrorRender extends LivingRenderer<EntityTerribleTerror, TerribleTerrorModel<EntityTerribleTerror>>{
	
	public TerribleTerrorRender(EntityRendererManager manager) {
		super(manager, new TerribleTerrorModel<>(), 1.0F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityTerribleTerror entity) {
		int var = entity.getVariant();
		switch(var) {
			case 0: 
			default:
				return Httymd.location("textures/entity/terrible_terror/terrible_terror_1.png");
			case 1:
				return Httymd.location("textures/entity/terrible_terror/terrible_terror_2.png");
			case 2:
				return Httymd.location("textures/entity/terrible_terror/terrible_terror_3.png");
			case 3:
				return Httymd.location("textures/entity/terrible_terror/terrible_terror_4.png");
			case 4:
				return Httymd.location("textures/entity/terrible_terror/terrible_terror_5.png");
			case 5:
				return Httymd.location("textures/entity/terrible_terror/terrible_terror_6.png");
		}
	}
	
	public static class RenderFactory implements IRenderFactory<EntityTerribleTerror>{

		@Override
		public EntityRenderer<? super EntityTerribleTerror> createRenderFor(EntityRendererManager manager) {
			return new TerribleTerrorRender(manager);
		}
	}
}
