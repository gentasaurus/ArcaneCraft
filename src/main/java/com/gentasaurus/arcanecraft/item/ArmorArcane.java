package com.gentasaurus.arcanecraft.item;


import com.gentasaurus.arcanecraft.creativetab.CreativeTabAC;
import com.gentasaurus.arcanecraft.init.ModItems;
import com.gentasaurus.arcanecraft.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ArmorArcane extends ItemArmor{

    private Object iconIndex;

    public ArmorArcane(ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
        super(par2EnumArmorMaterial, par3, par4);
        this.setCreativeTab(CreativeTabAC.tabArcaneCraft);
    }

    /**
     *  To Add Armor Texture to Player when worn.
     */
    @SideOnly(Side.CLIENT)
    public String getArmorTexture(ItemStack armor, Entity entity, int slot, String type)
    {
        if(armor.getItem() == ModItems.arcaneHelmet  || armor.getItem() == ModItems.arcaneChestplate || armor.getItem() == ModItems.arcaneBoots)
        {
            return "arcanecraft:textures/armor/arcane/arcane_1.png";
        }

        if(armor.getItem() == ModItems.arcaneLeggings)
        {
            return "arcanecraft:textures/armor/arcane/arcane_2.png";
        }

        else return null;
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Reference.resourcePrefix, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", Reference.resourcePrefix, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        if(!itemStack.isItemEnchanted())
        {
            if(itemStack.getItem() == ModItems.arcaneLeggings)
            {
                itemStack.addEnchantment(Enchantment.fireProtection, 4);
            }

            if(itemStack.getItem() == ModItems.arcaneBoots)
            {
                itemStack.addEnchantment(Enchantment.featherFalling, 4);
            }

            if(itemStack.getItem() == ModItems.arcaneChestplate)
            {
                itemStack.addEnchantment(Enchantment.thorns, 3);
            }

            if(itemStack.getItem() == ModItems.arcaneHelmet)
            {
                itemStack.addEnchantment(Enchantment.blastProtection, 4);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par2List, boolean par4)
    {
        if(par1ItemStack.isItemEnchanted())
        {
            String prefix = "\u00A7e";
            par2List.add(prefix + "ACTIVATED");
        }
        else
        {
            String prefix = "\u00A78";
            par2List.add(prefix + "Currently not activated.");
            par2List.add(prefix + "Equip to activate.");
        }
    }

}

