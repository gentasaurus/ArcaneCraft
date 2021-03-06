package com.gentasaurus.arcanecraft.init;

import com.gentasaurus.arcanecraft.item.*;
import com.gentasaurus.arcanecraft.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

@GameRegistry.ObjectHolder(Reference.modid)
public class ModItems
{
    static ItemArmor.ArmorMaterial arcane = EnumHelper.addArmorMaterial("arcane", 750, new int[]{3, 8, 3, 2}, 0);
    static Item.ToolMaterial lightning = EnumHelper.addToolMaterial("lightning", 3, 1561, 14F, 0F, 10);
    static Item.ToolMaterial soul_axe = EnumHelper.addToolMaterial("soul_axe", 1, 30, 2F, 10F - 4, 5);

    //Armor
    public static Item arcaneHelmet = new ArmorArcane(arcane, 3, 0).setUnlocalizedName("arcaneHelmet");
    public static Item arcaneChestplate = new ArmorArcane(arcane, 3, 1).setUnlocalizedName("arcaneChestplate");
    public static Item arcaneLeggings = new ArmorArcane(arcane, 3, 2).setUnlocalizedName("arcaneLeggings");
    public static Item arcaneBoots = new ArmorArcane(arcane, 3, 3).setUnlocalizedName("arcaneBoots");
    //
    public static final Item arcaniumDustRaw = new ItemGeneric().setUnlocalizedName("arcaniumDustRaw");
    public static final Item arcaniumDust = new ItemArcaniumDust();
    public static final Item arcaneFuel = new ItemGeneric().setUnlocalizedName("arcaneFuel");
    //
    public static final Item waterStaff = new ItemWaterStaff().setUnlocalizedName("waterStaff");
    public static final Item lavaStaff = new ItemLavaStaff().setUnlocalizedName("lavaStaff");
    public static final Item undeadStaff = new ItemUndeadStaff().setUnlocalizedName("undeadStaff");
    public static final Item enderStaff = new ItemEnderStaff().setUnlocalizedName("enderStaff");
    //
    public static final Item arcaneMirror = new ItemArcaneMirror().setUnlocalizedName("arcaneMirror");
    public static final Item arcaneWrench = new ItemArcaneWrench().setUnlocalizedName("arcaneWrench");
    //
    public static final Item reinforcedStick = new ItemGeneric().setFull3D().setUnlocalizedName("reinforcedStick");
    public static final Item armorStructure = new ItemGeneric().setUnlocalizedName("armorStructure");
    public static final Item arcaneConduit = new ItemGeneric().setUnlocalizedName("arcaneConduit");
    public static final Item crystalPearl = new ItemGeneric().setUnlocalizedName("crystalPearl");
    public static final Item enemySoul = new ItemGeneric().setUnlocalizedName("enemySoul");
    public static final Item soulCrystal = new ItemSoulCrystal().setUnlocalizedName("soulCrystal");
    //
    public static final Item lightningPickaxe = new ItemPickaxeBasic(lightning).setUnlocalizedName("lightningPickaxe");
    public static final Item soulAxe = new ItemSwordBasic(soul_axe).setUnlocalizedName("soulAxe");

    public static void init()
    {
        GameRegistry.registerItem(arcaneHelmet, "arcaneHelmet");
        GameRegistry.registerItem(arcaneChestplate, "arcaneChestplate");
        GameRegistry.registerItem(arcaneLeggings, "arcaneLeggings");
        GameRegistry.registerItem(arcaneBoots, "arcaneBoots");
        //
        GameRegistry.registerItem(arcaniumDustRaw, "arcaniumDustRaw");
        GameRegistry.registerItem(arcaniumDust, "arcaniumDust");
        GameRegistry.registerItem(arcaneFuel, "arcaneFuel");
        //
        GameRegistry.registerItem(waterStaff, "waterStaff");
        GameRegistry.registerItem(lavaStaff, "lavaStaff");
        GameRegistry.registerItem(undeadStaff, "undeadStaff");
        GameRegistry.registerItem(enderStaff, "enderStaff");
        //
        GameRegistry.registerItem(arcaneMirror, "arcaneMirror");
        GameRegistry.registerItem(arcaneWrench, "arcaneWrench");
        //
        GameRegistry.registerItem(reinforcedStick, "reinforcedStick");
        GameRegistry.registerItem(armorStructure, "armorStructure");
        GameRegistry.registerItem(arcaneConduit, "arcaneConduit");
        GameRegistry.registerItem(crystalPearl, "crystalPearl");
        GameRegistry.registerItem(enemySoul, "enemySoul");
        GameRegistry.registerItem(soulCrystal, "soulCrystal");
        //
        GameRegistry.registerItem(lightningPickaxe, "lightningPickaxe");
        GameRegistry.registerItem(soulAxe, "soulAxe");
    }
}
