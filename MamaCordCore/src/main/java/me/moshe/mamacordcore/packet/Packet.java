package me.moshe.mamacordcore.packet;

import java.io.Serializable;

public class Packet implements Serializable {

    PacketType type;
    String message;

    public Packet(PacketType packetType, String message) {
        this.type = packetType;
        this.message = message;
    }

    public Packet(PacketType packetType){
        this(packetType, "");
    }


    public String getMessage() {
        return message;
    }

    public PacketType getType() {
        return type;
    }
}
