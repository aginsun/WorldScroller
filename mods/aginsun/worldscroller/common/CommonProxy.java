package mods.aginsun.worldscroller.common;

import mods.aginsun.worldscroller.client.GuiScreenHotBars;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler
{
	public void initClientStuff()
	{
		//NOTHING HERE!
	}

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) 
    {
    	switch(id)
    	{
    		case GuiIds.GUI_HOTBARS :
    			return new ContainerHotBars(player.inventory, new TileEntityWorldScroller());
            default:
            	return null;
    	}
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world,int x, int y, int z) 
    {
    	switch(id)
    	{
    		case GuiIds.GUI_HOTBARS :
    			return new GuiScreenHotBars(player.inventory, new TileEntityWorldScroller());
    		default:
    			return null;
    	}
    }

}
