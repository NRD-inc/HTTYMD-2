package com.httymd.client.render;

import com.httymd.Httymd;
import com.httymd.client.models.YakModel;
import com.httymd.entities.EntityYak;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class YakRender extends MobRenderer<EntityYak, YakModel<EntityYak>> {
    public YakRender(EntityRendererManager manager) {
        super(manager, new YakModel<>(), 1.0F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityYak entity) {
        int var = entity.getVariant();
        switch (var) {
            case 0:
            default:
                return Httymd.location("textures/entity/yak/yak.png");
            case 1:
                return Httymd.location("textures/entity/yak/yak_reddish.png");
        }
    }

    public static class RenderFactory implements IRenderFactory<EntityYak> {

        @Override
        public EntityRenderer<? super EntityYak> createRenderFor(EntityRendererManager manager) {
            return new YakRender(manager);
        }
    }
}
