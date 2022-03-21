package me.baseband.client.utils;

import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AntiSpamUtils {
    static ArrayList<String> BlockWords = new ArrayList<String>();
    static boolean enabled=false;


    public static void toggle(){
        enabled=!enabled;
        ChatUtils.SendMessage("AntiSpam set to "+enabled);
    }

    @SubscribeEvent
    public void AntiSpam(ClientChatReceivedEvent event){
        if (enabled) {
            String OriginalMsg = event.getMessage().getUnformattedText();
            if (OriginalMsg.contains(Arrays.toString(BlockWords.toArray()))) {
                event.setCanceled(true);
            }
        }

    }

    @SubscribeEvent
    public void WatchYourLanguage(ClientChatEvent event){
        if (enabled) {
            String OriginalMsg = event.getMessage();
            if (OriginalMsg.contains(Arrays.toString(BlockWords.toArray()))) {
                event.setCanceled(true);
            }
        }
    }
    public static void addblockedwords(){
        BlockWords.add(JOptionPane.showInputDialog("Enter a word to be blocked. (Lowercase.)"));
    }

    public static void setdefaultblockedwords(){
        BlockWords.clear();
        BlockWords.add("fuck");
        BlockWords.add("shit");
        BlockWords.add("crap");
    }
}
