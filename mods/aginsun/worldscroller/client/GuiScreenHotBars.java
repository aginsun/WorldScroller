package mods.aginsun.worldscroller.client;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiScreenHotBars extends GuiContainer
{
	public GuiScreenHotBars(Container par1Container) 
	{
		super(par1Container);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) 
	{
		ResourceLocation resource = new ResourceLocation("worldscroller","textures/guis/container.png");
		mc.renderEngine.func_110577_a(resource);
	}
}
