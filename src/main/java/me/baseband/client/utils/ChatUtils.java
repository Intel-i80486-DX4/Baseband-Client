package me.baseband.client.utils;

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


    public static void ToggleNormalChat(){
        nonormalchat=!nonormalchat;
        SendMessage("Normal Chat set to "+nonormalchat);
    }
    //We're done here.
    //You're not allowed to copy this code.

    @SubscribeEvent
    public void ChatCrypt(ClientChatReceivedEvent event){
        String originalmessage = event.getMessage().toString();
        if (originalmessage.startsWith("?%B")){
            originalmessage = originalmessage.replace("?%B", "");
            String msg = new StringBuilder(originalmessage).reverse().toString();

            String Decrypt = Base64.getDecoder().decode(msg).toString();
            ChatUtils.SendMessage(""+Decrypt);
            originalmessage = null;
            msg = null;
            Decrypt = null;
         event.setCanceled(true);
        }
        if(nonormalchat){
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onCryptChatEvent(ClientChatEvent event){
        String ChatCrypt = event.getMessage();
        String b64encoded = Base64.getEncoder().encodeToString(ChatCrypt.getBytes());
        String msg2 = new StringBuilder(b64encoded).reverse().toString();
        event.setMessage("?%B"+ msg2);
        msg2 = null;
        ChatCrypt = null;
        b64encoded = null;
    }
}
