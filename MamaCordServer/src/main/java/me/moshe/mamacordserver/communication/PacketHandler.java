package me.moshe.mamacordserver.communication;

import me.moshe.mamacordcore.packet.PacketType;
import me.moshe.mamacordserver.Main;

import java.net.Socket;
import java.util.List;


public class PacketHandler {

    public PacketHandler(PacketType packetType){
        List<Socket> clientList = Main.getServer().getClientList();
        Socket client = Main.getServer().getClient();
        
        switch (packetType){
            case START_COMMUNICATION:
                clientList.add(client);
                System.out.println("[SERVER] There are '" + clientList.size() + "' clients currently connected to the server");
                break;

        }
    }
}
