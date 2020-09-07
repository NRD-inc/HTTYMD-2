package com.httymd.client.models;

import com.httymd.entities.EntityBoar;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import org.lwjgl.opengl.GL11;

//Made with Blockbench
//Paste this code into your mod.
public class BoarModel<T extends EntityBoar> extends EntityModel<T> {
    private final RendererModel All;
    private final RendererModel Body1;
    private final RendererModel FrontLegRight;
    private final RendererModel Head;
    private final RendererModel EarLeft;
    private final RendererModel EarRight;
    private final RendererModel Snout;
    private final RendererModel Mouth;
    private final RendererModel Fang1;
    private final RendererModel Fang2;
    private final RendererModel FrontLegLeft;
    private final RendererModel Body2;
    private final RendererModel BackLegRight;
    private final RendererModel BackLegLeft;
    private final RendererModel Tail;

    public BoarModel() {
        textureWidth = 64;
        textureHeight = 64;

        All = new RendererModel(this);
        All.setRotationPoint(-1.6F, 17.5F, -1.15F);
        setRotationAngle(All, 0.0F, -2.8798F, 0.0F);

        Body1 = new RendererModel(this);
        Body1.setRotationPoint(-1.25F, 0.0F, -3.0F);
        setRotationAngle(Body1, 0.0F, -0.2618F, 0.0F);
        All.addChild(Body1);
        Body1.cubeList.add(new ModelBox(Body1, 0, 0, -2.8233F, -4.25F, -1.0565F, 6, 8, 7, 0.0F, false));

        FrontLegRight = new RendererModel(this);
        FrontLegRight.setRotationPoint(3.328F, 0.0F, 4.1935F);
        Body1.addChild(FrontLegRight);
        FrontLegRight.cubeList.add(new ModelBox(FrontLegRight, 0, 28, -1.3558F, -0.5F, -1.0F, 2, 7, 2, 0.0F, false));

        Head = new RendererModel(this);
        Head.setRotationPoint(-3.5F, 0.25F, 1.75F);
        FrontLegRight.addChild(Head);
        Head.cubeList.add(new ModelBox(Head, 21, 10, -2.1683F, -3.5F, -1.25F, 5, 6, 5, 0.0F, false));

        EarLeft = new RendererModel(this);
        EarLeft.setRotationPoint(-1.5F, -2.75F, 1.5F);
        setRotationAngle(EarLeft, 0.0F, 0.0F, -0.5236F);
        Head.addChild(EarLeft);
        EarLeft.cubeList.add(new ModelBox(EarLeft, 0, 15, -0.918F, -2.5789F, -0.25F, 2, 3, 1, 0.0F, false));

        EarRight = new RendererModel(this);
        EarRight.setRotationPoint(2.5F, -3.0F, 1.5F);
        setRotationAngle(EarRight, 0.0F, 0.0F, 0.5236F);
        Head.addChild(EarRight);
        EarRight.cubeList.add(new ModelBox(EarRight, 30, 21, -1.2446F, -2.1124F, -0.5F, 2, 3, 1, 0.0F, false));

        Snout = new RendererModel(this);
        Snout.setRotationPoint(-2.8571F, 0.25F, 5.6247F);
        setRotationAngle(Snout, 0.0F, 3.1416F, 0.0F);
        FrontLegRight.addChild(Snout);
        Snout.cubeList.add(new ModelBox(Snout, 19, 0, -1.75F, -1.75F, -0.75F, 4, 3, 2, 0.0F, false));

        Mouth = new RendererModel(this);
        Mouth.setRotationPoint(0.3571F, 0.75F, 0.1253F);
        setRotationAngle(Mouth, -0.2618F, 3.1416F, 0.0F);
        Snout.addChild(Mouth);
        Mouth.cubeList.add(new ModelBox(Mouth, 20, 24, -1.4183F, -1.9788F, -0.6079F, 3, 4, 4, 0.0F, false));

        Fang1 = new RendererModel(this);
        Fang1.setRotationPoint(1.75F, 0.5212F, 1.6421F);
        setRotationAngle(Fang1, -0.0873F, 0.0F, 0.6109F);
        Mouth.addChild(Fang1);
        Fang1.cubeList.add(new ModelBox(Fang1, 0, 4, -0.6941F, -1.2381F, -0.378F, 1, 2, 1, 0.0F, false));

        Fang2 = new RendererModel(this);
        Fang2.setRotationPoint(-1.4642F, 0.5212F, 1.8921F);
        setRotationAngle(Fang2, -0.0873F, -0.0873F, -0.6109F);
        Mouth.addChild(Fang2);
        Fang2.cubeList.add(new ModelBox(Fang2, 0, 4, -0.2961F, -1.2104F, -0.5303F, 1, 2, 1, 0.0F, true));

        FrontLegLeft = new RendererModel(this);
        FrontLegLeft.setRotationPoint(-2.422F, 0.0F, 4.1935F);
        Body1.addChild(FrontLegLeft);
        FrontLegLeft.cubeList.add(new ModelBox(FrontLegLeft, 8, 28, -1.1058F, -0.5F, -1.0F, 2, 7, 2, 0.0F, false));

        Body2 = new RendererModel(this);
        Body2.setRotationPoint(0.078F, 1.0F, -1.5565F);
        Body1.addChild(Body2);
        Body2.cubeList.add(new ModelBox(Body2, 0, 15, -2.4183F, -3.75F, -4.5F, 5, 6, 7, 0.0F, false));

        BackLegRight = new RendererModel(this);
        BackLegRight.setRotationPoint(2.5F, -0.25F, -2.25F);
        Body2.addChild(BackLegRight);
        BackLegRight.cubeList.add(new ModelBox(BackLegRight, 31, 0, -0.8558F, -0.25F, -1.0F, 2, 6, 2, 0.0F, false));

        BackLegLeft = new RendererModel(this);
        BackLegLeft.setRotationPoint(-2.5F, -0.25F, -2.0F);
        Body2.addChild(BackLegLeft);
        BackLegLeft.cubeList.add(new ModelBox(BackLegLeft, 16, 32, -0.8558F, -0.25F, -1.5F, 2, 6, 2, 0.0F, false));

        Tail = new RendererModel(this);
        Tail.setRotationPoint(0.0F, 1.25F, -4.5F);
        setRotationAngle(Tail, 0.3491F, 0.0F, 0.0F);
        Body2.addChild(Tail);
        Tail.cubeList.add(new ModelBox(Tail, 0, 0, 0.1442F, -0.5996F, -1.7155F, 0, 1, 3, 0.0F, false));
    }

    @Override
    public void render(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        GL11.glPushMatrix();
        GL11.glScalef(1.5F, 1.5F, 1.5F);
        GL11.glTranslatef(0.0F, -0.5F, 0.0F);
        All.render(scale);
        GL11.glPopMatrix();
    }

    public void setRotationAngle(RendererModel RendererModel, float x, float y, float z) {
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
    }
}