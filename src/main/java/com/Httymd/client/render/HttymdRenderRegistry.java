package com.Httymd.client.render;

import com.Httymd.entities.EntityBoar;
import com.Httymd.entities.EntityTerribleTerror;
import com.Httymd.entities.EntityYak;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.api.distmarker.Dist;

@OnlyIn(Dist.CLIENT)
public class HttymdRenderRegistry {
	public static void registerEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntityTerribleTerror.class, new TerribleTerrorRender.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntityYak.class, new YakRender.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntityBoar.class, new BoarRender.RenderFactory());
	}
}
