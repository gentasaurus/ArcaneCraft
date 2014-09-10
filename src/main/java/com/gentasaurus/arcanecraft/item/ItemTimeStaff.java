package com.gentasaurus.arcanecraft.item;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class ItemTimeStaff extends ItemStaff
{

    public ItemTimeStaff()
    {
        super();
        this.setMaxDamage(5);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if(!world.isRemote)
        {
            if(this.getDamage(itemStack) != 5)
            {
                this.addTime(14000);
                player.heal(-10);
                itemStack.damageItem(1, player);
            }
        }
        return itemStack;
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        return false;
    }

    protected void addTime(int p_71553_2_)
    {
        for (int j = 0; j < MinecraftServer.getServer().worldServers.length; ++j)
        {
            WorldServer worldserver = MinecraftServer.getServer().worldServers[j];
            worldserver.setWorldTime(worldserver.getWorldTime() + (long)p_71553_2_);
        }
    }
}
