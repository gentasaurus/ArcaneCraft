package com.gentasaurus.arcanecraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

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
        //
        GameRegistry.addRecipe(new ItemStack(ModItems.lavaStaff),
                "LLL",
                "LSF",
                "LFS",
                'S', ModItems.reinforcedStick, 'L', new ItemStack(ModItems.arcaniumDust, 1, 7), 'F', new ItemStack(ModItems.arcaniumDust, 1, 0));
        //
        GameRegistry.addRecipe(new ItemStack(ModItems.undeadStaff),
                "UUU",
                "USD",
                "UDS",
                'S', ModItems.reinforcedStick, 'U', new ItemStack(ModItems.arcaniumDust, 1, 6), 'D', new ItemStack(ModItems.arcaniumDust, 1, 4));
        //
        GameRegistry.addRecipe(new ItemStack(ModItems.lightningPickaxe),
                "OLO",
                "LSL",
                "LSL",
                'S', ModItems.reinforcedStick, 'O', Blocks.obsidian, 'L', new ItemStack(ModItems.arcaniumDust, 1, 9));
        //
        GameRegistry.addRecipe(new ItemStack(ModItems.arcaneHelmet),
                "DID",
                "IHI",
                "DID",
                'H', ModItems.armorStructure, 'D', ModItems.arcaniumDustRaw, 'I', new ItemStack(ModItems.arcaniumDust, 1, 8));
        //
        GameRegistry.addRecipe(new ItemStack(ModItems.arcaneChestplate),
                "DID",
                "IHI",
                "DID",
                'H', ModItems.armorStructure, 'D', Blocks.cactus, 'I', new ItemStack(ModItems.arcaniumDust, 1, 10));
        //
        GameRegistry.addRecipe(new ItemStack(ModItems.arcaneLeggings),
                "DID",
                "IHI",
                "DID",
                'H', ModItems.armorStructure, 'D', new ItemStack(ModItems.arcaniumDust, 1, 8), 'I', new ItemStack(ModItems.arcaniumDust, 1, 7));
        //
        GameRegistry.addRecipe(new ItemStack(ModItems.arcaneBoots),
                "DID",
                "IHI",
                "DID",
                'H', ModItems.armorStructure, 'D', new ItemStack(ModItems.arcaniumDust, 1, 11), 'I', new ItemStack(ModItems.arcaniumDust, 1, 3));
        //
        GameRegistry.addRecipe(new ItemStack(ModItems.armorStructure, 2),
                "OHO",
                "COL",
                "OBO",
                'O', Blocks.obsidian, 'H', Items.iron_helmet, 'C', Items.iron_chestplate, 'L', Items.iron_leggings, 'B', Items.iron_boots);
        //SHAPELESS
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.arcaneFuel, 2), new Object[]{
                new ItemStack(Items.coal), new ItemStack(ModItems.arcaniumDust, 1, 0), new ItemStack(ModItems.arcaniumDust, 1, 5), new ItemStack(Items.iron_ingot)
        });
        //MISC.
        GameRegistry.addRecipe(new ItemStack(ModItems.waterStaff),
                "WWW",
                "WSW",
                "WWW",
                'S', new ItemStack(ModItems.waterStaff, 1, OreDictionary.WILDCARD_VALUE), 'W', new ItemStack(ModItems.arcaniumDust, 1, 1));
        //
        GameRegistry.addRecipe(new ItemStack(ModItems.lavaStaff),
                "FLF",
                "LSL",
                "FLF",
                'S', new ItemStack(ModItems.lavaStaff, 1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(ModItems.arcaniumDust, 1, 0), 'L', new ItemStack(ModItems.arcaniumDust, 1, 7));

        //
        GameRegistry.addRecipe(new ItemStack(ModItems.undeadStaff),
                "DUD",
                "USU",
                "DUD",
                'S', new ItemStack(ModItems.undeadStaff, 1, OreDictionary.WILDCARD_VALUE), 'D', new ItemStack(ModItems.arcaniumDust, 1, 4), 'U', new ItemStack(ModItems.arcaniumDust, 1, 6));
    }
}
