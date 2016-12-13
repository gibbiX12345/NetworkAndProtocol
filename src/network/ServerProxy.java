package network;

import network.client.ClientApplicationInterface;
import test.TestInterface;
import utils.JsonHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by vmadmin on 01.11.2016.
 */
public class ServerProxy extends network.client.ServerProxy {
    private static PrintWriter writer;

    /**
     * Konstruktor. Initialisiert das neue ServerProxy-Objekt mit der Referenz auf das Empf�ngerobjekt.
     *
     * @param clientApplication Das Empf�ngerobjekt des Bomberman-Clients f�r Nachrichten.
     */
    public ServerProxy(ClientApplicationInterface clientApplication, String host) {
        super(clientApplication);
        this.runClient(host);
    }

    /**
     * Konstruktor. Initialisiert das neue ServerProxy-Objekt mit der Referenz auf das Empfängerobjekt.
     *
     * @param clientApplication Das Empfängerobjekt des Bomberman-Clients für Nachrichten.
     */

    private static ServerProxy getInstance(ClientApplicationInterface clientApplication){
        ServerProxy client = new ServerProxy(clientApplication, "127.0.0.1");
        return client;
    }

    public static void main(String[] args) {
        ServerProxy client = new ServerProxy(new TestInterface(), "127.0.0.1");
    }
    private void runClient(String host){
        int port = 12345;
        try{
            Thread serverThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Socket socket = new Socket(host, port);
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        writer = new PrintWriter(socket.getOutputStream(), true);

                        while (true) {
                            String input = in.readLine();
                            clientApplication.handleMessage(JsonHelper.deserializeFromJson(input));
                            System.out.println("Server: " + input);
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            });
            serverThread.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void send (Message message){
        writer.println(message.serializeToGson());
    }
}
