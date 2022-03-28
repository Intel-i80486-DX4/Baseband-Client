package me.baseband.client.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;

public class ChatUtils {
    public static void SendMessage(String input){
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new TextComponentString("§3~B:§r "+input));
    }
}
