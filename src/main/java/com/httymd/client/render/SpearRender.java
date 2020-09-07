package com.httymd.client.render;

import com.httymd.Httymd;
import com.httymd.entities.projectile.SpearEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class SpearRender extends EntityRenderer<SpearEntity> {

    public SpearRender(EntityRendererManager renderManager) {
        super(renderManager);

    }

    @Override
    public void doRender(SpearEntity entity, double x, double y, double z, float yaw, float partialTick) {
        super.doRender(entity, x, y, z, yaw, partialTick);
    }

    @Override
    protected ResourceLocation getEntityTexture(SpearEntity entity) {
        int var = entity.getVariant();
        switch (var) {
            case 0:
            default:
                return Httymd.location("textures/entity/spear/wood_spear.png");
            case 1:
                return Httymd.location("textures/entity/spear/stone_spear.png");
            case 2:
                return Httymd.location("textures/entity/spear/iron_spear.png");
            case 3:
                return Httymd.location("textures/entity/spear/gronckle_iron_spear.png");
            case 4:
                return Httymd.location("textures/entity/spear/gold_spear.png");
            case 5:
                return Httymd.location("textures/entity/spear/diamond_spear.png");
        }
    }

    public static class RenderFactory implements IRenderFactory<SpearEntity> {

        @Override
        public EntityRenderer<? super SpearEntity> createRenderFor(EntityRendererManager manager) {
            return new SpearRender(manager);
        }
    }
}