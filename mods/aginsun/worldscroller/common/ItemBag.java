package mods.aginsun.worldscroller.common;

import mods.aginsun.worldscroller.WorldScroller;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBag extends Item
{
	public ItemBag(int par1)
	{
		super(par1);
		this.setCreativeTab(CreativeTabs.tabInventory);
	}
	
	@Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World world, EntityPlayer player)
	{
		player.openGui(WorldScroller.instance, GuiIds.GUI_HOTBARS, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
		return par1ItemStack;
	}
}
