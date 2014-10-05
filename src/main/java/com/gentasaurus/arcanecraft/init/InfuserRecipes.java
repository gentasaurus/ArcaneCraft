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
        InfuserCraftingManager.getInstance().addInfusion("immortui", "tenebris", "terra", Items.bone, 2);
        InfuserCraftingManager.getInstance().addInfusion("lava", "ignis", "lux", Items.lava_bucket, 2);
        InfuserCraftingManager.getInstance().addInfusion("glaciem", "aqua", "terra", Blocks.snow, 2);
        InfuserCraftingManager.getInstance().addInfusion("fulgura", "lux", "terra", Items.redstone, 2);
        InfuserCraftingManager.getInstance().addInfusion("plantatio", "terra", "lux", Blocks.red_flower, 2);
        InfuserCraftingManager.getInstance().addInfusion("turbo", "ventum", "ventum", new ItemStack(ModItems.arcaniumDust, 1, ItemArcaniumDust.elements.indexOf("ventum")), 1);
        InfuserCraftingManager.getInstance().addInfusion("ignotus", "tenebris", "immortui", Items.ender_eye, 2);
        InfuserCraftingManager.getInstance().addInfusion("metalli", "terra", "lava", Items.iron_ingot, 1);
        InfuserCraftingManager.getInstance().addInfusion("irrita", "ignotus", "turbo", Items.ender_pearl, 2);
        InfuserCraftingManager.getInstance().addInfusion("anima", "plantatio", "fulgura", Items.porkchop, 2);
        InfuserCraftingManager.getInstance().addInfusion("corruptio", "irrita", "ignotus", Items.rotten_flesh, 2);
        InfuserCraftingManager.getInstance().addInfusion("sanctorum", "lux", "anima", Items.diamond, 2);
    }

}
