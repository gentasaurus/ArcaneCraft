package com.gentasaurus.arcanecraft.item;

import com.gentasaurus.arcanecraft.creativetab.CreativeTabAC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

import java.util.List;

public class ItemArcaniumDust extends ItemGeneric
{
    public ItemArcaniumDust()
    {
        super();
        setUnlocalizedName("arcaniumDust");
        this.setHasSubtypes(true);
        this.setCreativeTab(CreativeTabAC.tabArcaneCraft);
    }

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public static final String[] names = new String[] { "raw", "red", "orange", "yellow", "green", "cyan", "blue", "purple", "pink"};

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iconRegister)
    {
        icons = new IIcon[10];

        for (int i = 0; i < icons.length; i++)
        {
            icons[i] = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + i);
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
        return super.getUnlocalizedName() + "." + names[i];
    }

    @Override
    public IIcon getIconFromDamage(int par1)
    {
        return icons[par1];
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int x = 0; x < 9; x++)
        {
            par3List.add(new ItemStack(this, 1, x));
        }
    }}
