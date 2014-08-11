package com.gentasaurus.arcanecraft.client.gui;

import com.gentasaurus.arcanecraft.inventory.ContainerArcaneOven;
import com.gentasaurus.arcanecraft.reference.Reference;
import com.gentasaurus.arcanecraft.tileentity.TileEntityArcaneOven;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiArcaneOven extends GuiContainer
{

    public static final ResourceLocation texture = new ResourceLocation(Reference.modid, "textures/gui/ArcaneOven.png");

    public TileEntityArcaneOven arcaneOven;

    public GuiArcaneOven(InventoryPlayer inventoryPlayer, TileEntityArcaneOven entity)
    {
        super(new ContainerArcaneOven(inventoryPlayer, entity));

        this.arcaneOven = entity;

        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    public void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        String name = "Arcane Oven";

        this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), this.xSize - (this.fontRendererObj.getStringWidth("Inventory") + 5), this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    {
        GL11.glColor4f(1F, 1F, 1F, 1F);

        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        if(this.arcaneOven.isBurning())
        {
            int srcX = xSize;
            int barHeight = this.arcaneOven.getBurnTimeRemainingScaled(38);
            int srcY = 38 - barHeight;
            drawTexturedModalRect(guiLeft + 11, guiTop + 16 + 38 - barHeight, srcX, srcY, 10, barHeight);
        }

        int k = this.arcaneOven.getCookProgressScaled(24);
        drawTexturedModalRect(guiLeft + 79, guiTop + 34, 176, 38, k + 1, 16);
    }
}
