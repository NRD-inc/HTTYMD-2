package com.httymd.client.render.entity;

import com.httymd.Ref;
import com.httymd.client.model.entity.ModelTerribleTerror;
import com.httymd.entity.EntityTerribleTerror;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderTerribleTerror extends RenderLiving<EntityTerribleTerror> {
    private static final ResourceLocation TERROR_1 = new ResourceLocation(Ref.MOD_ID + ":textures/entity/dragon/terrible_terror_1.png");
    private static final ResourceLocation TERROR_2 = new ResourceLocation(Ref.MOD_ID + ":textures/entity/dragon/terrible_terror_2.png");

    public RenderTerribleTerror(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelTerribleTerror(), 0.2F);
    }

    @Override
    protected void preRenderCallback(EntityTerribleTerror entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, -0.25F, 0.0F);
        super.preRenderCallback(entitylivingbaseIn, partialTickTime);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityTerribleTerror entity) {
        int i = entity.getTextureVariant();

        switch (i) {
            case 0:
            default:
                return TERROR_1;
            case 1:
                return TERROR_2;
        }
    }
}
