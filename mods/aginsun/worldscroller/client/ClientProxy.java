package mods.aginsun.worldscroller.client;

import mods.aginsun.worldscroller.common.CommonProxy;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy
{
	@Override
	public void initClientStuff()
	{
		//All things that have to be registered only client side!
		KeyBindingRegistry.registerKeyBinding(new KeyBindingHandler());
		TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
	}
}
