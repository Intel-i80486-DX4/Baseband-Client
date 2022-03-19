package me.baseband.client.utils;

import net.minecraft.util.text.TextComponentString;

import static me.baseband.client.Main.mc;

public class ChatUtils {
    public static void SendMessage(String input){
        mc.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new TextComponentString("§3~B:§r "+input));
    }
}
