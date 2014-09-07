package com.gentasaurus.arcanecraft.init;

import com.gentasaurus.arcanecraft.item.ItemArcaniumDust;
import com.gentasaurus.arcanecraft.item.ItemGeneric;
import com.gentasaurus.arcanecraft.item.ItemWaterStaff;
import com.gentasaurus.arcanecraft.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

@GameRegistry.ObjectHolder(Reference.modid)
public class ModItems
{
    public static final Item arcaniumDustRaw = new ItemGeneric().setUnlocalizedName("arcaniumDustRaw");
    public static final Item arcaniumDust = new ItemArcaniumDust();
    public static final Item arcaneFuel = new ItemGeneric().setUnlocalizedName("arcaneFuel");
    public static final Item waterStaff = new ItemWaterStaff().setFull3D().setUnlocalizedName("waterStaff");
    public static final Item reinforcedStick = new ItemGeneric().setFull3D().setUnlocalizedName("reinforcedStick");

    public static void init()
    {
        GameRegistry.registerItem(arcaniumDustRaw, "arcaniumDustRaw");
        GameRegistry.registerItem(arcaniumDust, "arcaniumDust");
        GameRegistry.registerItem(arcaneFuel, "arcaneFuel");
        GameRegistry.registerItem(waterStaff, "waterStaff");
        GameRegistry.registerItem(reinforcedStick, "reinforcedStick");
    }
}
