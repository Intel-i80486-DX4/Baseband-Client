package me.baseband.client.utils;

public class Misc {
    static String Name = "BaseBand";
    static String Build = "B5";
    static String commandprefix = "B?";

    public static String ClientName(){
        return Name+Build;
    }

    public static String getCommandSuffix(){
        return commandprefix;
    }
}
