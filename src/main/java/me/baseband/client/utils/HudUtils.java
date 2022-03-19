package me.baseband.client.utils;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static me.baseband.client.Main.mc;

public class HudUtils {

    @SubscribeEvent
    public void overlay(RenderGameOverlayEvent.Post event) {
        if (event.getType() != RenderGameOverlayEvent.ElementType.EXPERIENCE) return;
        mc.getMinecraft().fontRenderer.drawStringWithShadow("BaseBand", 2, 2, 0xFF00FF00);
    }
}
