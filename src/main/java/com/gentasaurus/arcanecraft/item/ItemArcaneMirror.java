package com.gentasaurus.arcanecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.List;

public class ItemArcaneMirror extends ItemGeneric
{

    public ItemArcaneMirror()
    {
        super();
        this.setMaxStackSize(1);
    }
    @Override
    public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if( par1ItemStack.stackTagCompound == null )
            par1ItemStack.setTagCompound( new NBTTagCompound( ) );

        par1ItemStack.stackTagCompound.setDouble("MarkedX", 0.0);
        par1ItemStack.stackTagCompound.setDouble("MarkedY", 0.0);
        par1ItemStack.stackTagCompound.setDouble("MarkedZ", 0.0);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_) {

        if( itemStack.stackTagCompound == null )
            itemStack.setTagCompound( new NBTTagCompound( ) );
        double markedX = itemStack.stackTagCompound.getDouble("MarkedX");
        double markedY = itemStack.stackTagCompound.getDouble("MarkedY");
        double markedZ = itemStack.stackTagCompound.getDouble("MarkedZ");

        if(markedX == 0.0 && markedY == 0.0 && markedZ == 0.0)
        {
            double preX = markedX;
            double preY = markedY;
            double preZ = markedZ;

            markedX = x + 0.5;
            markedY = y + 2.5;
            markedZ = z + 0.5;
            if(markedY < 10)
            {
                this.sendPlayerMessage("c", "Failed to mark: destination is too deep.", player, world);
                markedX = preX;
                markedY = preY;
                markedZ = preZ;
            }
            else
            {
                if(player.dimension != 0)
                {
                    this.sendPlayerMessage("c", "Failed to mark: must be in the Overworld.", player, world);
                    markedX = preX;
                    markedY = preY;
                    markedZ = preZ;
                }
                else
                {
                    this.sendPlayerMessage("a", "Destination marked.", player, world);
                }

            }

        }
        else
        {
            this.sendPlayerMessage("c", "Failed to mark: destination already marked.", player, world);
            this.sendPlayerMessage("c", "Shift-Click in the air to reset.", player, world);
        }


        itemStack.stackTagCompound.setDouble("MarkedX", markedX);
        itemStack.stackTagCompound.setDouble("MarkedY", markedY);
        itemStack.stackTagCompound.setDouble("MarkedZ", markedZ);
        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        if( itemStack.stackTagCompound == null )
            itemStack.setTagCompound( new NBTTagCompound( ) );
        double markedX = itemStack.stackTagCompound.getDouble("MarkedX");
        double markedY = itemStack.stackTagCompound.getDouble("MarkedY");
        double markedZ = itemStack.stackTagCompound.getDouble("MarkedZ");

        if(player.isSneaking())
        {
            markedX = 0.0;
            markedY = 0.0;
            markedZ = 0.0;
            this.sendPlayerMessage("f", "Destination reset.", player, world);
        }
        else
        {
            if(markedX !=  0.0 && markedY != 0.0 && markedZ != 0.0)
            {
                if(player.dimension == 0)
                {
                    this.sendPlayerMessage("a", "Warping...", player, world);
                    player.setPositionAndUpdate(markedX, markedY - 1.5, markedZ);
                    world.playSoundAtEntity(player, "mob.endermen.portal", 1.0F, 1.0F);
                }
                else
                {
                    this.sendPlayerMessage("c", "Failed to warp: must be in the Overworld.", player, world);
                }

            }
            else
            {
                this.sendPlayerMessage("c", "Failed to warp: No destination marked.", player, world);
            }

        }


        itemStack.stackTagCompound.setDouble("MarkedX", markedX);
        itemStack.stackTagCompound.setDouble("MarkedY", markedY);
        itemStack.stackTagCompound.setDouble("MarkedZ", markedZ);
        return itemStack;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par2List, boolean par4)
    {
        if( par1ItemStack.stackTagCompound == null )
            par1ItemStack.setTagCompound( new NBTTagCompound( ) );
        int markedX = (int)par1ItemStack.stackTagCompound.getDouble("MarkedX");
        int markedY = (int)par1ItemStack.stackTagCompound.getDouble("MarkedY");
        int markedZ = (int)par1ItemStack.stackTagCompound.getDouble("MarkedZ");

        if(markedX == 0 && markedY == 0 && markedZ == 0)
        {
            par2List.add("No destination marked.");
        }
        else
        {
            par2List.add("Destination marked.");
            par2List.add("X = " + markedX);
            par2List.add("Y = " + markedY);
            par2List.add("Z = " + markedZ);
        }


    }

}
