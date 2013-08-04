package mods.aginsun.worldscroller.packets;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

public enum PacketType 
{
	CREATE(PacketCreate.class),
	HOTBAR(Packethotbar.class);
	
	private Class<? extends WorldPacket> clazz;
	
	PacketType(Class<? extends WorldPacket> clazz)
	{
		this.clazz = clazz;
	}
	
    public static WorldPacket buildPacket(byte[] data) {

        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        int selector = bis.read();
        DataInputStream dis = new DataInputStream(bis);

        WorldPacket packet = null;

        try {
            packet = values()[selector].clazz.newInstance();
        }
        catch (Exception e) {
            e.printStackTrace(System.err);
        }

        packet.readPopulate(dis);

        return packet;
    }

    public static WorldPacket buildPacket(PacketType type) {

    	WorldPacket packet = null;

        try {
            packet = values()[type.ordinal()].clazz.newInstance();
        }
        catch (Exception e) {
            e.printStackTrace(System.err);
        }

        return packet;
    }

    public static Packet populatePacket(WorldPacket worldPacket) {

        byte[] data = worldPacket.populate();

        Packet250CustomPayload packet250 = new Packet250CustomPayload();
        packet250.channel = "worldscroller";
        packet250.data = data;
        packet250.length = data.length;
        packet250.isChunkDataPacket = worldPacket.isChunkDataPacket;

        return packet250;
    }
}
