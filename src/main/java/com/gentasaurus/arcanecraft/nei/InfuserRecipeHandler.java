package com.gentasaurus.arcanecraft.nei;

import codechicken.core.ReflectionManager;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.api.DefaultOverlayRenderer;
import codechicken.nei.api.IOverlayHandler;
import codechicken.nei.api.IRecipeOverlayRenderer;
import codechicken.nei.api.IStackPositioner;
import codechicken.nei.recipe.RecipeInfo;
import codechicken.nei.recipe.TemplateRecipeHandler;
import com.gentasaurus.arcanecraft.client.gui.GuiArcaneInfuser;
import com.gentasaurus.arcanecraft.item.crafting.InfuserCraftingManager;
import com.gentasaurus.arcanecraft.item.crafting.ShapedRecipesInfuser;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InfuserRecipeHandler extends TemplateRecipeHandler
{
    public class CachedShapedRecipe extends CachedRecipe
    {
        public ArrayList<PositionedStack> ingredients;
        public PositionedStack result;

        public CachedShapedRecipe(int width, int height, Object[] items, ItemStack out) {
            result = new PositionedStack(out, 113, 21);
            ingredients = new ArrayList<PositionedStack>();
            setIngredients(items);
        }

        public CachedShapedRecipe(ShapedRecipesInfuser recipe) {
            this(recipe.recipeWidth, recipe.recipeHeight, recipe.recipeItems, recipe.getRecipeOutput());
        }

        public void setIngredients(Object[] items) {

            if(items[0] != null)
            {
                PositionedStack stack1 = new PositionedStack(items[0], 11, 41, false);
                stack1.setMaxSize(1);
                ingredients.add(stack1);
            }

            if(items[1] != null)
            {
                PositionedStack stack2 = new PositionedStack(items[1], 63, 41, false);
                stack2.setMaxSize(1);
                ingredients.add(stack2);
            }

            if(items[2] != null)
            {
                PositionedStack stack3 = new PositionedStack(items[2], 37, 1, false);
                stack3.setMaxSize(1);
                ingredients.add(stack3);
            }
        }

        @Override
        public List<PositionedStack> getIngredients() {
            return getCycledIngredients(cycleticks / 20, ingredients);
        }

        public PositionedStack getResult() {
            return result;
        }

        public void computeVisuals() {
            for (PositionedStack p : ingredients)
                p.generatePermutations();
        }
    }

    @Override
    public void loadTransferRects() {
        transferRects.add(new RecipeTransferRect(new Rectangle(29, 19, 32, 20), "arcaneinfuser"));
    }

    @Override
    public Class<? extends GuiContainer> getGuiClass() {
        return GuiArcaneInfuser.class;
    }

    @Override
    public String getRecipeName() {
        return "Arcane Infuser";
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results) {
        if (outputId.equals("arcaneinfuser") && getClass() == InfuserRecipeHandler.class) {
            for (IRecipe irecipe : (List<IRecipe>) InfuserCraftingManager.getInstance().getRecipeList()) {
                CachedShapedRecipe recipe = null;
                if (irecipe instanceof ShapedRecipesInfuser)
                    recipe = new CachedShapedRecipe((ShapedRecipesInfuser) irecipe);

                if (recipe == null)
                    continue;

                recipe.computeVisuals();
                arecipes.add(recipe);
            }
        } else {
            super.loadCraftingRecipes(outputId, results);
        }
    }

    @Override
    public void loadCraftingRecipes(ItemStack result) {
        for (IRecipe irecipe : (List<IRecipe>) InfuserCraftingManager.getInstance().getRecipeList()) {
            if (NEIServerUtils.areStacksSameTypeCrafting(irecipe.getRecipeOutput(), result)) {
                CachedShapedRecipe recipe = null;
                if (irecipe instanceof ShapedRecipesInfuser)
                    recipe = new CachedShapedRecipe((ShapedRecipesInfuser) irecipe);

                if (recipe == null)
                    continue;

                recipe.computeVisuals();
                arecipes.add(recipe);
            }
        }
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient) {
        for (IRecipe irecipe : (List<IRecipe>) InfuserCraftingManager.getInstance().getRecipeList()) {
            CachedShapedRecipe recipe = null;
            if (irecipe instanceof ShapedRecipesInfuser)
                recipe = new CachedShapedRecipe((ShapedRecipesInfuser) irecipe);

            if (recipe == null || !recipe.contains(recipe.ingredients, ingredient.getItem()))
                continue;

            recipe.computeVisuals();
            if (recipe.contains(recipe.ingredients, ingredient)) {
                recipe.setIngredientPermutation(recipe.ingredients, ingredient);
                arecipes.add(recipe);
            }
        }
    }

    public CachedShapedRecipe forgeShapedRecipe(ShapedOreRecipe recipe) {
        int width;
        int height;
        try {
            width = ReflectionManager.getField(ShapedOreRecipe.class, Integer.class, recipe, 4);
            height = ReflectionManager.getField(ShapedOreRecipe.class, Integer.class, recipe, 5);
        } catch (Exception e) {
            NEIClientConfig.logger.error("Error loading recipe", e);
            return null;
        }

        Object[] items = recipe.getInput();
        for (Object item : items)
            if (item instanceof List && ((List<?>) item).isEmpty())//ore handler, no ores
                return null;

        return new CachedShapedRecipe(width, height, items, recipe.getRecipeOutput());
    }

    @Override
    public String getGuiTexture() {
        return "arcanecraft:textures/gui/ArcaneInfuserNEI.png";
    }

    @Override
    public String getOverlayIdentifier() {
        return "arcaneinfuser";
    }

    public boolean hasOverlay(GuiContainer gui, net.minecraft.inventory.Container container, int recipe) {
        return super.hasOverlay(gui, container, recipe) ||
                isRecipe2x2(recipe) && RecipeInfo.hasDefaultOverlay(gui, "crafting2x2");
    }

    @Override
    public IRecipeOverlayRenderer getOverlayRenderer(GuiContainer gui, int recipe) {
        IRecipeOverlayRenderer renderer = super.getOverlayRenderer(gui, recipe);
        if (renderer != null)
            return renderer;

        IStackPositioner positioner = RecipeInfo.getStackPositioner(gui, "crafting2x2");
        if (positioner == null)
            return null;
        return new DefaultOverlayRenderer(getIngredientStacks(recipe), positioner);
    }

    @Override
    public IOverlayHandler getOverlayHandler(GuiContainer gui, int recipe) {
        IOverlayHandler handler = super.getOverlayHandler(gui, recipe);
        if (handler != null)
            return handler;

        return RecipeInfo.getOverlayHandler(gui, "crafting2x2");
    }

    public boolean isRecipe2x2(int recipe) {
        for (PositionedStack stack : getIngredientStacks(recipe))
            if (stack.relx > 43 || stack.rely > 24)
                return false;

        return true;
    }
}
