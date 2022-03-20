package me.baseband.client.events;

import me.baseband.client.utils.ChatUtils;
import me.baseband.client.utils.HudUtils;
import me.baseband.client.utils.SuffixUtil;
import me.baseband.client.utils.UnloadUtil;
import me.baseband.client.utils.pasted.AuraUtils;
import me.baseband.client.utils.pasted.AutoTotemUtil;
import me.baseband.client.utils.pasted.ThreadManager;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.swing.*;

import static me.baseband.client.Main.mc;

public class CommandEvent {
    public String Command = null;
    public String CommandPrefix = "B?";
    public static String ChatSuffix = " »\u0299\u1d00\ua731\u1d07\u0299\u1d00\u0274\u1d05«";
    HudUtils hud = new HudUtils();
    SuffixUtil suffix = new SuffixUtil();
    AutoTotemUtil Autototem = new AutoTotemUtil();
    ChatUtils chatcrypt2 = new ChatUtils();
    AuraUtils killaura = new AuraUtils();
    boolean hudenabled = false;
    public boolean suffixenabled = false;
    public boolean autototenabled = false;
    public boolean aura = false;
    public boolean chatcrypt = false;


    public static String getSuffix(){
        return ChatSuffix;
    }


    @SubscribeEvent
    public void onCommand(ClientChatEvent event){
    if (event.getMessage().contains(CommandPrefix)){
        ThreadManager.run(() ->{
            Command = JOptionPane.showInputDialog("Enter a command.");
                    if (Command.equals("exit")) {
                        mc.getMinecraft().shutdown();
                    }
                    if (Command.equals("toggleaura")){
                        aura=!aura;
                        if(aura){
                            MinecraftForge.EVENT_BUS.register(killaura);
                            ChatUtils.SendMessage("Killaura Enabled.");
                        }
                        if(!aura){
                            MinecraftForge.EVENT_BUS.unregister(killaura);
                            ChatUtils.SendMessage("Killaura Disabled.");
                        }
                    }
                    if (Command.equals("setaura")){
                        AuraUtils.config();
                    }

                    /*
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
                    if (Command.equals("togglesuffix")){
                        suffixenabled=!suffixenabled;
                        if (suffixenabled){
                            MinecraftForge.EVENT_BUS.register(suffix);
                            ChatUtils.SendMessage("ChatSuffix Enabled.");
                        }
                        if (!suffixenabled){
                            MinecraftForge.EVENT_BUS.unregister(suffix);
                            ChatUtils.SendMessage("ChatSuffix Disabled.");
                        }
                    }
                    if (Command.equals("setsuffix")){
                        ChatSuffix = JOptionPane.showInputDialog("Enter new ChatSuffix");
                    }
                    if (Command.equals("default")){
                        ChatSuffix=" »\u0299\u1d00\ua731\u1d07\u0299\u1d00\u0274\u1d05«";
                        CommandPrefix="B?";
                        ChatUtils.SendMessage("Set all Settings to Default!");
                    }

                    if (Command.equals("help")) {
                        String help = "Commands \n" +
                                " exit: Exits Minecraft.\n" +
                                " togglehud: Toggles Hud.\n" +
                                " togglesuffix: Toggles the ChatSuffix.\n" +
                                " toggleaura: Toggles Killaura\n" +
                                " togglechatcrypt: Toggles Chat Encryption.\n" +
                                " togglechat: Toggles if normal chat is enabled with the above Encryption." +
                                " setprefix: Changes the Prefix. (Default is B?)\n" +
                                " unload: Unloads the client.\n" +
                                " default: Resets the client's options.\n" +
                                " setsuffix: Sets a new ChatSuffix.\n" +
                                " setaura: Opens a Configuration Window for Killaura.\n" +
                                " Note, All commands above are Caps-Sensitive.";
                        ChatUtils.SendMessage(help);
                        System.out.println(help);
                    }
                    if (Command.equals("togglechatcrypt")){
                        chatcrypt = !chatcrypt;
                        if (chatcrypt){
                            MinecraftForge.EVENT_BUS.register(chatcrypt2);
                            ChatUtils.SendMessage("ChatCrypt Enabled.");
                        }
                        if (!chatcrypt){
                            MinecraftForge.EVENT_BUS.unregister(chatcrypt2);
                            ChatUtils.SendMessage("ChatCrypt Disabled.");
                        }
                    }
                    if (Command.equals("togglechat")){
                        ChatUtils.ToggleNormalChat();
                    }
                    if (Command.equals("unload")){
                        ChatUtils.SendMessage("Unloading...");
                        MinecraftForge.EVENT_BUS.unregister(hud);
                        MinecraftForge.EVENT_BUS.unregister(suffix);
                        UnloadUtil.unload();
                        ChatUtils.SendMessage("Unloaded.");
                    }
                    if (Command.equals("setprefix")) {
                        ChatUtils.SendMessage("Changing Prefix...");
                        CommandPrefix = JOptionPane.showInputDialog("Enter a new prefix.");
                        ChatUtils.SendMessage("");
                    }
                    if (Command.equals("togglehud")){
                            hudenabled = !hudenabled;
                        if (hudenabled){
                            MinecraftForge.EVENT_BUS.register(hud);
                            ChatUtils.SendMessage("Hud Enabled.");
                        }
                        if (!hudenabled){
                            MinecraftForge.EVENT_BUS.unregister(hud);
                            ChatUtils.SendMessage("Hud Disabled.");
                        }
                    }
                    if (Command.isEmpty()){}

        });
        Command = null;
        event.setCanceled(true);
    }else {Command=null;}
    }
}
