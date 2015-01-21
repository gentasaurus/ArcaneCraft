package com.gentasaurus.arcanecraft.handler;

import com.gentasaurus.arcanecraft.init.Achievements;
import com.gentasaurus.arcanecraft.init.ModItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;

import java.util.Random;

public class ArcaneEventHandler
{

    private Random random = new Random();

    @SubscribeEvent
    public void onLivingDropsEvent(LivingDropsEvent event)
    {
        if(event.entityLiving == null || event.entityLiving instanceof EntityPlayer)
            return;

        if (event.recentlyHit)
        {
            if (event.source.damageType.equals("player"))
            {
                EntityPlayer player = (EntityPlayer) event.source.getEntity();
                ItemStack stack = player.getCurrentEquippedItem();

                if(stack != null && stack.getItem() == ModItems.soulAxe)
                {
                    float dropChance = random.nextFloat();
                    if(dropChance <= 0.5F)
                    {
                        event.entityLiving.dropItem(ModItems.enemySoul, 1);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onLivingUpdateEvent(LivingEvent.LivingUpdateEvent event)
    {
        if(event.entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) event.entity;

            int coordX = MathHelper.floor_double(player.posX);
            int coordZ = MathHelper.floor_double(player.posZ);
            World world = player.worldObj;
            Chunk chunk = world.getChunkFromBlockCoords(coordX, coordZ);
            String playerBiomeName = chunk.getBiomeGenForWorldCoords(coordX & 15, coordZ & 15, world.getWorldChunkManager()).biomeName;

            if(playerBiomeName.startsWith("Dark Swamp"))
            {
                player.addStat(Achievements.achievementDarkSwamp, 1);
            }
        }
    }

}
