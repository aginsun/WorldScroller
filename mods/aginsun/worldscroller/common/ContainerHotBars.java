package mods.aginsun.worldscroller.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class ContainerHotBars extends Container
{
	public ContainerHotBars(InventoryPlayer playerinv, TileEntityWorldScroller tile_entity)
	{
		addPlayerInventory(playerinv);
		
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				addSlotToContainer(new Slot(tile_entity, j + i * 9, 8 + j * 18, 18 + i * 18));
			}
		}
	}
	
	public void addPlayerInventory(InventoryPlayer player_inventory)
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				addSlotToContainer(new Slot(player_inventory, j + i * 9 + 9, 8 + j * 18, 140 + i * 18));
			}
		}

		for(int i = 0; i < 9; i++)	
		{
			addSlotToContainer(new Slot(player_inventory, i, 8 + i * 18, 198));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) 
	{
		return true;
	}
}