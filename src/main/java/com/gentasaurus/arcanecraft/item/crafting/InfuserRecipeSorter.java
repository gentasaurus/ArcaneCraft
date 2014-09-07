package com.gentasaurus.arcanecraft.item.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

class InfuserRecipeSorter implements Comparator
{
    final InfuserCraftingManager CraftingManager;

    InfuserRecipeSorter(InfuserCraftingManager par1CraftingManager)
    {
        this.CraftingManager = par1CraftingManager;
    }

    public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe)
    {
        return par1IRecipe instanceof ShapelessRecipesInfuser && par2IRecipe instanceof ShapedRecipesInfuser ? 1 : (par2IRecipe instanceof ShapelessRecipesInfuser && par1IRecipe instanceof ShapedRecipesInfuser ? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
    }

    @Override
    public int compare(Object par1Obj, Object par2Obj)
    {
        return this.compareRecipes((IRecipe)par1Obj, (IRecipe)par2Obj);
    }
}

