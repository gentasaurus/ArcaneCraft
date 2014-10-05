package com.gentasaurus.arcanecraft.item;

import com.gentasaurus.arcanecraft.util.ACTextFormat;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

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
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_) {

        if( itemStack.stackTagCompound == null )
            itemStack.setTagCompound( new NBTTagCompound( ) );
        int dimension = itemStack.stackTagCompound.getInteger("Dimension");
        double markedX = itemStack.stackTagCompound.getDouble("MarkedX");
        double markedY = itemStack.stackTagCompound.getDouble("MarkedY");
        double markedZ = itemStack.stackTagCompound.getDouble("MarkedZ");

        if(markedX == 0.0 && markedY == 0.0 && markedZ == 0.0)
        {
            int preD = dimension;
            double preX = markedX;
            double preY = markedY;
            double preZ = markedZ;

            dimension = player.dimension;
            markedX = x + 0.5;
            markedY = y + 2.5;
            markedZ = z + 0.5;
            if(markedY < 10)
            {
                this.sendPlayerMessage(ACTextFormat.LIGHT_RED, ACTextFormat.localize("mirror.tooDeep"), player, world);
                dimension = preD;
                markedX = preX;
                markedY = preY;
                markedZ = preZ;
            }
            else
            {
                this.sendPlayerMessage(ACTextFormat.LIGHT_GREEN, ACTextFormat.localize("mirror.marked"), player, world);
                world.playSoundAtEntity(player, "random.successful_hit", 1.0F, 1.0F);
            }

        }
        else
        {
            this.sendPlayerMessage(ACTextFormat.LIGHT_RED, ACTextFormat.localize("mirror.alreadyMarked"), player, world);
            this.sendPlayerMessage(ACTextFormat.LIGHT_RED, ACTextFormat.localize("mirror.resetInstructions"), player, world);
        }


        itemStack.stackTagCompound.setInteger("Dimension", dimension);
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
        int dimension = itemStack.stackTagCompound.getInteger("Dimension");
        double markedX = itemStack.stackTagCompound.getDouble("MarkedX");
        double markedY = itemStack.stackTagCompound.getDouble("MarkedY");
        double markedZ = itemStack.stackTagCompound.getDouble("MarkedZ");

        if(player.isSneaking())
        {
            dimension = 0;
            markedX = 0.0;
            markedY = 0.0;
            markedZ = 0.0;
            this.sendPlayerMessage(ACTextFormat.WHITE, ACTextFormat.localize("mirror.resetSuccessful"), player, world);
            world.playSoundAtEntity(player, "random.pop", 1.0F, 1.0F);
        }
        else
        {
            if(markedX !=  0.0 && markedY != 0.0 && markedZ != 0.0)
            {
                this.sendPlayerMessage(ACTextFormat.LIGHT_GREEN, ACTextFormat.localize("mirror.warping"), player, world);
                if(player.dimension != dimension)
                {
                    player.travelToDimension(dimension);
                }
                player.setPositionAndUpdate(markedX, markedY - 1.5, markedZ);
                for (int i = 0; i < 128; ++i)
                {
                    Random rand = new Random();
                    world.spawnParticle("portal", player.posX - 1 + rand.nextDouble() * 2.0, player.posY - 1.5 + rand.nextDouble() * 2.0D, player.posZ - 1 + rand.nextDouble() * 2.0, 0, 0, 0);
                }
                world.playSoundAtEntity(player, "mob.endermen.portal", 1.0F, 1.0F);

            }
            else
            {
                this.sendPlayerMessage(ACTextFormat.LIGHT_RED, ACTextFormat.localize("mirror.noMarkWarp"), player, world);
            }

        }


        itemStack.stackTagCompound.setInteger("Dimension", dimension);
        itemStack.stackTagCompound.setDouble("MarkedX", markedX);
        itemStack.stackTagCompound.setDouble("MarkedY", markedY);
        itemStack.stackTagCompound.setDouble("MarkedZ", markedZ);
        return itemStack;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par2List, boolean par4)
    {
        if( par1ItemStack.stackTagCompound == null )
            par1ItemStack.setTagCompound( new NBTTagCompound( ) );
        int dimension = par1ItemStack.stackTagCompound.getInteger("Dimension");
        int markedX = (int)par1ItemStack.stackTagCompound.getDouble("MarkedX");
        int markedY = (int)par1ItemStack.stackTagCompound.getDouble("MarkedY");
        int markedZ = (int)par1ItemStack.stackTagCompound.getDouble("MarkedZ");

        if(markedX == 0 && markedY == 0 && markedZ == 0)
        {
            par2List.add(ACTextFormat.localize("mirror.noMark"));
        }
        else
        {
            par2List.add(ACTextFormat.localize("mirror.marked"));
            if(!isShiftKeyDown())
            {
                par2List.add(ACTextFormat.localize("mirror.showCoords"));
            }
            else
            {
                par2List.add(ACTextFormat.localize("dimension") + " " + dimension);
                par2List.add("X: " + markedX);
                par2List.add("Y: " + (markedY - 1));
                par2List.add("Z: " + markedZ);
            }
        }


    }

}
