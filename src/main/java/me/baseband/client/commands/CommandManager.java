package me.baseband.client.commands;

import me.baseband.client.modules.ModuleManager;
import me.baseband.client.utils.ChatUtils;
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
                if (command.equalsIgnoreCase("enablemod")){
                    String moduletoenable = JOptionPane.showInputDialog("Enter module to enable.");
                    if (moduletoenable.equalsIgnoreCase("watermark")){
                        ModuleManager.Sustenance(ModuleManager.Get("Watermark"), true, "Watermark");}
                }

                if (command.equalsIgnoreCase("disablemod")){
                    String moduletoenable = JOptionPane.showInputDialog("Enter module to disable.");
                    if (moduletoenable.equalsIgnoreCase("watermark")){
                        ModuleManager.Sustenance(ModuleManager.Get("Watermark"), false, "Watermark");}
                }


                if (command.equalsIgnoreCase("listmodules")){
                    ModuleManager.listmodules();
                }
                if (command.equalsIgnoreCase("help")){
                    ChatUtils.SendMessage("Commands:"+
                            "\n"+
                            "EnableMod: Enables a Module\n" +
                            "DisableMod: Disables a Module\n" +
                            "ListModules: List All Modules\n" +
                            "Help: Shows this messages.\n");
                }
            });
            event.setCanceled(true);
        }
    }
}


