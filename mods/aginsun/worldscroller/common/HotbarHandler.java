package mods.aginsun.worldscroller.common;

import java.util.HashMap;

import net.minecraft.entity.player.EntityPlayer;

public class HotbarHandler 
{
	private HashMap<String, HotBar[]> hotbars = new HashMap<String, HotBar[]>();
	private static HotbarHandler instance = new HotbarHandler();
	
	public static HotbarHandler getInstance()
	{
		return instance;
	}
	
	public void setHotbars(EntityPlayer player, HotBar[] hotbar)
	{
		hotbars.put(player.username, hotbar);
	}
	
	public HotBar[] getHotbars(EntityPlayer player)
	{
		if(hotbars.containsKey(player.username))
		{
			return hotbars.get(player.username);
		}
		return null;
	}
	
	public HotBar getHotbar(EntityPlayer player, int i)
	{
		HotBar[] hotbar = hotbars.get(player.username);
		return hotbar[i];
	}
	
	public void setHotbar(EntityPlayer player, int i, HotBar bar)
	{
		HotBar[] hotbar = hotbars.get(player.username);
		hotbar[i] = bar;
		hotbars.put(player.username, hotbar);
	}
}
