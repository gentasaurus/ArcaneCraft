package com.gentasaurus.arcanecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSoulCrystal extends ItemGeneric
{

    public ItemSoulCrystal()
    {
        super();
        this.setMaxDamage(6);
        this.setMaxStackSize(1);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        if(itemStack.getItemDamage() != itemStack.getMaxDamage())
        {
            if(player.getHealth() < 20)
            {
                itemStack.damageItem(1, player);
                world.playSoundAtEntity(player, "dig.glass", 1.0F, 1.0F);
                player.heal(10);
            }
        }

        return itemStack;
    }

}
