package com.gentasaurus.arcanecraft.init;

import com.gentasaurus.arcanecraft.item.ItemArcaniumDust;

public class CoreDusts
{

    public static void init()
    {
        //TIER 1
        ItemArcaniumDust.addElement("ignis");       //FIRE
        ItemArcaniumDust.addElement("aqua");        //WATER
        ItemArcaniumDust.addElement("terra");       //EARTH
        ItemArcaniumDust.addElement("ventum");      //AIR
        ItemArcaniumDust.addElement("tenebris");    //DARKNESS
        ItemArcaniumDust.addElement("lux");         //LIGHT

        //TIER 2
        ItemArcaniumDust.addElement("immortui");    //UNDEAD
        ItemArcaniumDust.addElement("lava");        //LAVA
        ItemArcaniumDust.addElement("glaciem");     //ICE
        ItemArcaniumDust.addElement("fulgura");     //ENERGY
        ItemArcaniumDust.addElement("plantatio");   //PLANTS
        ItemArcaniumDust.addElement("turbo");       //WIND

        //FINAL TIERS
        ItemArcaniumDust.addElement("ignotus");     //UNKNOWN
        ItemArcaniumDust.addElement("metalli");     //METAL
        ItemArcaniumDust.addElement("irrita");      //VOID
        ItemArcaniumDust.addElement("anima");       //LIFE
        ItemArcaniumDust.addElement("corruptio");   //DISTORTION
        ItemArcaniumDust.addElement("sanctorum");   //HALLOW
    }
    
}
