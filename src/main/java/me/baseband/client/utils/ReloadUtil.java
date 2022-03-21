package me.baseband.client.utils;

import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ReloadUtil {
    @SubscribeEvent
    public void reload(ClientChatEvent event){
        if(event.getMessage().contains("B!")){
            UnloadUtil.load();
        }
    }
}
