package com.gentasaurus.arcanecraft.item;

import com.gentasaurus.arcanecraft.creativetab.CreativeTabAC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
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

    public static final String[] names = new String[] {"ignis", "aquam", "terra", "ventum", "tenebris", "lux", "immortui", "lava", "glaciem", "fulgura", "plantatio", "turbo", "tempore", "lunam", "corrupta", "ignotus"};

    public String getElementName(ItemStack itemStack)
    {
        String elementNameLC = (("" + StatCollector.translateToLocal(this.getUnlocalizedNameInefficiently(itemStack) + ".name")).trim()).replace("item.arcanecraft:arcaniumDust.", "").replace(".name", "");
        String elementName = WordUtils.capitalize(elementNameLC);
        return elementName;
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack)
    {
        String dustName = "Arcanium Dust" + " - ";
        return dustName + this.getElementName(itemStack);
    }

    public int getElementTier(ItemStack itemStack)
    {
        int damage = itemStack.getItemDamage();

        if(damage > -1 && damage < 6)
        {
            return 1;
        }
        if(damage > 5 && damage < 12)
        {
            return 2;
        }
        if(damage > 11)
        {
            return 3;
        }

        return 0;
    }

    public String getElementTranslation(ItemStack itemStack)
    {
        int damage = itemStack.getItemDamage();
        String elementType = this.getItemStackDisplayName(new ItemStack(this, 1, damage)).replace("Arcanium Dust - ", "");
        String prefix = "\u00a78" + "Aspect of ";

        if(elementType.matches("Ignis"))
        {
            return (prefix + "Fire");
        }

        if(elementType.matches("Aquam"))
        {
            return (prefix + "Water");
        }

        if(elementType.matches("Terra"))
        {
            return (prefix + "Earth");
        }

        if(elementType.matches("Ventum"))
        {
            return (prefix + "Air");
        }

        if(elementType.matches("Tenebris"))
        {
            return (prefix + "Darkness");
        }

        if(elementType.matches("Lux"))
        {
            return (prefix + "Light");
        }

        if(elementType.matches("Immortui"))
        {
            return (prefix + "Undead");
        }

        if(elementType.matches("Lava"))
        {
            return (prefix + "Lava");
        }

        if(elementType.matches("Glaciem"))
        {
            return (prefix + "Ice");
        }

        if(elementType.matches("Fulgura"))
        {
            return (prefix + "Storm");
        }

        if(elementType.matches("Plantatio"))
        {
            return (prefix + "Nature");
        }

        if(elementType.matches("Turbo"))
        {
            return (prefix + "Wind");
        }

        if(elementType.matches("Tempore"))
        {
            return (prefix + "Time");
        }

        if(elementType.matches("Lunam"))
        {
            return (prefix + "Moon");
        }


        if(elementType.matches("Corrupta"))
        {
            return (prefix + "Corruption");
        }


        if(elementType.matches("Ignotus"))
        {
            return (prefix + "\u00a7k" + "Unknown");
        }

        return ("\u00a74" + "No Translation");
    }

    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par2List, boolean par4)
    {

        String tier = "\u00a78" + "Tier " + this.getElementTier(par1ItemStack) + " Element";

        par2List.add(this.getElementTranslation(par1ItemStack));
        par2List.add(tier);

    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iconRegister)
    {
        icons = new IIcon[names.length];

        for (int i = 0; i < icons.length; i++)
        {
            icons[i] = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + this.getElementName(new ItemStack(this, 1, i)));
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
