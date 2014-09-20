package com.gentasaurus.arcanecraft;

import com.gentasaurus.arcanecraft.handler.ArcaneFuelHandler;
import com.gentasaurus.arcanecraft.handler.GuiHandler;
import com.gentasaurus.arcanecraft.init.*;
import com.gentasaurus.arcanecraft.proxy.CommonProxy;
import com.gentasaurus.arcanecraft.reference.Reference;
import com.gentasaurus.arcanecraft.tileentity.TileEntityArcaneOven;
import com.gentasaurus.arcanecraft.tileentity.TileEntityInfuser;
import com.gentasaurus.arcanecraft.world.WorldGenArcane;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid= Reference.modid, name=Reference.modname, version=Reference.version)
public class ArcaneCraft
{

    public static final int guiIDArcaneOven = 0;
    public static final int guiIDArcaneInfuser = 1;

    @Mod.Instance(Reference.modid)
    public static ArcaneCraft instance;

    @SidedProxy(clientSide = Reference.clientProxyClass, serverSide = Reference.serverProxyClass)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        CoreDusts.init();
        ModBlocks.init();
        ModItems.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        Recipes.init();
        InfuserRecipes.init();
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        GameRegistry.registerFuelHandler(new ArcaneFuelHandler());
        GameRegistry.registerWorldGenerator(new WorldGenArcane(), 0);
        GameRegistry.registerTileEntity(TileEntityArcaneOven.class, "ArcaneOven");
        GameRegistry.registerTileEntity(TileEntityInfuser.class, "ArcaneInfuser");
        proxy.registerStuff();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
