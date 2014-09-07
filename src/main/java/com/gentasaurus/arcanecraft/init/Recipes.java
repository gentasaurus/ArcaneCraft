package com.gentasaurus.arcanecraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Recipes
{
    public static void init()
    {

        GameRegistry.addRecipe(new ItemStack(ModBlocks.packedGravel, 2),
                "GGG",
                "GGG",
                "GGG",
                'G', Blocks.gravel);

        GameRegistry.addRecipe(new ItemStack(ModBlocks.runicCasing),
                "IDI",
                "DID",
                "IDI",
                'D', ModItems.arcaniumDustRaw, 'I', Items.iron_ingot);

        GameRegistry.addRecipe(new ItemStack(ModBlocks.arcaneOvenIdle),
                "SRS",
                "RFR",
                "SRS",
                'F', Blocks.furnace, 'R', ModBlocks.runicCasing, 'S', Blocks.stone);

        GameRegistry.addRecipe(new ItemStack(ModBlocks.arcaneInfuser),
                "SCS",
                "SRS",
                "DSD",
                'S', Blocks.stonebrick, 'R', ModBlocks.runicCasing, 'C', Blocks.crafting_table, 'D', ModItems.arcaniumDustRaw);

        GameRegistry.addRecipe(new ItemStack(ModItems.reinforcedStick),
                " T ",
                "TST",
                "AAA",
                'S', Items.stick,'T', new ItemStack(ModItems.arcaniumDust, 1, 2), 'A', ModItems.arcaniumDustRaw);

        GameRegistry.addRecipe(new ItemStack(ModItems.waterStaff),
                "WWW",
                "WSA",
                "WAS",
                'S', ModItems.reinforcedStick, 'A', ModItems.arcaniumDustRaw, 'W', new ItemStack(ModItems.arcaniumDust, 1, 1));

        GameRegistry.addRecipe(new ItemStack(ModBlocks.voidLamp),
                "GDG",
                "LGL",
                "GRG",
                'G', Blocks.glass, 'R', Items.redstone, 'L', new ItemStack(ModItems.arcaniumDust, 1, 5), 'D', new ItemStack(ModItems.arcaniumDust, 1, 4));

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.arcaneFuel, 2), new Object[]{
                new ItemStack(Items.coal), new ItemStack(ModItems.arcaniumDust, 1, 0), new ItemStack(ModItems.arcaniumDust, 1, 5), new ItemStack(Items.iron_ingot)
        });
    }
}
