package me.baseband.client.events;

import me.baseband.client.utils.ChatUtils;
import me.baseband.client.utils.HudUtils;
import me.baseband.client.utils.ThreadManager;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.swing.*;

import static me.baseband.client.Main.mc;

public class CommandEvent {
    public String Command = null;
    public String CommandPrefix = "B?";
    HudUtils hud = new HudUtils();
    boolean hudenabled = false;
    @SubscribeEvent
    public void onCommand(ClientChatEvent event){
    if (event.getMessage().contains(CommandPrefix)){
        ThreadManager.run(() ->{
            Command = JOptionPane.showInputDialog("Enter a command.");
            if (Command.equals("exit")) {
                mc.getMinecraft().shutdown();
            } else {
                if (Command.equals("help")) {
                    ChatUtils.SendMessage("Commands \nexit: Exits Minecraft\n togglehud: Toggles Hud\n prefix: Changes the Prefix. (Default is B?)");
                } if (Command.equals("prefix")) {
                    CommandPrefix = JOptionPane.showInputDialog("Enter a new prefix.");
                }if (Command.equals("togglehud")){
                    hudenabled = !hudenabled;
                    if (hudenabled){
                        MinecraftForge.EVENT_BUS.register(hud);
                    }
                    if (!hudenabled){
                        MinecraftForge.EVENT_BUS.unregister(hud);
                    }
                }
            }
        });
        Command = null;
        event.setCanceled(true);
    }else {Command=null;}
    }
}
