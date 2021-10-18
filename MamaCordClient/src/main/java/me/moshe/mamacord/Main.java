package me.moshe.mamacord;

import me.moshe.mamacord.communication.Client;
import me.moshe.mamacord.ui.Interface;

import java.io.IOException;
import java.net.Socket;

public class Main {

    private static final Interface inf = new Interface();
    private static Client client;

    public static void main(String[] args) throws IOException {
        client = new Client("localhost", 8001);
        inf.start(args);
        client.start();
    }

    public static Socket getClient() {
        return client.getClient();
    }
}
