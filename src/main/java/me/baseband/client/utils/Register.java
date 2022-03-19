package me.baseband.client.utils;

import me.baseband.client.events.CommandEvent;
import net.minecraftforge.common.MinecraftForge;

public class Register {
    public static void RegisterAll(){
        MinecraftForge.EVENT_BUS.register(new CommandEvent());
    }
}
