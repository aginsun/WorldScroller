package mods.aginsun.worldscroller.client;

import java.util.EnumSet;

import mods.aginsun.worldscroller.WorldScroller;
import mods.aginsun.worldscroller.common.HotBar;
import mods.aginsun.worldscroller.common.HotbarHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class KeyBindingHandler extends KeyHandler
{
	static KeyBinding key1 = new KeyBinding("WorldScroller Gui Key", Keyboard.KEY_LCONTROL);

	static KeyBinding[] keyBindings = new KeyBinding[] {key1};
	static boolean[] bool = new boolean[] {true};
	
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
			if(kb == key1)
			{
				EntityPlayer player = Minecraft.getMinecraft().thePlayer;
				int i = Mouse.getDWheel();
				if(player.inventory.hasItem(WorldScroller.itemBag.itemID))
				{
					if(i != 0)
					{
						//hotbar of player
						ItemStack[] playerHotBar = getPlayerHotBar(player);
						
						if(i > 0)
						{
							//Hotbar that it will change with.
							int f = getCurrentHotbarNumber(player) - 1;
							if(f < 0)
								f = 5;
							ItemStack[] gettingHotbar = HotbarHandler.getInstance().getHotbar(player, f).slots;
							setPlayerHotBar(player, gettingHotbar);
							for(int k = 0; k < HotbarHandler.getInstance().getHotbar(player, f).slots.length; k++)
							{
								HotbarHandler.getInstance().getHotbar(player, f).slots[k] = null;
							}
							HotbarHandler.getInstance().setHotbar(player, getCurrentHotbarNumber(player), new HotBar(getCurrentHotbarNumber(player), playerHotBar));
							setCurrentHotbarNumber(player, f);
						}
						if(i < 0)
						{
							int f = getCurrentHotbarNumber(player) + 1;
							if(f > 5)
								f = 0;
							ItemStack[] gettingHotbar = HotbarHandler.getInstance().getHotbar(player, f).slots;
							setPlayerHotBar(player, gettingHotbar);
							for(int k = 0; k < HotbarHandler.getInstance().getHotbar(player, f).slots.length; k++)
							{
								HotbarHandler.getInstance().getHotbar(player, f).slots[k] = null;
							}
							HotbarHandler.getInstance().setHotbar(player, getCurrentHotbarNumber(player), new HotBar(getCurrentHotbarNumber(player), playerHotBar));
							setCurrentHotbarNumber(player, f);
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
	
	public int getCurrentHotbarNumber(EntityPlayer player)
	{
		return HotbarHandler.getInstance().getCurrentHotbar(player);
	}
	
	public void setCurrentHotbarNumber(EntityPlayer player, int i)
	{
		HotbarHandler.getInstance().setCurrentHotbar(player, i);
	}
	
	public ItemStack[] getPlayerHotBar(EntityPlayer player)
	{
		ItemStack[] itemStack = player.inventory.mainInventory;
		ItemStack[] hotbar = new ItemStack[9];
		for(int k = 0; k <= 8; k++)
		{
			hotbar[k] = player.inventory.mainInventory[k];
		}
		return hotbar;
	}
	
	public void setPlayerHotBar(EntityPlayer player, ItemStack[] itemStack)
	{
		ItemStack[] item = player.inventory.mainInventory;
		for(int k = 0; k <= 8; k++)
		{
			player.inventory.mainInventory[k] = itemStack[k];
		}
	}
	
	public void clearHotbar(EntityPlayer player, ItemStack[] itemstack)
	{
		for(ItemStack itemStack : itemstack)
		{
			itemStack = null;
		}
	}
}
