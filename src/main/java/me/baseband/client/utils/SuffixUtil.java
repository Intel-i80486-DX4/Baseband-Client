package me.baseband.client.utils;

import me.baseband.client.events.CommandEvent;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SuffixUtil {
    String OriginalMsg = null;
    boolean blockoncommands = false;

    public void block(){blockoncommands=!blockoncommands;}

    @SubscribeEvent
    public void onCommand(ClientChatEvent event){
        if (blockoncommands){if ((event.getMessage().startsWith(".")||event.getMessage().startsWith(",")||event.getMessage().startsWith("B?")||event.getMessage().startsWith("*"))||event.getMessage().startsWith("/")){return;}}
        OriginalMsg =event.getMessage();
        event.setMessage(OriginalMsg+CommandEvent.getSuffix());
    }
}
