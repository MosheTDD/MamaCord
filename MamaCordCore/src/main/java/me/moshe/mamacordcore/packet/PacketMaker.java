package me.moshe.mamacordcore.packet;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class PacketMaker {

    Packet packet;

    public void createPacket(PacketType type){
        this.packet = new Packet(type);
    }

    public void sendPacket(Socket socket) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeObject(packet);
    }
}
