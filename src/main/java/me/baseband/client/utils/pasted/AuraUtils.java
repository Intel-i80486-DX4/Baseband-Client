package me.baseband.client.utils.pasted;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

import static me.baseband.client.Main.mc;


public class AuraUtils {
 //Also gishcode.
    static boolean players = false;
    static boolean hostileMobs = false;
    static boolean passiveMobs = false;
    static boolean armorStands = false;
    static boolean throughWalls = false;
    static boolean aimBot = false;
    static boolean ddelay = false;
    static int range = 4;
    static int CPS = 12;

    public static void config(){
            range = Integer.parseInt(JOptionPane.showInputDialog("Enter Range (1-5)"));
            CPS = Integer.parseInt(JOptionPane.showInputDialog("Enter CPS (1-20)"));
            players = Boolean.parseBoolean(JOptionPane.showInputDialog("Attack Players? True/False"));
            hostileMobs = Boolean.parseBoolean(JOptionPane.showInputDialog("Attack Hostile Mobs? True/False"));
            passiveMobs = Boolean.parseBoolean(JOptionPane.showInputDialog("Attack Passive Mobs? True/False"));
            armorStands = Boolean.parseBoolean(JOptionPane.showInputDialog("Attack Armor Stands? True/False"));
            throughWalls = Boolean.parseBoolean(JOptionPane.showInputDialog("Attack Through Walls? True/False"));
            aimBot = Boolean.parseBoolean(JOptionPane.showInputDialog("Aimbot? True/False"));
            ddelay = Boolean.parseBoolean(JOptionPane.showInputDialog("1.9 Hit Delay? (Broken, False Recommended.) True/False"));
    }



    private int delay = 0;




    @SubscribeEvent
    public void onUpdate(TickEvent.ClientTickEvent event) {
        try {
            delay++;
            int reqDelay = (int) Math.round(50 / CPS);
            if (ddelay) reqDelay = (int) Math.ceil(mc.player.getCooldownPeriod());

            List<Entity> targets = EntityUtils.getLoadedEntities().stream()
                    .filter(e -> (e instanceof EntityPlayer && (players)) || (e instanceof IMob && (hostileMobs) || (EntityUtils.isAnimal(e) && passiveMobs)
                            || (e instanceof EntityArmorStand && armorStands)))
                    .collect(Collectors.toList());
            targets.sort((a, b) -> Float.compare(a.getDistance(mc.player), b.getDistance(mc.player)));

            for (Entity e : targets) {
                if (mc.player.getDistance(e) > range
                        || !e.isEntityAlive()
                        || e == mc.player || e == mc.player.getRidingEntity() || e == mc.getRenderViewEntity()
                        || (!mc.player.canEntityBeSeen(e) && !throughWalls)) continue;

                if (aimBot) EntityUtils.facePos(e.posX, e.posY + e.getEyeHeight() / 2, e.posZ);

                if (delay > reqDelay || reqDelay == 0) {
                    mc.playerController.attackEntity(mc.player, e);
                    mc.player.swingArm(EnumHand.MAIN_HAND);
                    delay = 0;
                }
            }
        }catch(Exception e){
            //Empty try-catch block
             }

    }

}
