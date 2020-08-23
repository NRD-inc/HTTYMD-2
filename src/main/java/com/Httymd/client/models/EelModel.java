package com.Httymd.client.models;
//Made with Blockbench
//Paste this code into your mod.

import com.Httymd.entities.EntityEel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;

public class EelModel<T extends EntityEel> extends EntityModel<T> {
	private final RendererModel All;
	private final RendererModel Head;
	private final RendererModel Body1;
	private final RendererModel HeadFin;
	private final RendererModel RightFin;
	private final RendererModel LeftFin;
	private final RendererModel Body2;
	private final RendererModel BodyFin8;
	private final RendererModel BodyFin7;
	private final RendererModel Body3;
	private final RendererModel BodyFin6;
	private final RendererModel BodyFin4;
	private final RendererModel BodyFin5;
	private final RendererModel Body4;
	private final RendererModel BodyFin2;
	private final RendererModel BodyFin3;
	private final RendererModel Body5;
	private final RendererModel BodyFin1;
	private final RendererModel Tail;
	private final RendererModel TailFin1;
	private final RendererModel TailFin2;

	public EelModel() {
		textureWidth = 32;
		textureHeight = 32;

		All = new RendererModel(this);
		All.setRotationPoint(0.0F, 17.75F, -1.5F);

		Head = new RendererModel(this);
		Head.setRotationPoint(-0.25F, 0.0F, -10.75F);
		All.addChild(Head);
		Head.cubeList.add(new ModelBox(Head, 4, 2, -0.5F, -1.0F, -1.75F, 1, 2, 2, 0.0F, false));

		Body1 = new RendererModel(this);
		Body1.setRotationPoint(0.0833F, -0.1667F, 0.8333F);
		Head.addChild(Body1);
		Body1.cubeList.add(new ModelBox(Body1, 4, 6, -0.5833F, -0.8333F, -0.5833F, 1, 2, 2, 0.0F, false));
		Body1.cubeList.add(new ModelBox(Body1, 4, 6, -0.5833F, -0.8333F, 1.4167F, 1, 2, 2, 0.0F, false));

		HeadFin = new RendererModel(this);
		HeadFin.setRotationPoint(-0.0833F, -0.8333F, 1.9167F);
		Body1.addChild(HeadFin);
		HeadFin.cubeList.add(new ModelBox(HeadFin, 10, 10, 0.0F, -0.25F, -1.75F, 0, 1, 2, 0.0F, false));

		RightFin = new RendererModel(this);
		RightFin.setRotationPoint(-0.0833F, 0.4167F, 0.9167F);
		setRotationAngle(RightFin, 0.0F, -0.3491F, 0.0F);
		Body1.addChild(RightFin);
		RightFin.cubeList.add(new ModelBox(RightFin, 0, 0, -0.1796F, -0.5F, 0.3994F, 0, 1, 2, 0.0F, true));

		LeftFin = new RendererModel(this);
		LeftFin.setRotationPoint(0.1667F, 0.4167F, 1.1667F);
		setRotationAngle(LeftFin, 0.0F, 0.3491F, 0.0F);
		Body1.addChild(LeftFin);
		LeftFin.cubeList.add(new ModelBox(LeftFin, 0, 0, 0.0F, -0.5F, 0.0F, 0, 1, 2, 0.0F, false));

		Body2 = new RendererModel(this);
		Body2.setRotationPoint(-0.25F, 0.75F, 3.4167F);
		Body1.addChild(Body2);
		Body2.cubeList.add(new ModelBox(Body2, 0, 8, -0.3333F, -1.5833F, 2.0F, 1, 2, 2, 0.0F, false));
		Body2.cubeList.add(new ModelBox(Body2, 4, 6, -0.3333F, -1.5833F, 0.0F, 1, 2, 2, 0.0F, false));

		BodyFin8 = new RendererModel(this);
		BodyFin8.setRotationPoint(0.1667F, -1.5833F, 0.75F);
		Body2.addChild(BodyFin8);
		BodyFin8.cubeList.add(new ModelBox(BodyFin8, 0, 0, 0.0F, -0.5F, -2.0F, 0, 1, 2, 0.0F, false));

		BodyFin7 = new RendererModel(this);
		BodyFin7.setRotationPoint(0.1667F, -1.5833F, 2.5F);
		Body2.addChild(BodyFin7);
		BodyFin7.cubeList.add(new ModelBox(BodyFin7, 0, 0, 0.0F, -0.5F, -1.75F, 0, 1, 2, 0.0F, false));

		Body3 = new RendererModel(this);
		Body3.setRotationPoint(0.1667F, -0.3333F, 4.5F);
		Body2.addChild(Body3);
		Body3.cubeList.add(new ModelBox(Body3, 8, 8, -0.5F, -1.25F, -0.5F, 1, 2, 2, 0.0F, false));
		Body3.cubeList.add(new ModelBox(Body3, 12, 2, -0.5F, -1.25F, 1.5F, 1, 2, 2, 0.0F, false));

		BodyFin6 = new RendererModel(this);
		BodyFin6.setRotationPoint(0.0F, -1.25F, 0.0F);
		Body3.addChild(BodyFin6);
		BodyFin6.cubeList.add(new ModelBox(BodyFin6, 0, 0, 0.0F, -0.5F, -1.75F, 0, 1, 2, 0.0F, false));

		BodyFin4 = new RendererModel(this);
		BodyFin4.setRotationPoint(0.0F, -1.25F, 4.0F);
		Body3.addChild(BodyFin4);
		BodyFin4.cubeList.add(new ModelBox(BodyFin4, 0, 0, 0.0F, -0.5F, -1.75F, 0, 1, 2, 0.0F, false));

		BodyFin5 = new RendererModel(this);
		BodyFin5.setRotationPoint(0.0F, -1.25F, 2.0F);
		Body3.addChild(BodyFin5);
		BodyFin5.cubeList.add(new ModelBox(BodyFin5, 0, 0, 0.0F, -0.5F, -1.75F, 0, 1, 2, 0.0F, false));

		Body4 = new RendererModel(this);
		Body4.setRotationPoint(0.0833F, -0.1667F, 4.3333F);
		Body3.addChild(Body4);
		Body4.cubeList.add(new ModelBox(Body4, 4, 10, -0.5833F, -1.0833F, -0.8333F, 1, 2, 2, 0.0F, false));
		Body4.cubeList.add(new ModelBox(Body4, 8, 4, -0.5833F, -1.0833F, 1.1667F, 1, 2, 2, 0.0F, false));

		BodyFin2 = new RendererModel(this);
		BodyFin2.setRotationPoint(-0.0833F, -1.3333F, 3.6667F);
		Body4.addChild(BodyFin2);
		BodyFin2.cubeList.add(new ModelBox(BodyFin2, 0, 0, 0.0F, -0.25F, -1.75F, 0, 1, 2, 0.0F, false));

		BodyFin3 = new RendererModel(this);
		BodyFin3.setRotationPoint(-0.0833F, -1.3333F, 1.6667F);
		Body4.addChild(BodyFin3);
		BodyFin3.cubeList.add(new ModelBox(BodyFin3, 0, 0, 0.0F, -0.25F, -1.75F, 0, 1, 2, 0.0F, false));

		Body5 = new RendererModel(this);
		Body5.setRotationPoint(-0.0833F, 0.1667F, 3.6667F);
		Body4.addChild(Body5);
		Body5.cubeList.add(new ModelBox(Body5, 8, 0, -0.5F, -1.25F, -0.5F, 1, 2, 2, 0.0F, false));
		Body5.cubeList.add(new ModelBox(Body5, 0, 4, -0.5F, -1.25F, 1.5F, 1, 2, 2, 0.0F, false));

		BodyFin1 = new RendererModel(this);
		BodyFin1.setRotationPoint(0.0F, -1.3333F, 0.3333F);
		Body5.addChild(BodyFin1);
		BodyFin1.cubeList.add(new ModelBox(BodyFin1, 0, 0, 0.0F, -0.4167F, -0.0833F, 0, 1, 2, 0.0F, false));

		Tail = new RendererModel(this);
		Tail.setRotationPoint(0.0F, -0.25F, 3.75F);
		Body5.addChild(Tail);
		Tail.cubeList.add(new ModelBox(Tail, 0, 0, -0.5F, -0.5F, -0.25F, 1, 1, 2, 0.0F, false));

		TailFin1 = new RendererModel(this);
		TailFin1.setRotationPoint(-0.1167F, 0.0499F, 1.3147F);
		setRotationAngle(TailFin1, 0.6981F, 0.0F, 0.0F);
		Tail.addChild(TailFin1);
		TailFin1.cubeList.add(new ModelBox(TailFin1, 0, 0, 0.0F, -0.4094F, -0.1249F, 0, 1, 1, 0.0F, false));

		TailFin2 = new RendererModel(this);
		TailFin2.setRotationPoint(-0.25F, -0.5F, 0.0F);
		Tail.addChild(TailFin2);
		TailFin2.cubeList.add(new ModelBox(TailFin2, 0, 10, 0.25F, -0.5F, -0.5F, 0, 1, 2, 0.0F, false));
	}

	@Override
	public void render(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		//GL11.glPushMatrix();
    	//GL11.glScalef(2.0F, 2.0F, 2.0F);
    	//GL11.glTranslatef(0.0F, -0.75F, 0.0F);
    	All.render(scale);
    	//GL11.glPopMatrix();
    }
	
	public void setRotationAngle(RendererModel RendererModel, float x, float y, float z) {
		RendererModel.rotateAngleX = x;
		RendererModel.rotateAngleY = y;
		RendererModel.rotateAngleZ = z;
	}
}