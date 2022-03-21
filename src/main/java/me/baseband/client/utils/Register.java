package me.baseband.client.utils;

import me.baseband.client.utils.pasted.AuraUtils;
import net.minecraftforge.common.MinecraftForge;



public class Register {
    static HudUtils hud = new HudUtils();
    static SuffixUtil suffix = new SuffixUtil();
    static ChatUtils chatcrypt2 = new ChatUtils();
    static AuraUtils killaura = new AuraUtils();
    static AntiSpamUtils antispam = new AntiSpamUtils();
    public static void RegisterAll(){
        MinecraftForge.EVENT_BUS.register(suffix);
        MinecraftForge.EVENT_BUS.register(chatcrypt2);
        //MinecraftForge.EVENT_BUS.register(killaura);
        MinecraftForge.EVENT_BUS.register(hud);
        MinecraftForge.EVENT_BUS.register(antispam);
    }
    public static void Unload(){
        MinecraftForge.EVENT_BUS.unregister(suffix);
        MinecraftForge.EVENT_BUS.unregister(chatcrypt2);
        //MinecraftForge.EVENT_BUS.unregister(killaura);
        MinecraftForge.EVENT_BUS.unregister(hud);
        MinecraftForge.EVENT_BUS.unregister(antispam);
    }
}
