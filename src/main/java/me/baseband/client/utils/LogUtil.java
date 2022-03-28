package me.baseband.client.utils;

import java.util.logging.Logger;

public class LogUtil {
    private static final Logger logger = Logger.getLogger("BaseBand");

    public static void ConsoleString(String e){
        logger.info(e);
    }

    public static void ConsoleError(String e){
        logger.severe(e);
    }
}
