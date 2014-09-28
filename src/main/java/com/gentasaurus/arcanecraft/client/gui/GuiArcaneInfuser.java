package com.gentasaurus.arcanecraft.client.gui;

import com.gentasaurus.arcanecraft.inventory.ContainerInfuser;
import com.gentasaurus.arcanecraft.reference.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.Random;

public class GuiArcaneInfuser extends GuiContainer
{
    private static final ResourceLocation textureSC =  new ResourceLocation(Reference.modid.toLowerCase(), "textures/gui/ArcaneInfuser.png");

    public GuiArcaneInfuser(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5)
    {
        super(new ContainerInfuser(par1InventoryPlayer, par2World, par3, par4, par5));
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {


        this.fontRendererObj.drawString("Arcane", 6, 6, 0xEDEDED);
        this.fontRendererObj.drawString("Infuser", 6, 15, 0xEDEDED);
    }



    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(textureSC);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }
}
