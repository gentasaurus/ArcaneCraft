package com.gentasaurus.arcanecraft.init;

import com.gentasaurus.arcanecraft.block.BlockGeneric;
import com.gentasaurus.arcanecraft.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

@GameRegistry.ObjectHolder(Reference.modid)
public class ModBlocks
{
    public static final Block arcaniumOre = new BlockGeneric().setBlockName("arcaniumOre").setBlockTextureName(Reference.modid + ":" + "arcaniumOre");

    public static void init()
    {
        GameRegistry.registerBlock(arcaniumOre, "arcaniumOre");
    }
}
