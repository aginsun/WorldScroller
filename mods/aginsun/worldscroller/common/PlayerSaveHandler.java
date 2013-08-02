package mods.aginsun.worldscroller.common;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.IPlayerTracker;

public class PlayerSaveHandler implements IPlayerTracker
{
	@Override
	public void onPlayerLogin(EntityPlayer player) 
	{
		//TODO: write and read stuff from nbt.
	}

	@Override
	public void onPlayerLogout(EntityPlayer player)
	{
		
	}

	@Override
	public void onPlayerChangedDimension(EntityPlayer player){}

	@Override
	public void onPlayerRespawn(EntityPlayer player){}
}
