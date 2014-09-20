package com.gentasaurus.arcanecraft.init;

import com.gentasaurus.arcanecraft.item.crafting.InfuserCraftingManager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class InfuserRecipes
{
    public static void init()
    {
        InfuserCraftingManager.getInstance().addInfusion(6, 4, 2, Items.rotten_flesh);
        InfuserCraftingManager.getInstance().addInfusion(7, 0, 5, Items.lava_bucket);
        InfuserCraftingManager.getInstance().addInfusion(8, 1, 2, Blocks.snow);
        InfuserCraftingManager.getInstance().addInfusion(9, 1, 3, Items.redstone);
        InfuserCraftingManager.getInstance().addInfusion(10, 2, 5, Blocks.red_flower);
        InfuserCraftingManager.getInstance().addInfusion(11, 3, 3, new ItemStack(ModItems.arcaniumDust, 1, 3));
    }

}
