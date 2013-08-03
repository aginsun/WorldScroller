package mods.aginsun.worldscroller.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotHotBars extends Slot
{
	private int slot;
	private EntityPlayer player;
	public SlotHotBars(IInventory par1iInventory, int par2, int par3, int par4, EntityPlayer player) 
	{
		super(par1iInventory, par2, par3, par4);
		this.slot = par2;
		this.player = player;
	}
	
	@Override
    public boolean isItemValid(ItemStack par1ItemStack)
    {
		int i = HotbarHandler.getInstance().getCurrentHotbar(player);
		if(slot >= i * 9 && slot < (i + 1) * 9)
			return false;
		return true;
    }
}
