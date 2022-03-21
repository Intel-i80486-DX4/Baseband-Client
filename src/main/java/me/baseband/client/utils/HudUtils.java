package me.baseband.client.utils;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static me.baseband.client.Main.mc;

public class HudUtils {
    public static boolean enabled = false;

    public static void toggle(){
        enabled=!enabled;
        ChatUtils.SendMessage("HUD set to "+enabled);
    }

    @SubscribeEvent
    public void overlay(RenderGameOverlayEvent.Post event) {
        if (enabled) {
            if (event.getType() != RenderGameOverlayEvent.ElementType.EXPERIENCE) return;
            mc.getMinecraft().fontRenderer.drawStringWithShadow("BaseBand", 2, 2, 0xFF00FF00);
        }
    }
}
