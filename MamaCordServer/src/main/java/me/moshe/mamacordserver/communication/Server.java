package me.moshe.mamacordserver.communication;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {

    private final List<Socket> clientList = new ArrayList<>(); //List of all clients
    private final ServerSocket ss;
    private Socket client;
    private ObjectOutputStream outputStream;
    private final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, Integer.MAX_VALUE,
            120L, TimeUnit.SECONDS,
            new SynchronousQueue<>());

    public Server(int port) throws IOException {
        ss = new ServerSocket(port);
    }

    public void start(){
        new Thread(() -> {
            while (true){
                try {
                    System.out.println("[SERVER] Waiting for client connection...");
                    client = ss.accept();
                    System.out.println("[SERVER] Connected to: { " + client.getInetAddress() + " }");
                    ClientConnection connection = new ClientConnection(client);
                    threadPool.execute(connection);
                }catch (IOException e){
                    e.printStackTrace();
                }


            }
        }).start();
    }

    public List<Socket> getClientList() {
        return clientList;
    }

    public Socket getClient() {
        return client;
    }
}
