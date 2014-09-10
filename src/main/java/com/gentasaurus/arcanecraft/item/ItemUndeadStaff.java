package com.gentasaurus.arcanecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemUndeadStaff extends ItemStaff
{

    public ItemUndeadStaff()
    {
        super();
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if(!world.isRemote)
        {
            if(this.getDamage(itemStack) != 20)
            {
                if (!world.isRemote)
                {
                    world.spawnEntityInWorld(new EntityPotion(world, player, new ItemStack(Items.potionitem, 1, 16484)));
                    itemStack.damageItem(1, player);
                }
            }
        }
        return itemStack;
    }
}
