package mods.aginsun.worldscroller.client;

import java.util.EnumSet;

import mods.aginsun.worldscroller.WorldScroller;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class KeyBindingHandler extends KeyHandler
{
	static KeyBinding key = new KeyBinding("WorldScroller Gui Key", Keyboard.KEY_F12);
	static KeyBinding key1 = new KeyBinding("WorldScroller Gui Key", Keyboard.KEY_LCONTROL);

	static KeyBinding[] keyBindings = new KeyBinding[] {key, key1};
	static boolean[] bool = new boolean[] {true, true};
	
	public KeyBindingHandler() 
	{
		super(keyBindings, bool);
	}

	@Override
	public String getLabel()
	{
		return "WorldScroller keybinding";
	}

	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb,	boolean tickEnd, boolean isRepeat) 
	{
		if(Minecraft.getMinecraft().currentScreen == null)
		{
			if(kb == key && kb == key1)
			{
				EntityPlayer player = Minecraft.getMinecraft().thePlayer;
				int i = Mouse.getDWheel();
				if(player.inventory.hasItem(WorldScroller.itemBag.itemID))
				{
					if(i != 0)
					{
						if(i > 0)
						{
							int j = getCurrentHotbar(player);
							j++;
							setCurrentHotbar(player, j);
						}
						if(i < 0)
						{
							int j = getCurrentHotbar(player);
							j--;
							setCurrentHotbar(player, j);//TODO: get this working.
						}
					}
				}
			}
		}
	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd){}

	@Override
	public EnumSet<TickType> ticks() 
	{
		return EnumSet.of(TickType.CLIENT);
	}
	
	public int getCurrentHotbar(EntityPlayer player)
	{
		return 0;
	}
	
	public void setCurrentHotbar(EntityPlayer player, int i)
	{
		
	}
}
