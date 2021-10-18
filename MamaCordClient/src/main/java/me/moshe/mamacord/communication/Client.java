package me.moshe.mamacord.communication;

import me.moshe.mamacordcore.packet.Packet;

import java.io.*;
import java.net.Socket;

public class Client {

    private PacketHandler packetHandler;
    private ObjectInputStream inputStream;
    public final Socket client;
    private boolean running = true;


    public Client(String ip, int port) throws IOException {
        client = new Socket(ip, port);
    }

    public void start() {
        if (client.isConnected())
            System.out.println("[CLIENT] Connected to: { " + client.getLocalAddress() + " }");
        while (running) {
            try {
                inputStream = new ObjectInputStream(client.getInputStream()); //Input from server
                Object o = inputStream.readObject();
                System.out.println(o);
                if(o instanceof Packet){
                    packetHandler = new PacketHandler(((Packet) o).getType());
                }
                inputStream.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public Socket getClient() {
        return client;
    }
}


