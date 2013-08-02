package mods.aginsun.worldscroller.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerHotBars extends Container
{
	public ContainerHotBars(InventoryPlayer player, TileEntityWorldScroller tile_entity)
	{
		
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) 
	{
		return false;
	}
}
