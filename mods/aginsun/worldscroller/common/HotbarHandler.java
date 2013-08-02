package mods.aginsun.worldscroller.common;

import java.util.HashMap;

import net.minecraft.entity.player.EntityPlayer;

public class HotbarHandler 
{
	private static HashMap<String, HotBar[]> hotbars = new HashMap<String, HotBar[]>();
	
	public static void setHotbars(EntityPlayer player, HotBar[] hotbar)
	{
		hotbars.put(player.username, hotbar);
	}
	
	public static HotBar[] getHotbars(EntityPlayer player)
	{
		if(hotbars.containsKey(player.username))
		{
			return hotbars.get(player.username);
		}
		return null;
	}
	
	public static HotBar getHotbar(EntityPlayer player, int i)
	{
		HotBar[] hotbar = hotbars.get(player.username);
		return hotbar[i];
	}
	
	public static void setHotbar(EntityPlayer player, int i, HotBar bar)
	{
		HotBar[] hotbar = hotbars.get(player.username);
		hotbar[i] = bar;
		hotbars.put(player.username, hotbar);
	}
}
