package mods.aginsun.worldscroller.client;

import java.awt.Color;
import java.util.EnumSet;

import mods.aginsun.worldscroller.common.HotbarHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.input.Mouse;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ClientTickHandler implements ITickHandler
{

	@Override
    public void tickStart(EnumSet<TickType> type, Object... tickData) {}
    
	@Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData)
    {
        if (type.equals(EnumSet.of(TickType.RENDER)))
        {
            onRenderTick();
        }
        else if (type.equals(EnumSet.of(TickType.CLIENT)))
        {
            GuiScreen guiscreen = Minecraft.getMinecraft().currentScreen;
            if(guiscreen != null)
            {
                onTickInGUI(guiscreen);
            }else{
                onTickInGame();
            }            
        }
    }
	
    @Override
    public EnumSet<TickType> ticks()
    {
        return EnumSet.of(TickType.RENDER, TickType.CLIENT);
    }
    
	@Override
	public String getLabel() {return null;}
	
	public void onRenderTick()
	{
		Minecraft mc = Minecraft.getMinecraft();
        ScaledResolution scaledresolution = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
		int posX = scaledresolution.getScaledWidth() / 2 + 93;
		int posZ = scaledresolution.getScaledHeight() / 2 + 155;
		int color = Color.red.getRGB();
		EntityPlayer player = mc.thePlayer;
		if(player != null && mc.theWorld != null)
			mc.fontRenderer.drawString(new StringBuilder().append(HotbarHandler.getInstance().getCurrentHotbar(player)).toString(), posX, posZ, color);
	}
	
	public void onTickInGUI(GuiScreen gui){}
	
	public void onTickInGame()
	{
		int mouseWheelDirection = Mouse.getDWheel();
	}
}
