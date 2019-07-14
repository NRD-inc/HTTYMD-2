package com.httymd;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Ref.MOD_ID, name = "HTTYMD/" + Ref.MOD_ID + "-" + Ref.VERSION)
@Config.LangKey("config." + Ref.MOD_ID + ".title")
public class HTTYMDConfig {
    private static final String PREFIX = "config." + Ref.MOD_ID;

    @Mod.EventBusSubscriber(modid = Ref.MOD_ID)
    private static class EventHandler {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent e) {
            if (e.getModID().equals(Ref.MOD_ID)) {
                ConfigManager.sync(Ref.MOD_ID, Config.Type.INSTANCE);
            }
        }
    }
}
