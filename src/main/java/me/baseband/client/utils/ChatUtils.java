package me.baseband.client.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Base64;

import static me.baseband.client.Main.mc;

public class ChatUtils {
    public static void SendMessage(String input){
        mc.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new TextComponentString("§3~B:§r "+input));
    }
    static boolean nonormalchat = false;
    static boolean enabled = false;


    public static void ToggleNormalChat(){
        nonormalchat=!nonormalchat;
        SendMessage("Normal Chat set to "+nonormalchat);
    }

    public static void toggle(){
        enabled=!enabled;
        ChatUtils.SendMessage("ChatCrypt set to "+enabled);
    }

    //We're done here.
    //You're not allowed to copy this code.

    @SubscribeEvent
    public void ChatCrypt(ClientChatReceivedEvent event){
        if (enabled) {
            String originalmessage = event.getMessage().toString();
            if (originalmessage.contains("?%BBCRYPT")) {
                originalmessage = originalmessage.replace("?%BBCRYPT", "");
                String msg = new StringBuilder(originalmessage).reverse().toString();

                String decrypt = Base64.getDecoder().decode(msg).toString();
                ChatUtils.SendMessage(decrypt);
                originalmessage = null;
                msg = null;
                decrypt = null;
                event.setCanceled(true);
            }
            if (nonormalchat) {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public void onCryptChatEvent(ClientChatEvent event){
        if (enabled) {
            String chatcrypt = Minecraft.getMinecraft().getSession().getUsername() + " " + event.getMessage();
            String b64encoded = Base64.getEncoder().encodeToString(chatcrypt.getBytes());
            String msg2 = new StringBuilder(b64encoded).reverse().toString();
            event.setMessage("?%BBCRYPT" + msg2);
            msg2 = null;
            chatcrypt = null;
            b64encoded = null;
        }
    }
}
