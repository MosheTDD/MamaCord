package me.moshe.mamacordserver;

import me.moshe.mamacordserver.communication.Server;

import java.io.IOException;

public class Main {

    private final static int PORT = 8001;
    private static Server server;

    public static void main(String[] args) throws IOException {
        server = new Server(PORT);
        server.start();
    }

    public static Server getServer() {
        return server;
    }
}
