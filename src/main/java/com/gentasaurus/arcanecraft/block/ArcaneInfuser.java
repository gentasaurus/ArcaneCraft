package com.gentasaurus.arcanecraft.block;

import com.gentasaurus.arcanecraft.ArcaneCraft;
import com.gentasaurus.arcanecraft.creativetab.CreativeTabAC;
import com.gentasaurus.arcanecraft.reference.Reference;
import com.gentasaurus.arcanecraft.tileentity.TileEntityArcaneOven;
import com.gentasaurus.arcanecraft.tileentity.TileEntityInfuser;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ArcaneInfuser extends BlockContainer
{

    public ArcaneInfuser()
    {
        super(Material.rock);
        this.setCreativeTab(CreativeTabAC.tabArcaneCraft);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
        return new TileEntityInfuser();
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.resourcePrefix, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @SideOnly(Side.CLIENT)
    private IIcon iconTop;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(Reference.resourcePrefix + "arcaneInfuser_side");
        iconTop = iconRegister.registerIcon(Reference.resourcePrefix + "arcaneInfuser_top");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        if (side == 1) {
            return iconTop;
        } else {
            return blockIcon;
        }
    }

    public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer player, int var6, float var7, float var8, float var9)
    {
        if (!player.isSneaking())
        {
            player.openGui(ArcaneCraft.instance, ArcaneCraft.guiIDArcaneInfuser, var1, var2, var3, var4);
            return true;
        }
        else
        {
            return false;
        }
    }

}
