package mods.aginsun.worldscroller.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import mods.aginsun.worldscroller.client.ClientHotbarHandler;
import net.minecraft.network.INetworkManager;
import cpw.mods.fml.common.network.Player;

public class Packethotbar extends WorldPacket
{
	private String username;
	private int hotbar;
	
	public Packethotbar() 
	{
		super(PacketType.HOTBAR, false);
	}
	
	public Packethotbar(String username, int hotbar)
	{
		super(PacketType.HOTBAR, false);
		this.username = username;
		this.hotbar = hotbar;
	}

	@Override
	public void readData(DataInputStream data) throws IOException
	{
		username = data.readUTF();
		hotbar = data.readInt();
	}

	@Override
	public void writeData(DataOutputStream dos) throws IOException
	{
		dos.writeUTF(username);
		dos.writeInt(hotbar);
	}

	@Override
	public void execute(INetworkManager network, Player player)
	{
		ClientHotbarHandler.getInstance().setHotbar(hotbar);
	}
}
