package me.baseband.client.utils;

import me.baseband.client.events.CommandEvent;
import net.minecraftforge.common.MinecraftForge;

public class UnloadUtil {
    static CommandEvent command = new CommandEvent();
    public static void load(){
        MinecraftForge.EVENT_BUS.register(command);
    }
    public static void unload(){
        MinecraftForge.EVENT_BUS.unregister(command);
        MinecraftForge.EVENT_BUS.register(new ReloadUtil());
    }
}