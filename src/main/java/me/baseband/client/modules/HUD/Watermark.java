package me.baseband.client.modules.HUD;

import me.baseband.client.utils.Misc;
import net.minecraft.client.Minecraft;

public class Watermark {

    public static void onRender(){
        Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(Misc.ClientName(), 2, 2, 0xFF00FF00);
    }
}
