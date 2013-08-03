package mods.aginsun.worldscroller.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import cpw.mods.fml.common.IPlayerTracker;

public class PlayerSaveHandler implements IPlayerTracker
{	
	@Override
	public void onPlayerLogin(EntityPlayer player) 
	{
		NBTTagCompound nbt = player.getEntityData().getCompoundTag(player.PERSISTED_NBT_TAG);
		HotbarHandler.getInstance().setCurrentHotbar(player, nbt.getInteger("currentHotbar"));
		NBTTagList list = nbt.getTagList("hotbars");
		
		if(list.tagCount() == 0)
		{
			HotBar[] hotbars = new HotBar[6];			
			for(int i = 0; i < hotbars.length; i++)
			{
				hotbars[i] = new HotBar(i, new ItemStack[9]);
			}
			HotbarHandler.getInstance().setHotbars(player, hotbars);
		}
		else
		{
			HotBar[] hotbars = new HotBar[6];
			for(int i = 0; i < hotbars.length; i++)
			{
				hotbars[i] = new HotBar(i, new ItemStack[9]);
			}
			ItemStack[] item = new ItemStack[54];
			for(int k = 0; k < list.tagCount(); k++)
			{
				NBTTagCompound nbt1 = (NBTTagCompound) list.tagAt(k);
				ItemStack stack = new ItemStack(nbt1.getInteger("id"), nbt1.getInteger("amount"), nbt1.getInteger("metadata"));
				item[nbt1.getInteger("slot")] = stack;
			}
			
			for(int i = 0; i < hotbars.length; i++)
			{
				for(int j = 0; j < hotbars[i].slots.length; j++)
				{
					ItemStack stack = item[j + i * 9];
					if(stack != null)
						hotbars[i].slots[j] = stack;
				}
			}
			
			HotbarHandler.getInstance().setHotbars(player, hotbars);
		}
	}

	@Override
	public void onPlayerLogout(EntityPlayer player)
	{
		NBTTagCompound nbt = player.getEntityData().getCompoundTag(player.PERSISTED_NBT_TAG);
		nbt.setInteger("currentHotbar", HotbarHandler.getInstance().getCurrentHotbar(player));
		NBTTagList list = new NBTTagList();
		
		HotBar[] hotbars = HotbarHandler.getInstance().getHotbars(player);
		
		for(int i = 0; i < hotbars.length; i ++)
		{
			HotBar bar = hotbars[i];
			for(int j = 0; j < bar.slots.length; j++)
			{
				ItemStack itemStack = bar.slots[j];
				if(itemStack != null)
				{
					NBTTagCompound list1 = new NBTTagCompound();
					
					list1.setInteger("slot", j + i * 9);
					list1.setInteger("id", itemStack.itemID);
					list1.setInteger("amount", itemStack.stackSize);
					list1.setInteger("metadata", itemStack.getItemDamage());
					
					list.appendTag(list1);
				}
			}
		}

		nbt.setTag("hotbars", list);
		
		player.getEntityData().setCompoundTag(player.PERSISTED_NBT_TAG, nbt);
	}

	@Override
	public void onPlayerChangedDimension(EntityPlayer player){}

	@Override
	public void onPlayerRespawn(EntityPlayer player){}
}
