package com.gentasaurus.arcanecraft.item.crafting;

import java.util.*;

import com.gentasaurus.arcanecraft.init.ModBlocks;
import com.gentasaurus.arcanecraft.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class InfuserCraftingManager
{
    /** The static instance of this class */
    private static final InfuserCraftingManager instance = new InfuserCraftingManager();

    /** A list of all the recipes added */
    private List recipes = new ArrayList();

    /**
     * Returns the static instance of this class
     */
    public static final InfuserCraftingManager getInstance()
    {
        return instance;
    }

    private InfuserCraftingManager()
    {
        recipes = new ArrayList();

        this.addRecipe(new ItemStack(ModItems.arcaniumDust, 1, 0), new Object[]
                {"D R", 'D', ModItems.arcaniumDustRaw, 'R', Blocks.torch});
        //
        this.addRecipe(new ItemStack(ModItems.arcaniumDust, 1, 1), new Object[]
                {"D R", 'D', ModItems.arcaniumDustRaw, 'R', Items.water_bucket});
        //
        this.addRecipe(new ItemStack(ModItems.arcaniumDust, 1, 2), new Object[]
                {"D R", 'D', ModItems.arcaniumDustRaw, 'R', ModBlocks.packedGravel});
        //
        this.addRecipe(new ItemStack(ModItems.arcaniumDust, 1, 3), new Object[]
                {"D R", 'D', ModItems.arcaniumDustRaw, 'R', Items.feather});
        //
        this.addRecipe(new ItemStack(ModItems.arcaniumDust, 1, 4), new Object[]
                {"D R", 'D', ModItems.arcaniumDustRaw, 'R', Items.bone});
        //
        this.addRecipe(new ItemStack(ModItems.arcaniumDust, 1, 5), new Object[]
                {"D R", 'D', ModItems.arcaniumDustRaw, 'R', new ItemStack(Items.dye, 1, 11)});
        //
        //
        this.addRecipe(new ItemStack(ModItems.arcaniumDust, 1, 6), new Object[]
                {"DCR", 'D', new ItemStack(ModItems.arcaniumDust, 1, 4), 'C', new ItemStack(ModItems.arcaniumDust, 1, 2), 'R', Items.rotten_flesh});
        //
        this.addRecipe(new ItemStack(ModItems.arcaniumDust, 1, 7), new Object[]
                {"DCR", 'D', new ItemStack(ModItems.arcaniumDust, 1, 0), 'C', new ItemStack(ModItems.arcaniumDust, 1, 5), 'R', Items.lava_bucket});
        //
        this.addRecipe(new ItemStack(ModItems.arcaniumDust, 1, 8), new Object[]
                {"DCR", 'D', new ItemStack(ModItems.arcaniumDust, 1, 1), 'C', new ItemStack(ModItems.arcaniumDust, 1, 2), 'R', Blocks.snow});
        //
        this.addRecipe(new ItemStack(ModItems.arcaniumDust, 1, 9), new Object[]
                {"DCR", 'D', new ItemStack(ModItems.arcaniumDust, 1, 1), 'C', new ItemStack(ModItems.arcaniumDust, 1, 3), 'R', Items.redstone});
        //
        this.addRecipe(new ItemStack(ModItems.arcaniumDust, 1, 10), new Object[]
                {"DCR", 'D', new ItemStack(ModItems.arcaniumDust, 1, 2), 'C', new ItemStack(ModItems.arcaniumDust, 1, 5), 'R', Blocks.red_flower});
        //
        this.addRecipe(new ItemStack(ModItems.arcaniumDust, 1, 11), new Object[]
                {"DCR", 'D', new ItemStack(ModItems.arcaniumDust, 1, 3), 'C', new ItemStack(ModItems.arcaniumDust, 1, 3), 'R', new ItemStack(ModItems.arcaniumDust, 1, 3)});

        Collections.sort(this.recipes, new InfuserRecipeSorter(this));
    }

    public ShapedRecipesInfuser addRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
    {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (par2ArrayOfObj[i] instanceof String[])
        {
            String[] astring = (String[])((String[])par2ArrayOfObj[i++]);

            for (int l = 0; l < astring.length; ++l)
            {
                String s1 = astring[l];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }
        else
        {
            while (par2ArrayOfObj[i] instanceof String)
            {
                String s2 = (String)par2ArrayOfObj[i++];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }

        HashMap hashmap;

        for (hashmap = new HashMap(); i < par2ArrayOfObj.length; i += 2)
        {
            Character character = (Character)par2ArrayOfObj[i];
            ItemStack itemstack1 = null;

            if (par2ArrayOfObj[i + 1] instanceof Item)
            {
                itemstack1 = new ItemStack((Item)par2ArrayOfObj[i + 1]);
            }
            else if (par2ArrayOfObj[i + 1] instanceof Block)
            {
                itemstack1 = new ItemStack((Block)par2ArrayOfObj[i + 1], 1, 32767);
            }
            else if (par2ArrayOfObj[i + 1] instanceof ItemStack)
            {
                itemstack1 = (ItemStack)par2ArrayOfObj[i + 1];
            }

            hashmap.put(character, itemstack1);
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1)
        {
            char c0 = s.charAt(i1);

            if (hashmap.containsKey(Character.valueOf(c0)))
            {
                aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c0))).copy();
            }
            else
            {
                aitemstack[i1] = null;
            }
        }

        ShapedRecipesInfuser shapedSCTrecipes = new ShapedRecipesInfuser(j, k, aitemstack, par1ItemStack);
        this.recipes.add(shapedSCTrecipes);
        return shapedSCTrecipes;
    }

    public void addShapelessRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
    {
        ArrayList arraylist = new ArrayList();
        Object[] aobject = par2ArrayOfObj;
        int i = par2ArrayOfObj.length;

        for (int j = 0; j < i; ++j)
        {
            Object object1 = aobject[j];

            if (object1 instanceof ItemStack)
            {
                arraylist.add(((ItemStack)object1).copy());
            }
            else if (object1 instanceof Item)
            {
                arraylist.add(new ItemStack((Item)object1));
            }
            else
            {
                if (!(object1 instanceof Block))
                {
                    throw new RuntimeException("Invalid shapeless recipe!");
                }

                arraylist.add(new ItemStack((Block)object1));
            }
        }

        this.recipes.add(new ShapelessRecipesInfuser(par1ItemStack, arraylist));
    }

    public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting, World par2World)
    {
        int i = 0;
        ItemStack itemstack = null;
        ItemStack itemstack1 = null;
        int j;

        for (j = 0; j < par1InventoryCrafting.getSizeInventory(); ++j)
        {
            ItemStack itemstack2 = par1InventoryCrafting.getStackInSlot(j);

            if (itemstack2 != null)
            {
                if (i == 0)
                {
                    itemstack = itemstack2;
                }

                if (i == 1)
                {
                    itemstack1 = itemstack2;
                }

                ++i;
            }
        }

        if (i == 2 && itemstack.getItem() == itemstack1.getItem() && itemstack.stackSize == 1 && itemstack1.stackSize == 1 && itemstack.getItem().isRepairable())
        {
            Item item = itemstack.getItem();
            int k = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
            int l = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
            int i1 = k + l + item.getMaxDamage() * 5 / 100;
            int j1 = item.getMaxDamage() - i1;

            if (j1 < 0)
            {
                j1 = 0;
            }

            return new ItemStack(itemstack.getItem());
        }
        else
        {
            for (j = 0; j < this.recipes.size(); ++j)
            {
                IRecipe irecipe = (IRecipe)this.recipes.get(j);

                if (irecipe.matches(par1InventoryCrafting, par2World))
                {
                    return irecipe.getCraftingResult(par1InventoryCrafting);
                }
            }

            return null;
        }
    }

    /**
     * returns the List<> of all recipes
     */
    public List getRecipeList()
    {
        return this.recipes;
    }
}

