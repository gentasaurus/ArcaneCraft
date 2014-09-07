package com.gentasaurus.arcanecraft.init;

import com.gentasaurus.arcanecraft.block.*;
import com.gentasaurus.arcanecraft.creativetab.CreativeTabAC;
import com.gentasaurus.arcanecraft.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

@GameRegistry.ObjectHolder(Reference.modid)
public class ModBlocks
{
    public static final Block arcaniumOre = new BlockArcaniumOre().setBlockName("arcaniumOre").setBlockTextureName(Reference.resourcePrefix + "arcaniumOre").setStepSound(Block.soundTypeStone);
    public static final Block runicCasing = new BlockGeneric().setBlockName("runicCasing").setBlockTextureName(Reference.resourcePrefix + "runicCasing").setStepSound(Block.soundTypeStone);
    public static final Block arcaneOvenIdle = new ArcaneOven(false).setHardness(3.5F).setBlockName("arcaneOvenIdle").setBlockTextureName(Reference.resourcePrefix + "arcaneOvenIdle").setCreativeTab(CreativeTabAC.tabArcaneCraft).setStepSound(Block.soundTypeStone);
    public static final Block arcaneOvenActive = new ArcaneOven(true).setHardness(3.5F).setLightLevel(0.625F).setBlockName("arcaneOvenActive").setBlockTextureName(Reference.resourcePrefix + "arcaneOvenActive").setStepSound(Block.soundTypeStone);
    public static final Block arcaneInfuser = new ArcaneInfuser().setHardness(2.0F).setResistance(10.0F).setBlockName("arcaneInfuser").setBlockTextureName(Reference.resourcePrefix + "arcaneInfuser").setStepSound(Block.soundTypeStone);
    public static final Block packedGravel = new BlockGeneric(Material.sand).setHardness(0.6F).setBlockName("packedGravel").setBlockTextureName("gravel").setStepSound(Block.soundTypeGravel);
    public static final Block voidLamp = new BlockGeneric(Material.redstoneLight).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("voidLamp").setCreativeTab(CreativeTabAC.tabArcaneCraft).setBlockTextureName(Reference.resourcePrefix + "voidLamp");

    public static void init()
    {
        GameRegistry.registerBlock(arcaniumOre, "arcaniumOre");
        GameRegistry.registerBlock(runicCasing, "runicCasing");
        GameRegistry.registerBlock(arcaneOvenIdle, "arcaneOvenIdle");
        GameRegistry.registerBlock(arcaneOvenActive, "arcaneOvenActive");
        GameRegistry.registerBlock(arcaneInfuser, "arcaneInfuser");
        GameRegistry.registerBlock(packedGravel, "packedGravel");
        GameRegistry.registerBlock(voidLamp, "voidlamp");
    }
}
