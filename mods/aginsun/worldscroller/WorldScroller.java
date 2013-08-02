package mods.aginsun.worldscroller;

import mods.aginsun.worldscroller.common.CommonProxy;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "worldscroller", name = "World Scroller", version = "1.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class WorldScroller
{
	@Instance("worldscroller")
	public static WorldScroller instance;
	
	@SidedProxy(clientSide = "mods.aginsun.worldscroller.client.ClientProxy", serverSide = "mods.aginsun.worldscroller.common.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		//CONFIG
		
		config.save();
		
		//PRE-INIT
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		//INIT
	}
}
