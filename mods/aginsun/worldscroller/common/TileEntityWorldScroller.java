package mods.aginsun.worldscroller.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class TileEntityWorldScroller implements IInventory
{
	private ItemStack[] inventory;
	
	public TileEntityWorldScroller()
	{
		inventory = new ItemStack[54];
	}

	@Override
	public int getSizeInventory()
	{
		return inventory.length;
	}
	
	@Override
    public ItemStack getStackInSlot(int i)
    {
        return inventory[i];
    }
	@Override
    public void setInventorySlotContents(int i, ItemStack itemstack)
    {
        inventory[i] = itemstack;
        if (itemstack != null && itemstack.stackSize > getInventoryStackLimit())
        {
            itemstack.stackSize = getInventoryStackLimit();
        }
    }
	@Override
    public ItemStack decrStackSize(int i, int j)
    {
        if (inventory[i] != null)
        {
            if (inventory[i].stackSize <= j)
            {
                ItemStack itemstack = inventory[i];
                inventory[i] = null;
                return itemstack;
            }
            ItemStack itemstack1 = inventory[i].splitStack(j);
            if (inventory[i].stackSize == 0)
            {
                inventory[i] = null;
            }
            return itemstack1;
        }
        else
        {
            return null;
        }
    }

	@Override
	public ItemStack getStackInSlotOnClosing(int slotIndex)
	{
		return null;
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}


	@Override
	public String getInvName() 
	{
		return "WorldScroller";
	}

	@Override
	public boolean isInvNameLocalized()
	{
		return false;
	}

	@Override
	public void onInventoryChanged() 
	{
		//Update fuction
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) 
	{
		return false;
	}

	@Override
	public void openChest(){}

	@Override
	public void closeChest(){}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) 
	{
		return false;
	}
}
