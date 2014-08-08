package com.gentasaurus.arcanecraft.init;

import com.gentasaurus.arcanecraft.item.ItemArcaniumDust;
import com.gentasaurus.arcanecraft.item.ItemGeneric;
import com.gentasaurus.arcanecraft.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

@GameRegistry.ObjectHolder(Reference.modid)
public class ModItems
{
    public static final Item arcaniumDust = new ItemArcaniumDust();


    public static void init()
    {
        GameRegistry.registerItem(arcaniumDust, "arcaniumDust");
    }
}
