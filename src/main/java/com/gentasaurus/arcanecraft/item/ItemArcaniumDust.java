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
import net.minecraft.util.StatCollector;
import org.apache.commons.lang3.text.WordUtils;

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

    public static final String[] names = new String[] {"ignis", "aquam", "terra", "ventum", "tenebris", "lux", "immortui"};

    @Override
    public String getItemStackDisplayName(ItemStack p_77653_1_)
    {
        String dustName = "Arcanium Dust" + " - ";
        String elementName = (("" + StatCollector.translateToLocal(this.getUnlocalizedNameInefficiently(p_77653_1_) + ".name")).trim()).replace("item.arcanecraft:arcaniumDust.", "").replace(".name", "");
        return dustName + WordUtils.capitalize(elementName);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iconRegister)
    {
        icons = new IIcon[names.length];

        for (int i = 0; i < icons.length; i++)
        {
            icons[i] = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + (this.getItemStackDisplayName(new ItemStack(this, 1, i))).replace("Arcanium Dust - ", ""));
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
        for (int x = 0; x < names.length; x++)
        {
            par3List.add(new ItemStack(this, 1, x));
        }
    }}
