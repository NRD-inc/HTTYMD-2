package mug;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Mug - Undefined
 * Created using Tabula 5.1.0
 */
public class Mug extends ModelBase {
    public ModelRenderer Base;
    public ModelRenderer 8x6Rightside;
    public ModelRenderer 8x6Leftside;
    public ModelRenderer 8x4Front;
    public ModelRenderer 8x4Back;
    public ModelRenderer Handle1;
    public ModelRenderer Handle2;
    public ModelRenderer Handle3;

    public Mug() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.8x4Back = new ModelRenderer(this, 11, 15);
        this.8x4Back.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.8x4Back.addBox(-1.0F, 13.0F, 2.0F, 4, 10, 1, 0.0F);
        this.Handle1 = new ModelRenderer(this, 16, 9);
        this.Handle1.setRotationPoint(0.0F, -1.0F, -0.5F);
        this.Handle1.addBox(4.0F, 16.0F, 0.0F, 3, 1, 1, 0.0F);
        this.Base = new ModelRenderer(this, 0, 0);
        this.Base.setRotationPoint(3.0F, 2.0F, -3.0F);
        this.Base.addBox(-5.0F, 20.0F, 0.0F, 6, 1, 6, 0.0F);
        this.Handle3 = new ModelRenderer(this, 6, 9);
        this.Handle3.setRotationPoint(0.0F, -1.0F, -0.5F);
        this.Handle3.addBox(4.0F, 21.0F, 0.0F, 3, 1, 1, 0.0F);
        this.Handle2 = new ModelRenderer(this, 0, 8);
        this.Handle2.setRotationPoint(0.0F, -1.0F, -0.5F);
        this.Handle2.addBox(6.0F, 17.0F, 0.0F, 1, 4, 1, 0.0F);
        this.8x6Leftside = new ModelRenderer(this, 41, 0);
        this.8x6Leftside.setRotationPoint(-2.0F, 15.0F, -3.0F);
        this.8x6Leftside.addBox(0.0F, -2.0F, 0.0F, 1, 10, 6, 0.0F);
        this.8x4Front = new ModelRenderer(this, 0, 15);
        this.8x4Front.setRotationPoint(0.0F, 0.0F, -5.0F);
        this.8x4Front.addBox(-1.0F, 13.0F, 2.0F, 4, 10, 1, 0.0F);
        this.8x6Rightside = new ModelRenderer(this, 25, 0);
        this.8x6Rightside.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.8x6Rightside.addBox(3.0F, 13.0F, -3.0F, 1, 10, 6, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.8x4Back.render(f5);
        this.Handle1.render(f5);
        this.Base.render(f5);
        this.Handle3.render(f5);
        this.Handle2.render(f5);
        this.8x6Leftside.render(f5);
        this.8x4Front.render(f5);
        this.8x6Rightside.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
