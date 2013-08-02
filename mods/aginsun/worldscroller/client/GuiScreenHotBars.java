package mods.aginsun.worldscroller.client;

import mods.aginsun.worldscroller.common.ContainerHotBars;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

public class GuiScreenHotBars extends GuiContainer
{
	public GuiScreenHotBars() 
	{
		super(new ContainerHotBars());
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) 
	{
		ResourceLocation resource = new ResourceLocation("worldscroller","textures/guis/container.png");
		mc.renderEngine.func_110577_a(resource);
        int l = (width - xSize) / 2;
        int i1 = (height - ySize) / 2;
        drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);
	}
	
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
    	
    }
}
