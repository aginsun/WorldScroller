package mods.aginsun.worldscroller.client;

import net.minecraft.item.ItemStack;

public class ClientHotbarHandler
{
	private ItemStack[] itemStack = new ItemStack[54];
	private int hotbar;
	private static ClientHotbarHandler instance = new ClientHotbarHandler();
	
	public static ClientHotbarHandler getInstance()
	{
		return instance;
	}
	
	public ItemStack[] getInventory()
	{
		return itemStack;
	}
	
	public void setInventory(ItemStack[] itemStack)
	{
		this.itemStack = itemStack;
	}
	
	public void setInventorySlot(ItemStack itemStack, int i)
	{
		this.itemStack[i] = itemStack;
	}
	
	public ItemStack getInventorySlot(int i)
	{
		return itemStack[i];
	}
	
	public void setHotbar(int i)
	{
		hotbar = i;
	}
	
	public int getHotbar()
	{
		return hotbar;
	}
}
