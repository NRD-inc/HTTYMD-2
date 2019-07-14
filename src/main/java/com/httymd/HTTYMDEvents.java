package com.httymd;

import com.httymd.item.IExtendedReach;
import com.httymd.message.MessageExtendedReachAttack;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class HTTYMDEvents {
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void customReachEvent(MouseEvent event) {
        if (event.getButton() == 0 && event.isButtonstate()) {
            Minecraft MC = Minecraft.getMinecraft();
            EntityPlayer PLAYER = MC.player;
            if (PLAYER != null) {
                ItemStack STACK = PLAYER.inventory.getCurrentItem();
                IExtendedReach I_REACH;
                if (STACK != null) {
                    if (STACK.getItem() instanceof IExtendedReach)
                        I_REACH = (IExtendedReach) STACK.getItem();
                    else
                        I_REACH = null;

                    if (I_REACH != null) {
                        float REACH = I_REACH.getReach();
                        RayTraceResult MOV = getMouseOverExtended(REACH);
                        if (MOV != null) {
                            if (MOV.entityHit != null && MOV.entityHit.hurtResistantTime == 0)
                                if (MOV.entityHit != PLAYER)
                                    HTTYMD.NETWORK.sendToServer(new MessageExtendedReachAttack(MOV.entityHit.getEntityId()));
                        }
                    }
                }
            }
        }
    }

    public static RayTraceResult getMouseOverExtended(float dist) {
        Minecraft mc = FMLClientHandler.instance().getClient();
        Entity theRenderViewEntity = mc.getRenderViewEntity();
        AxisAlignedBB theViewBoundingBox = new AxisAlignedBB(
                theRenderViewEntity.posX-0.5D, theRenderViewEntity.posY-0.0D, theRenderViewEntity.posZ-0.5D,
                theRenderViewEntity.posX+0.5D, theRenderViewEntity.posY+1.5D, theRenderViewEntity.posZ+0.5D
        );
        RayTraceResult returnMOP = null;
        if (mc.world != null) {
            double var2 = dist;
            returnMOP = theRenderViewEntity.rayTrace(var2, 0);
            double calcdist = var2;
            Vec3d pos = theRenderViewEntity.getPositionEyes(0);
            var2 = calcdist;
            if (returnMOP != null)
                calcdist = returnMOP.hitVec.distanceTo(pos);

            Vec3d lookvec = theRenderViewEntity.getLook(0);
            Vec3d var8 = pos.add(lookvec.x * var2, lookvec.y * var2, lookvec.z * var2);
            Entity pointedEntity = null;
            float var9 = 1.0F;
            List<Entity> list = mc.world.getEntitiesWithinAABBExcludingEntity(theRenderViewEntity, theViewBoundingBox
                            .expand(lookvec.x * var2, lookvec.y * var2, lookvec.z * var2).expand(var9, var9, var9));
            double d = calcdist;

            for (Entity entity : list) {
                if (entity.canBeCollidedWith()) {
                    float bordersize = entity.getCollisionBorderSize();
                    AxisAlignedBB aabb = new AxisAlignedBB(
                            entity.posX-entity.width/2, entity.posY, entity.posZ-entity.width/2,
                            entity.posX+entity.width/2, entity.posY+entity.height, entity.posZ+entity.width/2);
                    aabb.expand(bordersize, bordersize, bordersize);
                    RayTraceResult mop0 = aabb.calculateIntercept(pos, var8);

                    if (aabb.contains(pos)) {
                        if (0.0D < d || d == 0.0D) {
                            pointedEntity = entity;
                            d = 0.0D;
                        }
                    } else if (mop0 != null) {
                        double d1 = pos.distanceTo(mop0.hitVec);

                        if (d1 < d || d == 0.0D) {
                            pointedEntity = entity;
                            d = d1;
                        }
                    }
                }
            }

            if (pointedEntity != null && (d < calcdist || returnMOP == null))
                returnMOP = new RayTraceResult(pointedEntity);

        }
        return returnMOP;
    }
}
