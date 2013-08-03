package mods.aginsun.worldscroller.client;

import mods.aginsun.worldscroller.common.ContainerHotBars;
import mods.aginsun.worldscroller.common.TileEntityWorldScroller;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiScreenHotBars extends GuiContainer
{
	//TODO: Fancy this up.
	
	private static ContainerHotBars container;
	
	public GuiScreenHotBars(InventoryPlayer player_inventory, TileEntityWorldScroller worldScroller) 
	{
		super(container = new ContainerHotBars(player_inventory, worldScroller));
		xSize = 176;
		ySize = 222;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) 
	{
		ResourceLocation resource = new ResourceLocation("worldscroller", "textures/guis/container.png");
		mc.renderEngine.func_110577_a(resource);
		int xStart = Math.round((width / 2) - (176 / 2));
		int yStart = Math.round((height / 2) - (222 / 2));
        drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
	}
	
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
    	
    }
}
