package me.moshe.mamacordserver.communication;

import me.moshe.mamacordcore.packet.Packet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientConnection implements Runnable{

    private PacketHandler packetHandler;
    private final Socket client;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    public ClientConnection(Socket socket){
        this.client = socket;
    }

    @Override
    public void run() {
        while (true) {
            try {
                inputStream = new ObjectInputStream(client.getInputStream());
                Object o = inputStream.readObject();
                if(o instanceof Packet){
                    packetHandler = new PacketHandler(((Packet) o).getType());
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
