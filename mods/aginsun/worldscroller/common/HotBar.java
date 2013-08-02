package mods.aginsun.worldscroller.common;

import net.minecraft.item.ItemStack;

public class HotBar 
{
	public ItemStack[] slots;
	public int i;
	
	public HotBar(int i, ItemStack[] slots)
	{
		this.i = i;
		this.slots = slots;
	}
}
