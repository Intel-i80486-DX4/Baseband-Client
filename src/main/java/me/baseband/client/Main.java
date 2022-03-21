package me.baseband.client;

import me.baseband.client.utils.UnloadUtil;
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
        logger.info("\n______                   ______                    _ \n" +
                    "| ___ \\                  | ___ \\                  | |\n" +
                    "| |_/ /  __ _  ___   ___ | |_/ /  __ _  _ __    __| |\n" +
                    "| ___ \\ / _` |/ __| / _ \\| ___ \\ / _` || '_ \\  / _` |\n" +
                    "| |_/ /| (_| |\\__ \\|  __/| |_/ /| (_| || | | || (_| |\n" +
                    "\\____/  \\__,_||___/ \\___|\\____/  \\__,_||_| |_| \\__,_|");
        UnloadUtil.load();
        logger.info("Baseband Loaded...");
    }

}