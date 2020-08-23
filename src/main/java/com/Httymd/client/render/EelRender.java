package com.Httymd.client.render;

import com.Httymd.Httymd;
import com.Httymd.client.models.EelModel;
import com.Httymd.entities.EntityEel;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class EelRender extends MobRenderer<EntityEel, EelModel<EntityEel>>{
	public EelRender(EntityRendererManager manager) {
		super(manager, new EelModel<>(), 1.0F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityEel entity) {
		int var = entity.getVariant();
		switch(var) {
			case 0: 
			default:
				return Httymd.location("textures/entity/eel/eel.png");
			case 1:
				return Httymd.location("textures/entity/eel/eel_blood.png");
		}
	}
	
	public static class RenderFactory implements IRenderFactory<EntityEel>{

		@Override
		public EntityRenderer<? super EntityEel> createRenderFor(EntityRendererManager manager) {
			return new EelRender(manager);
		}
	}
}
