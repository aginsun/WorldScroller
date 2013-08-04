package mods.aginsun.worldscroller.packets;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler
{
	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) 
	{
		WorldPacket packetToK = PacketType.buildPacket(packet.data);
		packetToK.execute(manager, player);
	}
}
