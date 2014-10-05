package com.gentasaurus.arcanecraft.item;

import com.gentasaurus.arcanecraft.creativetab.CreativeTabAC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ItemStaff extends ItemGeneric
{

    public ItemStaff()
    {
        super();
        this.setFull3D();
        this.setNoRepair();
        this.setMaxDamage(20);
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabAC.tabArcaneCraft);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        if(!world.isRemote)
        {
            if(this.getDamage(itemStack) != this.getMaxDamage())
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

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par2List, boolean par4)
    {
        int usesLeft = this.getMaxDamage(par1ItemStack) - this.getDamage(par1ItemStack);
        String prefix = "";
        if(usesLeft > 10)
            prefix = "\u00A7a";
        if(usesLeft <= 10 && usesLeft > 5)
            prefix = "\u00A76";
        if(usesLeft <= 5)
            prefix = "\u00A74";
        if(usesLeft == 0)
            prefix = "\u00A78";

        if(usesLeft == 0)
        {
            par2List.add(prefix + "No uses left");
        }
        else
        {
            par2List.add(prefix + usesLeft + " uses left");
        }
    }
}
