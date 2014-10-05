package com.gentasaurus.arcanecraft.item;

import com.gentasaurus.arcanecraft.entity.EntityStaffPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemEnderStaff extends ItemStaff
{

    public ItemEnderStaff()
    {
        super();
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if(!world.isRemote)
        {
            if(this.getDamage(itemStack) != this.getMaxDamage())
            {
                if (!world.isRemote)
                {
                    world.playSoundAtEntity(player, "random.pop", 1.0F, 0.4F);
                    world.spawnEntityInWorld(new EntityStaffPearl(world, player));
                    itemStack.damageItem(1, player);
                }
            }
        }
        return itemStack;
    }


}
