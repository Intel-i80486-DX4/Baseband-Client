package me.baseband.client;

import me.baseband.client.commands.CommandManager;
import me.baseband.client.modules.ModuleManager;
import net.minecraftforge.common.MinecraftForge;

public class Register {
    static ModuleManager moduleman = new ModuleManager();
    static CommandManager commandman = new CommandManager();

    public static void LoadAll(){
        MinecraftForge.EVENT_BUS.register(moduleman);
        //I'm being too hopeful.
        MinecraftForge.EVENT_BUS.register(commandman);
        //Something from pre-rewrite.
    }
}
