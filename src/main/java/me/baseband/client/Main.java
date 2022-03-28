package me.baseband.client;

import me.baseband.client.modules.ModuleManager;
import me.baseband.client.utils.LogUtil;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main {
    public static final String MODID = "baseband";
    public static final String NAME = "Baseband";
    public static final String VERSION = "0.9";

    private static Logger logger;
    public static Minecraft mc;


    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        //Events time...
        LogUtil.ConsoleString("Loading Baseband...");
        //Stupid.
        Register.LoadAll();
        ModuleManager.AddEvents();

        LogUtil.ConsoleString("Baseband Loaded...");
    }

}