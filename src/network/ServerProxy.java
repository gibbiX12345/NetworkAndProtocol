package network;

import network.client.ClientApplicationInterface;
import protocol.serverToClient.Error;
import protocol.serverToClient.GameOver;
import utils.GsonHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
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
    private ServerProxy(ClientApplicationInterface clientApplication) {
        super(clientApplication);
        this.serverProxy = this;
    }

    /**
     * Konstruktor. Initialisiert das neue ServerProxy-Objekt mit der Referenz auf das Empfängerobjekt.
     *
     * @param clientApplication Das Empfängerobjekt des Bomberman-Clients für Nachrichten.
     */

    public static ServerProxy getInstance(ClientApplicationInterface clientApplication){
        ServerProxy client = new ServerProxy(clientApplication);
        return client;
    }

    private static ServerProxy serverProxy;

    public static void main(String[] args){
        String host = args[0];
        int port = Integer.parseInt(args[1]);

        try{
            Socket socket = new Socket(host, port);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(in.readLine());

            System.out.println("> ");
            Thread serverThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Socket socket = new Socket(host, port);
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                        while (true) {
                            String input = in.readLine();
                            serverProxy.clientApplication.handleMessage(GsonHelper.deserializeFromJson(input));
                            System.out.println("Server: " + input);
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            });
            serverThread.start();
            /*while ((line = input.readLine()) != null){
                if (line.length() == 0)
                    break;

                Error error = new Error("HiiilffeeeeeeE!!! figg di du arschloch");
                send(error);
            }*/
        } catch (ConnectException ce) {
            System.out.println("Error: Server not found!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void send (Message message){
        writer.println(message.serializeToGson());
    }
}
