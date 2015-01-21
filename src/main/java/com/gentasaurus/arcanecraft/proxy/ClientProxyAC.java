package com.gentasaurus.arcanecraft.proxy;

import com.gentasaurus.arcanecraft.entity.EntityStaffPearl;
import com.gentasaurus.arcanecraft.init.ModItems;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.init.Items;

public class ClientProxyAC extends CommonProxyAC
{
    public void registerStuff()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityStaffPearl.class, new RenderSnowball(ModItems.enemySoul));
    }
}
