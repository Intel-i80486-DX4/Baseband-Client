package me.baseband.client.events;

import me.baseband.client.utils.*;
import me.baseband.client.utils.pasted.ThreadManager;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.swing.*;

import static me.baseband.client.Main.mc;

public class CommandEvent {
    public String command = null;
    public String commandprefix = "B?";
    public static String chatsuffix = " »\u0299\u1d00\ua731\u1d07\u0299\u1d00\u0274\u1d05«";



    public static String getSuffix(){
        return chatsuffix;
    }


    @SubscribeEvent
    public void onCommand(ClientChatEvent event){
    if (event.getMessage().contains(commandprefix)){
        ThreadManager.run(() ->{
            command = JOptionPane.showInputDialog("Enter a command.");
                    if (command.equals("exit")) {
                        mc.getMinecraft().shutdown();
                        return;
                    }else {
                    /*
                    if (command.equals("toggleaura")){
                        AuraUtils.toggle();
                    }


                    if (command.equals("setaura")){
                        AuraUtils.config();
                    }


                    if (Command.equals("toggleautototem")){
                        autototenabled=!autototenabled;
                        if (autototenabled){
                            MinecraftForge.EVENT_BUS.register(Autototem);
                            ChatUtils.SendMessage("AutoTotem Enabled.");
                        }
                        if (!autototenabled){
                            MinecraftForge.EVENT_BUS.unregister(Autototem);
                            ChatUtils.SendMessage("AutoTotem Disabled.");
                        }

                    }
                    if (Command.equals("autototemsoft")){
                        AutoTotemUtil.soft();
                        ChatUtils.SendMessage("Soft Mode set to "+AutoTotemUtil.soft2());
                    }
                    */
                        if (command.equals("togglesuffix")) {
                            SuffixUtil.toggle();
                            return;
                        }
                        if (command.equals("setsuffix")) {
                            chatsuffix = JOptionPane.showInputDialog("Enter new ChatSuffix");
                            return;
                        }
                        if (command.equals("setdefault")) {
                            chatsuffix = " »\u0299\u1d00\ua731\u1d07\u0299\u1d00\u0274\u1d05«";
                            commandprefix = "B?";
                            AntiSpamUtils.setdefaultblockedwords();
                            ChatUtils.SendMessage("Set all Settings to Default!");
                            return;
                        }

                        if (command.equals("help")) {
                            String help = "Commands \n" +
                                    " exit: Exits Minecraft.\n" +
                                    " togglehud: Toggles Hud.\n" +
                                    " togglesuffix: Toggles the ChatSuffix.\n" +
                                    " togglechatcrypt: Toggles Chat Encryption.\n" +
                                    " togglechat: Toggles if normal chat is enabled with the above Encryption.\n" +
                                    " toggleantispam: Toggles AntiSpam\n" +
                                    " setdefault: Resets the client's options.\n" +
                                    " setantispam: Opens a window to add a blocked word.\n" +
                                    " setprefix: Changes the Prefix. (Default is B?)\n" +
                                    " setsuffix: Sets a new ChatSuffix.\n" +
                                    " unload: Unloads the client.\n" +
                                    " Note, All commands above are Caps-Sensitive.";
                            ChatUtils.SendMessage(help);
                            System.out.println(help);
                            return;
                        }
                        if (command.equals("togglechatcrypt")) {
                            ChatUtils.toggle();
                            return;
                        }
                        if (command.equals("togglechat")) {
                            ChatUtils.ToggleNormalChat();
                            return;
                        }
                        if (command.equals("unload")) {
                            UnloadUtil.unload();
                            ChatUtils.SendMessage("Unloaded.");
                            return;
                        }
                        if (command.equals("setprefix")) {
                            ChatUtils.SendMessage("Changing Prefix...");
                            commandprefix = JOptionPane.showInputDialog("Enter a new prefix.");
                            ChatUtils.SendMessage("Prefix set to "+commandprefix);
                            return;
                        }
                        if (command.equals("togglehud")) {
                            HudUtils.toggle();
                            return;
                        }
                        if (command.equals("toggleantispam")) {
                            AntiSpamUtils.toggle();
                            return;
                        }
                        if (command.equals("setantispam")) {
                            AntiSpamUtils.addblockedwords();
                            return;
                        }
                        if (command.isEmpty()){
                            ChatUtils.SendMessage("Command Input Empty.");
                            return;
                        }
                    }
                    ChatUtils.SendMessage("Command Not Found.");
        });
        command = null;
        event.setCanceled(true);
    }else {
        command =null;}
    }
}
