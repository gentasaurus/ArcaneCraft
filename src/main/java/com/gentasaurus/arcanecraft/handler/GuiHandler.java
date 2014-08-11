package com.gentasaurus.arcanecraft.handler;

import com.gentasaurus.arcanecraft.ArcaneCraft;
import com.gentasaurus.arcanecraft.client.gui.GuiArcaneOven;
import com.gentasaurus.arcanecraft.inventory.ContainerArcaneOven;
import com.gentasaurus.arcanecraft.tileentity.TileEntityArcaneOven;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity entity = world.getTileEntity(x, y, z);

        if(entity != null)
        {
            switch(ID)
            {
                case ArcaneCraft.guiIDArcaneOven:
                    if(entity instanceof TileEntityArcaneOven)
                    {
                        return new ContainerArcaneOven(player.inventory, (TileEntityArcaneOven) entity);
                    }
                    return null;
            }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity entity = world.getTileEntity(x, y, z);

        if(entity != null)
        {
            switch(ID)
            {
                case ArcaneCraft.guiIDArcaneOven:
                    if(entity instanceof TileEntityArcaneOven)
                    {
                        return new GuiArcaneOven(player.inventory, (TileEntityArcaneOven) entity);
                    }
                    return null;
            }
        }
        return null;
    }
}
