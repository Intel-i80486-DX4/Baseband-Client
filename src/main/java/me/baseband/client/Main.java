package me.baseband.client;

import me.baseband.client.events.RespawnEvent;
import me.baseband.client.utils.Register;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main
{
    public static final String MODID = "baseband";
    public static final String NAME = "Baseband";
    public static final String VERSION = "0.3";

    private static Logger logger;
    public static Minecraft mc;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        //Events time...
        logger.info("Init.");
        Register.RegisterAll();
        logger.info("Baseband Loaded...");
    }
}