package com.gentasaurus.arcanecraft.inventory;

import com.gentasaurus.arcanecraft.init.ModItems;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotDust extends Slot {
    public SlotDust(IInventory inventory, int par2, int par3, int par4) {
        super(inventory, par2, par3, par4);
    }

    @Override
    public boolean isItemValid(ItemStack itemStack)
    {
        if(itemStack.getItem() == ModItems.arcaniumDustRaw)
        {
            return true;
        }

        if(itemStack.getItem() == ModItems.arcaniumDust)
        {
            return true;
        }

        return false;
    }

    @Override
    public int getSlotStackLimit() {
        return 64;
    }


}