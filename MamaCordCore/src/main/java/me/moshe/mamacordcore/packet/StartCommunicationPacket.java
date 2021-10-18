package me.moshe.mamacordcore.packet;

public class StartCommunicationPacket extends Packet {
    String message;

    public StartCommunicationPacket(String message) {
        super(PacketType.START_COMMUNICATION);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
