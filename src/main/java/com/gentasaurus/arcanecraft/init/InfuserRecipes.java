package com.gentasaurus.arcanecraft.init;

import com.gentasaurus.arcanecraft.item.ItemArcaniumDust;
import com.gentasaurus.arcanecraft.item.crafting.InfuserCraftingManager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class InfuserRecipes
{
    public static void init()
    {
        InfuserCraftingManager.getInstance().addInfusion("immortui", "tenebris", "terra", Items.rotten_flesh, 2);
        InfuserCraftingManager.getInstance().addInfusion("lava", "ignis", "lux", Items.lava_bucket, 2);
        InfuserCraftingManager.getInstance().addInfusion("glaciem", "aqua", "terra", Blocks.snow, 2);
        InfuserCraftingManager.getInstance().addInfusion("fulgura", "lux", "terra", Items.redstone, 2);
        InfuserCraftingManager.getInstance().addInfusion("plantatio", "terra", "lux", Blocks.red_flower, 2);
        InfuserCraftingManager.getInstance().addInfusion("turbo", "ventum", "ventum", new ItemStack(ModItems.arcaniumDust, 1, ItemArcaniumDust.elements.indexOf("ventum")), 1);
    }

}
