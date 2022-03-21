package me.baseband.client.events;

import me.baseband.client.utils.ChatUtils;
import me.baseband.client.utils.HudUtils;
import me.baseband.client.utils.SuffixUtil;
import me.baseband.client.utils.UnloadUtil;
import me.baseband.client.utils.pasted.AuraUtils;
import me.baseband.client.utils.pasted.AutoTotemUtil;
import me.baseband.client.utils.pasted.ThreadManager;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.swing.*;

import static me.baseband.client.Main.mc;

public class CommandEvent {
    public String command = null;
    public String commandprefix = "B?";
    public static String chatsuffix = " »\u0299\u1d00\ua731\u1d07\u0299\u1d00\u0274\u1d05«";
    HudUtils hud = new HudUtils();
    SuffixUtil suffix = new SuffixUtil();
    AutoTotemUtil autototem = new AutoTotemUtil();
    ChatUtils chatcrypt2 = new ChatUtils();
    AuraUtils killaura = new AuraUtils();
    boolean hudenabled = false;
    public boolean suffixenabled = false;
    public boolean autototenabled = false;
    public boolean aura = false;
    public boolean chatcrypt = false;


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
                    }
                    if (command.equals("toggleaura")){
                        AuraUtils.toggle();
                    }
                    if (command.equals("setaura")){
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
                    if (command.equals("togglesuffix")){
                        SuffixUtil.toggle();
                    }
                    if (command.equals("setsuffix")){
                        chatsuffix = JOptionPane.showInputDialog("Enter new ChatSuffix");
                    }
                    if (command.equals("default")){
                        chatsuffix =" »\u0299\u1d00\ua731\u1d07\u0299\u1d00\u0274\u1d05«";
                        commandprefix ="B?";
                        ChatUtils.SendMessage("Set all Settings to Default!");
                    }

                    if (command.equals("help")) {
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
                    if (command.equals("togglechatcrypt")){
                        ChatUtils.toggle();
                    }
                    if (command.equals("togglechat")){
                        ChatUtils.ToggleNormalChat();
                    }
                    if (command.equals("unload")){
                        UnloadUtil.unload();
                        ChatUtils.SendMessage("Unloaded.");
                    }
                    if (command.equals("setprefix")) {
                        ChatUtils.SendMessage("Changing Prefix...");
                        commandprefix = JOptionPane.showInputDialog("Enter a new prefix.");
                        ChatUtils.SendMessage("");
                    }
                    if (command.equals("togglehud")){
                            HudUtils.toggle();
                    }
                    if (command.isEmpty()){}

        });
        command = null;
        event.setCanceled(true);
    }else {
        command =null;}
    }
}
