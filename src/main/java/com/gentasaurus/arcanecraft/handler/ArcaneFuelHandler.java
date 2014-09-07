package com.gentasaurus.arcanecraft.handler;

import com.gentasaurus.arcanecraft.init.ModItems;
import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.ItemStack;

public class ArcaneFuelHandler implements IFuelHandler
{

    @Override
    public int getBurnTime(ItemStack fuel)
    {
        if(fuel.getItem() == ModItems.arcaniumDust)
        {
            if(fuel.getItemDamage() == 0)
            {
                return 2000;
            }
            else return 0;
        }
        return 0;
    }
}
