package mods.aginsun.worldscroller.client;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class KeyBindingHandler extends KeyHandler
{
	static KeyBinding key = new KeyBinding("WorldScroller Gui Key", Keyboard.KEY_F12);
	
	static KeyBinding[] keyBindings = new KeyBinding[] {key};
	static boolean[] bool = new boolean[] {false};
	
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
			if(kb == key)
			{
				Minecraft.getMinecraft().displayGuiScreen(new GuiScreenHotBars());
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
}
