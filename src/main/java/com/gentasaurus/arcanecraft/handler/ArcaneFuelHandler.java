package com.gentasaurus.arcanecraft.handler;

import com.gentasaurus.arcanecraft.init.ModItems;
import com.gentasaurus.arcanecraft.item.ItemArcaniumDust;
import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.ItemStack;

public class ArcaneFuelHandler implements IFuelHandler
{

    @Override
    public int getBurnTime(ItemStack fuel)
    {
        if(fuel.getItem() == ModItems.arcaniumDust)
        {
            if(fuel.getItemDamage() == ItemArcaniumDust.elements.indexOf("ignis"))
            {
                return 2000;
            }
            else return 0;
        }
        return 0;
    }
}
