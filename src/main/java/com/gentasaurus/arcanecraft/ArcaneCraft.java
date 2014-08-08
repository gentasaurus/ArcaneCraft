package com.gentasaurus.arcanecraft;

import com.gentasaurus.arcanecraft.init.ModBlocks;
import com.gentasaurus.arcanecraft.init.ModItems;
import com.gentasaurus.arcanecraft.init.Recipes;
import com.gentasaurus.arcanecraft.proxy.CommonProxy;
import com.gentasaurus.arcanecraft.reference.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid= Reference.modid, name=Reference.modname, version=Reference.version)
public class ArcaneCraft
{
    @Mod.Instance(Reference.modid)
    public static ArcaneCraft instance;

    @SidedProxy(clientSide = Reference.clientProxyClass, serverSide = Reference.serverProxyClass)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ModBlocks.init();
        ModItems.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        Recipes.init();
        proxy.registerStuff();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
