package com.Httymd.client.render;

import com.Httymd.Httymd;
import com.Httymd.client.models.BoarModel;
import com.Httymd.entities.EntityBoar;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class BoarRender extends MobRenderer<EntityBoar, BoarModel<EntityBoar>> {
	public BoarRender(EntityRendererManager manager) {
		super(manager, new BoarModel<>(), 1.0F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityBoar entity) {
			return Httymd.location("textures/entity/boar.png");
		}
	
	public static class RenderFactory implements IRenderFactory<EntityBoar>{

		@Override
		public EntityRenderer<? super EntityBoar> createRenderFor(EntityRendererManager manager) {
			return new BoarRender(manager);
		}
	}
}
