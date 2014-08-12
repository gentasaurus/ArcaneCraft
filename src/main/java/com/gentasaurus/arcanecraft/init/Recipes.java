package com.gentasaurus.arcanecraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Recipes
{
    public static void init()
    {
        //MISC
        GameRegistry.addRecipe(new ItemStack(ModItems.arcaneFuel),
                "ROR",
                "YCY",
                "ROR",
                'C', Items.coal, 'O', new ItemStack(ModItems.arcaniumDust, 1, 2), 'Y', new ItemStack(ModItems.arcaniumDust, 1, 3), 'R', new ItemStack(ModItems.arcaniumDust, 1, 7));

        GameRegistry.addRecipe(new ItemStack(ModBlocks.runicCasing),
                "DID",
                "IDI",
                "DID",
                'D', new ItemStack(ModItems.arcaniumDust, 1, 7), 'I', Items.iron_ingot);

        GameRegistry.addRecipe(new ItemStack(ModBlocks.arcaneOvenIdle),
                "DRD",
                "ICI",
                "DRD",
                'D', new ItemStack(ModItems.arcaniumDust, 1, 0), 'R', new ItemStack(ModItems.arcaniumDust, 1, 1), 'C', ModBlocks.runicCasing, 'I', Items.iron_ingot);

        GameRegistry.addSmelting(ModBlocks.arcaniumOre, new ItemStack(ModItems.arcaniumDust, 1, 0), 0.0F);

        //TIER 1 DUSTS
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.arcaniumDust, 1, 1), new ItemStack(ModItems.arcaniumDust, 1, 0), new ItemStack(Items.gunpowder), new ItemStack(Items.dye, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.arcaniumDust, 1, 3), new ItemStack(ModItems.arcaniumDust, 1, 0), new ItemStack(Items.redstone), new ItemStack(Items.dye, 1, 11));
        GameRegistry.addSmelting(new ItemStack(ModItems.arcaniumDust, 1, 0), new ItemStack(ModItems.arcaniumDust, 1, 7), 0.0F);
        //TIER 2 DUSTS
        GameRegistry.addRecipe(new ItemStack(ModItems.arcaniumDust, 1, 2),
                " R ",
                "YDY",
                " R ",
                'D', new ItemStack(ModItems.arcaniumDust, 1, 7), 'R', new ItemStack(ModItems.arcaniumDust, 1, 1), 'Y', new ItemStack(ModItems.arcaniumDust, 1, 3));
        GameRegistry.addRecipe(new ItemStack(ModItems.arcaniumDust, 1, 2), " Y ", "RDR",  " Y ", 'D', new ItemStack(ModItems.arcaniumDust, 1, 7), 'R', new ItemStack(ModItems.arcaniumDust, 1, 1), 'Y', new ItemStack(ModItems.arcaniumDust, 1, 3));
        GameRegistry.addRecipe(new ItemStack(ModItems.arcaniumDust, 1, 5),
                "RDL",
                "DID",
                "LDR",
                'R', Items.redstone, 'L', new ItemStack(Items.dye, 1, 4), 'D', new ItemStack(ModItems.arcaniumDust, 1, 7), 'I', new ItemStack(ModItems.arcaniumDust, 1, 2));
        GameRegistry.addRecipe(new ItemStack(ModItems.arcaniumDust, 1, 5), "LDR", "DID", "RDL", 'R', Items.redstone, 'L', new ItemStack(Items.dye, 1, 4), 'D', new ItemStack(ModItems.arcaniumDust, 1, 7), 'I', new ItemStack(ModItems.arcaniumDust, 1, 2));
    }
}
