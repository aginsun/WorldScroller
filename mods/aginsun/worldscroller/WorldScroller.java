package mods.aginsun.worldscroller;

import mods.aginsun.worldscroller.common.CommonProxy;
import mods.aginsun.worldscroller.common.ItemBag;
import mods.aginsun.worldscroller.common.PlayerSaveHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "worldscroller", name = "World Scroller", version = "1.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class WorldScroller
{
	@Instance("worldscroller")
	public static WorldScroller instance;

	@SidedProxy(clientSide = "mods.aginsun.worldscroller.client.ClientProxy", serverSide = "mods.aginsun.worldscroller.common.CommonProxy")
	public static CommonProxy proxy;

	public static Item itemBag;
	public static int itemBagID;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();

		itemBagID = config.getItem("Bag", 27775).getInt();

		config.save();

		itemBag = new ItemBag(itemBagID).func_111206_d("worldscroller:bags");
		GameRegistry.registerItem(itemBag, "Bag");
		LanguageRegistry.addName(itemBag, "ScrollBag V2");
		GameRegistry.addShapedRecipe(new ItemStack(itemBag), new Object[] {"XYX", "XUX", "XXX", 'X', Block.cloth, 'Y', Item.diamond, 'U', Item.netherStar}); //TODO: Maybe change recipe
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.initClientStuff();
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
	}

	@EventHandler
	public void onServerStarted(FMLServerStartedEvent event)
	{
		GameRegistry.registerPlayerTracker(new PlayerSaveHandler());
	}
}