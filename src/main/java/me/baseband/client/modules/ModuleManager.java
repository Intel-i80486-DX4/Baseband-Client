package me.baseband.client.modules;

import me.baseband.client.modules.HUD.Watermark;
import me.baseband.client.utils.ChatUtils;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.ArrayList;
import java.util.Iterator;

public class ModuleManager {

    static ArrayList<String> modules = new ArrayList<String>();
    static ArrayList<Boolean> enabled = new ArrayList<Boolean>();
    private static int amountsofmodules = 0;

    //Prepare for eye burning...
    public static boolean watermarkenabled=false;
    //^ is module actually enabled?





    public static void AddEvents(){

        /*
        Proper Module Declaration as follows.
        modules.add("ModuleName")
        ^ Module name???
        enabled.add(false)
        ^ Enabled by default??
        amountsofmodules++
        ^ needed, or stuff breaks fast.
        IN THAT ORDER!
         */
        //Needed i think because of my sucky arraylist handling.
        modules.add("DummyModule");
        enabled.add(false);
        amountsofmodules++;


        //Watermark... Module 2 for reference.
        modules.add("Watermark");
        enabled.add(false);
        amountsofmodules++;
        //This is stupid, beyond comprehension.


    }


    @SubscribeEvent
    public void UpdateModuleEvent(TickEvent.ClientTickEvent tickEvent){
        //Harder, Better, Faster, Stronger.
    }

    @SubscribeEvent
    public void TickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        //Soon.
    }

    @SubscribeEvent
    public void RenderEvent(TickEvent.RenderTickEvent renderTickEvent){
        //Yum.
        if(watermarkenabled){
            Watermark.onRender();
        }
    }

    public String ModuleNamePlusEnabled(int integer){
        int counted = 0;
        while(counted<=amountsofmodules) {
            return modules.get(integer) + "-" + enabled.get(integer).toString();
        }
        return null;
    }

    public static int Get(String e){
        return modules.indexOf(e);
    }


    public static void Sustenance(int w, boolean d, String f){
        //Needlessly complicated, I'll forget what this does and how it works tomorrow.
        ChatUtils.SendMessage("Toggling module "+modules.get(w));
        enabled.set(w, d);
        if(d){// If boolean true.

            if(f=="Watermark"){ //if String == ModuleName
                watermarkenabled=d;
            }

        }
        if(!d){// If boolean true.

            if(f=="Watermark"){ //if String == ModuleName
                watermarkenabled=d;
            }

        }
    }



    static public void listmodules(){
        Iterator iter = modules.iterator();
        while (iter.hasNext()) {
            ChatUtils.SendMessage(iter.next().toString());
        };
    }
}
