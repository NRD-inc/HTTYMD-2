package com.httymd.message;

import com.httymd.item.IExtendedReach;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageExtendedReachAttack implements IMessage {
    private int ENTITY_ID;

    public MessageExtendedReachAttack() {}

    public MessageExtendedReachAttack(int parEntityId) {
        ENTITY_ID = parEntityId;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        ENTITY_ID = ByteBufUtils.readVarInt(buf, 4);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeVarInt(buf, ENTITY_ID, 4);
    }

    public static class Handler implements IMessageHandler<MessageExtendedReachAttack, IMessage> {
        @Override
        public IMessage onMessage(MessageExtendedReachAttack message, MessageContext ctx) {
            final EntityPlayerMP PLAYER = ctx.getServerHandler().player;
            PLAYER.getServer().addScheduledTask(new Runnable() {
                        @Override
                        public void run() {
                            Entity ENTITY = PLAYER.world.getEntityByID(message.ENTITY_ID);

                            if (PLAYER.inventory.getCurrentItem() == null || PLAYER.inventory.getCurrentItem().isEmpty())
                                return;
                            if (PLAYER.inventory.getCurrentItem().getItem() instanceof IExtendedReach) {
                                IExtendedReach WEAPON = (IExtendedReach) PLAYER.inventory.getCurrentItem().getItem();
                                double distanceSq = PLAYER.getDistanceSq(ENTITY);
                                double reachSq = WEAPON.getReach() * WEAPON.getReach();
                                if (reachSq >= distanceSq)
                                    PLAYER.attackTargetEntityWithCurrentItem(ENTITY);
                            }
                            return;
                        }
                    });
            return null;
        }
    }
}
