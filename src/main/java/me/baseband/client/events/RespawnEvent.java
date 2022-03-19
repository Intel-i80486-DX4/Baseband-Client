package me.baseband.client.events;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class RespawnEvent {
    @SubscribeEvent
    public void onUpdate(PlayerEvent.PlayerRespawnEvent event){
            System.out.println("Test");
        }
    }

