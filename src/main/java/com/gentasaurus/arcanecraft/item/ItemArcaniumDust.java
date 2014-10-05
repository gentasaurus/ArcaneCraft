package com.gentasaurus.arcanecraft.item;

import com.gentasaurus.arcanecraft.creativetab.CreativeTabAC;
import com.gentasaurus.arcanecraft.util.ACTextFormat;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import org.apache.commons.lang3.text.WordUtils;

import java.util.ArrayList;
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

    public static final ArrayList<String> elements = new ArrayList<String>();
    public static void addElement(String elementName)
    {
        elements.add(elementName);
    }

    public String getElementName(ItemStack itemStack)
    {
        String elementName = ("" + StatCollector.translateToLocal(this.getUnlocalizedNameInefficiently(itemStack) + ".name")).trim().replace("item.arcanecraft:arcaniumDust.", "").replace(".name", "");
        return WordUtils.capitalize(elementName);
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack)
    {
        String dustName = ACTextFormat.localize("dust.name") + " - ";
        return dustName + getElementName(itemStack);
    }

    public String getElementTranslation(ItemStack itemStack)
    {
        int damage = itemStack.getItemDamage();
        String elementType = this.getItemStackDisplayName(new ItemStack(this, 1, damage)).replace(ACTextFormat.localize("dust.name") + " - ", "");
        String prefix = "\u00a78" + ACTextFormat.localize("dust.element") +  " ";
        String elementTranslation = StatCollector.translateToLocal("elements.arcanecraft" + "." + elementType.toLowerCase());

        return prefix + elementTranslation;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par2List, boolean par4)
    {

        par2List.add(this.getElementTranslation(par1ItemStack));
        if(par1ItemStack.getItemDamage() < 6)
        {
            par2List.add("\u00a78" + ACTextFormat.localize("dust.primal"));
        }
        else
        {
            par2List.add("\u00a78" + ACTextFormat.localize("dust.complex"));
        }

    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iconRegister)
    {
        icons = new IIcon[elements.size()];

        for (int i = 0; i < icons.length; i++)
        {
            String textureName = (this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + this.getElementName(new ItemStack(this, 1, i))).replace("arcaniumDust", "dust/arcaniumDust");
            icons[i] = iconRegister.registerIcon(textureName);
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, elements.size());
        String[] elementArray = new String[elements.size()];
        elementArray = elements.toArray(elementArray);
        return super.getUnlocalizedName() + "." + elementArray[i];
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
        for (int x = 0; x < elements.size(); x++)
        {
            par3List.add(new ItemStack(this, 1, x));
        }
    }}
