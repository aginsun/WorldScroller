package mods.aginsun.worldscroller.client;

import java.awt.Color;
import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

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
		int posX = 5, posZ = 10;
		int color = Color.blue.getRGB();
		
		Minecraft.getMinecraft().fontRenderer.drawString("Number", posX, posZ, color); //TODO: getCurrentHotbar()
	}
	
	public void onTickInGUI(GuiScreen gui){}
	
	public void onTickInGame()
	{
		int mouseWheelDirection = Mouse.getDWheel();
	}
}
