package me.baseband.client.events;

import me.baseband.client.utils.ChatUtils;
import me.baseband.client.utils.ThreadManager;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.swing.*;

import static me.baseband.client.Main.mc;

public class CommandEvent {
    public String Command = null;
    public String CommandPrefix = "B?";
    @SubscribeEvent
    public void onCommand(ClientChatEvent event){
    if (event.getMessage().contains(CommandPrefix)){
        ThreadManager.run(() -> {
                    Command = JOptionPane.showInputDialog("Enter a command.");
                    if (Command.equals("exit")) {
                        mc.getMinecraft().shutdown();
                    } else {
                        if (Command.equals("help")) {
                            ChatUtils.SendMessage("-Commands- \nexit: Exits Minecraft");
                        } else {
                            ChatUtils.SendMessage("Command Not Found.");
                        }
                    }
                    Command = null;
                });
            event.setCanceled(true);
    }else {Command=null;}
    }
}
