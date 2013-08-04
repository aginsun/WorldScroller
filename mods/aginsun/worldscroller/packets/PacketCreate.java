package mods.aginsun.worldscroller.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import mods.aginsun.worldscroller.client.ClientHotbarHandler;
import mods.aginsun.worldscroller.common.HotBar;
import mods.aginsun.worldscroller.common.HotbarHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.INetworkManager;
import cpw.mods.fml.common.network.Player;

public class PacketCreate extends WorldPacket 
{
	private String username;
	private int itemID, stackSize, metadata, slot;
	
	public PacketCreate() 
	{
		super(PacketType.CREATE, false);
	}

	public PacketCreate(String username, int itemID, int stackSize, int metadata, int slot)
	{
		super(PacketType.CREATE, false);
		this.username = username;
		this.itemID = itemID;
		this.metadata = metadata;
		this.slot = slot;
	}
	
	@Override
	public void readData(DataInputStream data) throws IOException 
	{
		this.username = data.readUTF();
		this.itemID = data.readInt();
		this.stackSize = data.readInt();
		this.metadata = data.readInt();
		this.slot = data.readInt();
	}

	@Override
	public void writeData(DataOutputStream dos) throws IOException 
	{
		dos.writeUTF(username);
		dos.writeInt(itemID);
		dos.writeInt(stackSize);
		dos.writeInt(metadata);
		dos.writeInt(slot);
	}

	@Override
	public void execute(INetworkManager network, Player player) 
	{
		if(itemID == 0 && stackSize == 0 && metadata == 0)
			ClientHotbarHandler.getInstance().setInventorySlot(null, slot);
		else
			ClientHotbarHandler.getInstance().setInventorySlot(new ItemStack(itemID, stackSize, metadata), slot);
	}
}
