package com.httymd.client.models;

import com.httymd.entities.projectile.SpearEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;

public class SpearModel<T extends SpearEntity> extends EntityModel<T> {
    private final RendererModel MainBody;

    public SpearModel() {
        textureWidth = 128;
        textureHeight = 128;

        MainBody = new RendererModel(this);
        MainBody.setRotationPoint(0.0F, 0.0F, 0.0F);
        MainBody.cubeList.add(new ModelBox(MainBody, 0, 0, -5.0F, -8.5F, -15.0F, 12, 15, 16, 0.0F, false));
    }

    @Override
    public void render(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        MainBody.render(scale);
    }

    public void setRotationAngle(RendererModel RendererModel, float x, float y, float z) {
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
    }
}
