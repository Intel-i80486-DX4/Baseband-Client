package me.baseband.client.utils;

import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ReloadUtil {
    @SubscribeEvent
    public void reload(ClientChatEvent event){
        boolean reload2 = event.getMessage().startsWith("B?load");
        if(reload2){
            UnloadUtil.load();
        }
    }
}
