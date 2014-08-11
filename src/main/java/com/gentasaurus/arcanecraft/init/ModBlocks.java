package com.gentasaurus.arcanecraft.init;

import com.gentasaurus.arcanecraft.block.ArcaneOven;
import com.gentasaurus.arcanecraft.block.BlockArcaniumOre;
import com.gentasaurus.arcanecraft.block.BlockGeneric;
import com.gentasaurus.arcanecraft.creativetab.CreativeTabAC;
import com.gentasaurus.arcanecraft.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

@GameRegistry.ObjectHolder(Reference.modid)
public class ModBlocks
{
    public static final Block arcaniumOre = new BlockArcaniumOre().setBlockName("arcaniumOre").setBlockTextureName(Reference.modid + ":" + "arcaniumOre");
    public static final Block runicCasing = new BlockGeneric().setBlockName("runicCasing").setBlockTextureName(Reference.modid + ":" + "runicCasing");
    public static final Block arcaneOvenIdle = new ArcaneOven(false).setHardness(3.5F).setBlockName("arcaneOvenIdle").setBlockTextureName(Reference.modid + ":" + "arcaneOvenIdle").setCreativeTab(CreativeTabAC.tabArcaneCraft);
    public static final Block arcaneOvenActive = new ArcaneOven(true).setHardness(3.5F).setLightLevel(0.625F).setBlockName("arcaneOvenActive").setBlockTextureName(Reference.modid + ":" + "arcaneOvenActive");

    public static void init()
    {
        GameRegistry.registerBlock(arcaniumOre, "arcaniumOre");
        GameRegistry.registerBlock(runicCasing, "runicCasing");
        GameRegistry.registerBlock(arcaneOvenIdle, "arcaneOvenIdle");
        GameRegistry.registerBlock(arcaneOvenActive, "arcaneOvenActive");
    }
}
