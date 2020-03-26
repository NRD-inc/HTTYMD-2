package com.Httymd.client.models;

import org.lwjgl.opengl.GL11;

//Made with Blockbench
//Paste this code into your mod.

import com.Httymd.entities.EntityYak;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;

public class YakModel<T extends EntityYak> extends EntityModel<T> {
	private final RendererModel All;
	private final RendererModel MainBody;
	private final RendererModel FrontBody;
	private final RendererModel Neck;
	private final RendererModel Head;
	private final RendererModel Hair;
	private final RendererModel HornLeft1;
	private final RendererModel HornLeft2;
	private final RendererModel HornLeft3;
	private final RendererModel HornRight1;
	private final RendererModel HornRight2;
	private final RendererModel HornRight3;
	private final RendererModel EarLeft;
	private final RendererModel EarRight;
	private final RendererModel Mouth;
	private final RendererModel FrontLegRight;
	private final RendererModel FrontLegLeft;
	private final RendererModel Hump;
	private final RendererModel BackBody;
	private final RendererModel BackLegRight;
	private final RendererModel BackLegLeft;
	private final RendererModel Tail;

	public YakModel() {
		textureWidth = 128;
		textureHeight = 128;

		All = new RendererModel(this);
		All.setRotationPoint(0.0F, 15.75F, -1.0F);

		MainBody = new RendererModel(this);
		MainBody.setRotationPoint(0.0F, -0.5F, 6.75F);
		All.addChild(MainBody);
		MainBody.cubeList.add(new ModelBox(MainBody, 0, 0, -5.911F, -8.5F, -15.25F, 12, 15, 16, 0.0F, false));

		FrontBody = new RendererModel(this);
		FrontBody.setRotationPoint(0.0F, -4.0F, -15.75F);
		MainBody.addChild(FrontBody);
		FrontBody.cubeList.add(new ModelBox(FrontBody, 40, 40, -4.911F, -1.75F, -2.75F, 10, 11, 5, 0.0F, false));

		Neck = new RendererModel(this);
		Neck.setRotationPoint(0.0F, 3.75F, -3.0F);
		FrontBody.addChild(Neck);
		Neck.cubeList.add(new ModelBox(Neck, 31, 31, -1.911F, -1.75F, -1.75F, 4, 4, 5, 0.0F, false));

		Head = new RendererModel(this);
		Head.setRotationPoint(0.0F, 0.25F, -0.5F);
		Neck.addChild(Head);
		Head.cubeList.add(new ModelBox(Head, 49, 24, -2.911F, -2.5F, -6.75F, 6, 7, 7, 0.0F, false));

		Hair = new RendererModel(this);
		Hair.setRotationPoint(-0.0238F, -2.5F, -4.75F);
		Head.addChild(Hair);
		Hair.cubeList.add(new ModelBox(Hair, 0, 50, -2.3872F, -1.5F, -2.75F, 5, 3, 6, 0.0F, false));

		HornLeft1 = new RendererModel(this);
		HornLeft1.setRotationPoint(2.9762F, -2.5F, -4.5F);
		Head.addChild(HornLeft1);
		HornLeft1.cubeList.add(new ModelBox(HornLeft1, 0, 0, -0.8872F, -1.0F, -1.5F, 4, 2, 3, 0.0F, false));

		HornLeft2 = new RendererModel(this);
		HornLeft2.setRotationPoint(2.2738F, 0.0F, 0.5F);
		setRotationAngle(HornLeft2, 0.0F, 0.0F, 0.5236F);
		HornLeft1.addChild(HornLeft2);
		HornLeft2.cubeList.add(new ModelBox(HornLeft2, 7, 10, -0.7077F, -2.4337F, -1.5F, 2, 3, 2, 0.0F, false));

		HornLeft3 = new RendererModel(this);
		HornLeft3.setRotationPoint(-12.25F, -2.75F, -0.75F);
		setRotationAngle(HornLeft3, 0.0F, 0.0F, -0.3491F);
		HornLeft2.addChild(HornLeft3);
		HornLeft3.cubeList.add(new ModelBox(HornLeft3, 0, 10, 11.359F, 2.9141F, -0.5F, 1, 2, 1, 0.0F, false));

		HornRight1 = new RendererModel(this);
		HornRight1.setRotationPoint(-3.0238F, -2.5F, -4.5F);
		Head.addChild(HornRight1);
		HornRight1.cubeList.add(new ModelBox(HornRight1, 0, 5, -2.8872F, -1.0F, -1.5F, 4, 2, 3, 0.0F, false));

		HornRight2 = new RendererModel(this);
		HornRight2.setRotationPoint(-5.5F, -2.75F, -4.5F);
		setRotationAngle(HornRight2, 0.0F, 0.0F, -0.5236F);
		Head.addChild(HornRight2);
		HornRight2.cubeList.add(new ModelBox(HornRight2, 40, 11, -0.7729F, -2.5922F, -1.0F, 2, 3, 2, 0.0F, false));

		HornRight3 = new RendererModel(this);
		HornRight3.setRotationPoint(-7.0F, -5.25F, -4.75F);
		setRotationAngle(HornRight3, 0.0F, 0.0F, -0.3491F);
		Head.addChild(HornRight3);
		HornRight3.cubeList.add(new ModelBox(HornRight3, 11, 0, -0.391F, -1.0859F, -0.5F, 1, 2, 1, 0.0F, false));

		EarLeft = new RendererModel(this);
		EarLeft.setRotationPoint(3.25F, -1.0F, -4.0F);
		setRotationAngle(EarLeft, 0.0F, -0.3491F, -0.5236F);
		Head.addChild(EarLeft);
		EarLeft.cubeList.add(new ModelBox(EarLeft, 54, 56, -0.161F, -0.5F, -1.0F, 1, 5, 2, 0.0F, false));

		EarRight = new RendererModel(this);
		EarRight.setRotationPoint(-3.25F, -1.0F, -4.0F);
		setRotationAngle(EarRight, 0.0F, 0.2618F, 0.5236F);
		Head.addChild(EarRight);
		EarRight.cubeList.add(new ModelBox(EarRight, 56, 11, -0.661F, -0.5F, -1.0F, 1, 5, 2, 0.0F, false));

		Mouth = new RendererModel(this);
		Mouth.setRotationPoint(0.0F, 2.5F, -7.0F);
		setRotationAngle(Mouth, 0.1745F, 0.0F, 0.0F);
		Head.addChild(Mouth);
		Mouth.cubeList.add(new ModelBox(Mouth, 22, 50, -1.911F, -1.0813F, -3.352F, 4, 3, 5, 0.0F, false));

		FrontLegRight = new RendererModel(this);
		FrontLegRight.setRotationPoint(-4.5F, 6.25F, -13.25F);
		MainBody.addChild(FrontLegRight);
		FrontLegRight.cubeList.add(new ModelBox(FrontLegRight, 38, 56, -0.911F, -1.5F, -1.0F, 2, 4, 2, 0.0F, false));

		FrontLegLeft = new RendererModel(this);
		FrontLegLeft.setRotationPoint(4.25F, 6.5F, -13.25F);
		MainBody.addChild(FrontLegLeft);
		FrontLegLeft.cubeList.add(new ModelBox(FrontLegLeft, 46, 56, -0.661F, -1.75F, -1.0F, 2, 4, 2, 0.0F, false));

		Hump = new RendererModel(this);
		Hump.setRotationPoint(0.0F, -8.25F, -9.75F);
		MainBody.addChild(Hump);
		Hump.cubeList.add(new ModelBox(Hump, 40, 0, -3.911F, -2.25F, -3.75F, 8, 3, 8, 0.0F, false));

		BackBody = new RendererModel(this);
		BackBody.setRotationPoint(0.0F, 0.5F, 0.25F);
		MainBody.addChild(BackBody);
		BackBody.cubeList.add(new ModelBox(BackBody, 0, 31, -5.411F, -5.0F, -2.5F, 11, 10, 9, 0.0F, false));

		BackLegRight = new RendererModel(this);
		BackLegRight.setRotationPoint(-4.0F, 5.0F, 3.75F);
		BackBody.addChild(BackLegRight);
		BackLegRight.cubeList.add(new ModelBox(BackLegRight, 40, 0, -0.911F, -0.75F, -1.0F, 2, 4, 2, 0.0F, false));

		BackLegLeft = new RendererModel(this);
		BackLegLeft.setRotationPoint(4.0F, 5.25F, 3.75F);
		BackBody.addChild(BackLegLeft);
		BackLegLeft.cubeList.add(new ModelBox(BackLegLeft, 0, 31, -0.911F, -1.0F, -1.0F, 2, 4, 2, 0.0F, false));

		Tail = new RendererModel(this);
		Tail.setRotationPoint(-0.75F, -0.75F, 6.0F);
		setRotationAngle(Tail, -1.1345F, 0.0F, 0.0F);
		BackBody.addChild(Tail);
		Tail.cubeList.add(new ModelBox(Tail, 0, 10, 0.589F, -0.3284F, -0.3268F, 1, 1, 5, 0.0F, false));
	}

	@Override
	public void render(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		GL11.glPushMatrix();
    	GL11.glScalef(2.0F, 2.0F, 2.0F);
    	GL11.glTranslatef(0.0F, -0.75F, 0.0F);
    	All.render(scale);
    	GL11.glPopMatrix();
    }
	
	public void setRotationAngle(RendererModel RendererModel, float x, float y, float z) {
		RendererModel.rotateAngleX = x;
		RendererModel.rotateAngleY = y;
		RendererModel.rotateAngleZ = z;
	}
}