package me.moshe.mamacordcore.packet;

public class LoginPacket extends Packet{
    public LoginPacket(PacketType packetType, String message) {
        super(PacketType.LOGIN);
    }
}
