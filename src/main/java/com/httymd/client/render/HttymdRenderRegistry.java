package com.httymd.client.render;

import com.httymd.entities.EntityBoar;
import com.httymd.entities.EntityEel;
import com.httymd.entities.EntityTerribleTerror;
import com.httymd.entities.EntityYak;
import com.httymd.entities.projectile.SpearEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class HttymdRenderRegistry {
    public static void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityTerribleTerror.class, new TerribleTerrorRender.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityYak.class, new YakRender.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityBoar.class, new BoarRender.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(SpearEntity.class, new SpearRender.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityEel.class, new EelRender.RenderFactory());
    }
}
