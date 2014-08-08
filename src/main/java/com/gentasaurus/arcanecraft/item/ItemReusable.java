package com.gentasaurus.arcanecraft.item;

import net.minecraft.item.ItemStack;

public class ItemReusable extends ItemGeneric
{
    public ItemReusable()
    {
        super();
        setMaxStackSize(1);
        setNoRepair();
        setMaxDamage(20);
    }

    public boolean hasContainerItem(ItemStack itemStack)
    {
        return true;
    }
    @Override
    public ItemStack getContainerItem(ItemStack itemStack)
    {
        ItemStack stack = itemStack.copy();

        stack.setItemDamage(stack.getItemDamage() + 1);
        stack.stackSize = 1;

        return stack;
    }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack)
    {
        return false;
    }

}
