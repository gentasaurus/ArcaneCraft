package com.gentasaurus.arcanecraft;

import com.gentasaurus.arcanecraft.entity.EntityStaffPearl;
import com.gentasaurus.arcanecraft.handler.ArcaneEventHandler;
import com.gentasaurus.arcanecraft.handler.ArcaneFuelHandler;
import com.gentasaurus.arcanecraft.handler.GuiHandler;
import com.gentasaurus.arcanecraft.init.*;
import com.gentasaurus.arcanecraft.proxy.CommonProxyAC;
import com.gentasaurus.arcanecraft.reference.Reference;
import com.gentasaurus.arcanecraft.tileentity.TileEntityArcaneOven;
import com.gentasaurus.arcanecraft.tileentity.TileEntityInfuser;
import com.gentasaurus.arcanecraft.world.BiomesAC;
import com.gentasaurus.arcanecraft.world.WorldGenArcane;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid=Reference.modid, name=Reference.modname, version=Reference.version)
public class ArcaneCraft
{

    public static final int guiIDArcaneOven = 0;
    public static final int guiIDArcaneInfuser = 1;

    @Mod.Instance(Reference.modid)
    public static ArcaneCraft instance;

    @SidedProxy(clientSide = Reference.clientProxyClass, serverSide = Reference.serverProxyClass)
    public static CommonProxyAC proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        int acEntityID = 0;

        CoreDusts.init();
        ModBlocks.init();
        ModItems.init();
        BiomesAC.init();
        EntityRegistry.registerModEntity(EntityStaffPearl.class, "Staff Pearl", ++acEntityID, this, 64, 10, true);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        Recipes.init();
        InfuserRecipes.init();
        Achievements.init();
        MinecraftForge.EVENT_BUS.register(new ArcaneEventHandler());
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
