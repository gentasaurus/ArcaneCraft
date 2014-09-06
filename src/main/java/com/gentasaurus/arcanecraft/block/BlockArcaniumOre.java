package com.gentasaurus.arcanecraft.block;

import com.gentasaurus.arcanecraft.init.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class BlockArcaniumOre extends BlockGeneric
{
    public BlockArcaniumOre()
    {
        super(Material.rock);
        this.setHardness(3.0F);
        this.setHarvestLevel("pickaxe", 2);
    }

    @Override
    public int quantityDropped(Random random)
    {
        return 1 + random.nextInt(2);
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return ModItems.arcaniumDustRaw;
    }
}
