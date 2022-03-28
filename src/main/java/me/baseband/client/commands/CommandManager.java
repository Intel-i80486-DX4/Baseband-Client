package me.baseband.client.commands;

import me.baseband.client.modules.ModuleManager;
import me.baseband.client.utils.Misc;
import me.baseband.client.utils.ThreadManager;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.swing.*;

public class CommandManager {

    public String command = null;

    @SubscribeEvent
    public void onCommand(ClientChatEvent event){
        if (event.getMessage().contains(Misc.getCommandSuffix())) {
            ThreadManager.run(() -> {
                command = JOptionPane.showInputDialog("Enter a command.");
                /*
                How to add a command.
                if(command.equalsIgnoreCase("CommandHere"){
                DOTHIS.Stuff()
                }
                */
                if (command.equalsIgnoreCase("togglemod")){
                    String moduletoenable = JOptionPane.showInputDialog("Enter module to toggle.");
                    if (moduletoenable.equalsIgnoreCase("watermark")){
                        ModuleManager.Sustenance(1, true, "Watermark");}
                }

                if (command.equalsIgnoreCase("listmodules")){
                    ModuleManager.listmodules();
                }
            });
            event.setCanceled(true);
        }
    }
}


