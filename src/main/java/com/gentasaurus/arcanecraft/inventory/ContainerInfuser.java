package com.gentasaurus.arcanecraft.inventory;

import com.gentasaurus.arcanecraft.init.ModBlocks;
import com.gentasaurus.arcanecraft.item.crafting.InfuserCraftingManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerInfuser extends Container
{
    public InventoryCrafting craftMatrix;
    public IInventory craftResult;
    private World worldObj;
    private int posX;
    private int posY;
    private int posZ;

    public ContainerInfuser(InventoryPlayer invPlayer, World world, int x, int y, int z)
    {
        craftMatrix = new InventoryCrafting(this, 3, 1);
        craftResult = new InventoryCraftResult();
        worldObj = world;
        posX = x;
        posY = y;
        posZ = z;
        this.addSlotToContainer(new SlotInfuser(invPlayer.player, craftMatrix, craftResult, 0, 80, 36));
        int i;
        int i1;

        this.addSlotToContainer(new SlotDust(this.craftMatrix, 0, 54, 60));
        this.addSlotToContainer(new SlotDust(this.craftMatrix, 1, 106, 60));
        this.addSlotToContainer(new Slot(this.craftMatrix, 2, 80, 8));


        for (i = 0; i < 3; ++i)
        {
            for (i1 = 0; i1 < 9; ++i1)
            {
                this.addSlotToContainer(new Slot(invPlayer, i1 + i * 9 + 9, 8 + i1 * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 142));
        }

        this.onCraftMatrixChanged(craftMatrix);
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    public void onCraftMatrixChanged(IInventory p_75130_1_)
    {
        craftResult.setInventorySlotContents(0, InfuserCraftingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj));
    }

    /**
     * Called when the container is closed.
     */
    public void onContainerClosed(EntityPlayer p_75134_1_)
    {
        super.onContainerClosed(p_75134_1_);

        if (!this.worldObj.isRemote)
        {
            for (int i = 0; i < 3; ++i)
            {
                ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

                if (itemstack != null)
                {
                    p_75134_1_.dropPlayerItemWithRandomChoice(itemstack, false);
                }
            }
        }
    }

    public boolean canInteractWith(EntityPlayer p_75145_1_)
    {
        return this.worldObj.getBlock(this.posX, this.posY, this.posZ) != ModBlocks.arcaneInfuser ? false : p_75145_1_.getDistanceSq((double)this.posX + 0.5D, (double)this.posY + 0.5D, (double)this.posZ + 0.5D) <= 64.0D;
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
    {
        return null;
    }

    public boolean func_94530_a(ItemStack p_94530_1_, Slot p_94530_2_)
    {
        return p_94530_2_.inventory != this.craftResult && super.func_94530_a(p_94530_1_, p_94530_2_);
    }
}