package com.gentasaurus.arcanecraft.item;

import com.gentasaurus.arcanecraft.creativetab.CreativeTabAC;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemStaff extends ItemGeneric
{

    public ItemStaff()
    {
        super();
        this.setFull3D();
        this.setNoRepair();
        this.setMaxDamage(20);
        this.setHasSubtypes(true);
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabAC.tabArcaneCraft);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        if(!world.isRemote)
        {
            if(this.getDamage(itemStack) != 20)
            {
                this.activateStaff(itemStack, player, world, x, y, z, side, p_77648_8_, p_77648_9_, p_77648_10_);
                itemStack.damageItem(1, player);
            }
        }
        return false;
    }

    public void activateStaff(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {

    }
}
