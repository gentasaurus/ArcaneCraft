package com.gentasaurus.arcanecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemWaterStaff extends ItemStaff
{

    public ItemWaterStaff()
    {
        super();
    }

    @Override
    public void activateStaff(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
            if (side == 3)
                world.setBlock(x, y, z + 1, Blocks.flowing_water);
            if (side == 4)
                world.setBlock(x - 1, y, z, Blocks.flowing_water);
            if (side == 5)
                world.setBlock(x + 1, y, z, Blocks.flowing_water);
            if (side == 2)
                world.setBlock(x, y, z - 1, Blocks.flowing_water);
            if (side == 1)
                world.setBlock(x, y + 1, z, Blocks.flowing_water);
            if (side == 0)
                itemStack.damageItem(-1, player);
    }
}
