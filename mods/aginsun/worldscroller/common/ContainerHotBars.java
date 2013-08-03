package mods.aginsun.worldscroller.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerHotBars extends Container
{
	private TileEntityWorldScroller tile_entity;
	public ContainerHotBars(InventoryPlayer playerinv, TileEntityWorldScroller tile_entity)
	{
		this.tile_entity = tile_entity;
		tile_entity.openChest();
		addPlayerInventory(playerinv);
		
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				addSlotToContainer(new SlotHotBars(tile_entity, j + i * 9, 8 + j * 18, 18 + i * 18, playerinv.player));
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
	
	public void onContainerClosed(EntityPlayer player)
	{
		super.onContainerClosed(player);
		tile_entity.closeChest();
	}
	
	@Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int i)
	{
		ItemStack stack = null;
		Slot slot_object = (Slot) inventorySlots.get(i);

		if(slot_object != null && slot_object.getHasStack())
			{
			ItemStack stack_in_slot = slot_object.getStack();
			stack = stack_in_slot.copy();

			if(i == 0)
			{
				if(!mergeItemStack(stack_in_slot, 1, inventorySlots.size(), true))
				{
					return null;
				}
			} 
			else if(!mergeItemStack(stack_in_slot, 0, 1, false))
			{
				return null;
			}

			if(stack_in_slot.stackSize == 0)
			{
				slot_object.putStack(null);
			} else
			{
				slot_object.onSlotChanged();
			}
		}

	return stack;
	}
}