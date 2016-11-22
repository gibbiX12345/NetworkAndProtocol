package network;


import network.server.ServerApplicationInterface;
import protocol.serverToClient.Error;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by vmadmin on 01.11.2016.
 */

public class Server extends network.server.Server {
    public static List<Socket> clientList = new ArrayList<>();
    public static HashMap<String, Socket> clientConntectionMap = new HashMap<>();

    /**
     * Konstruktor. Initialisiert das neue Server-Objekt mit der Referenz auf das Empfängerobjekt.
     *
     * @param serverApplication Das Empfängerobjekt des Bomberman-Servers für Nachrichten.
     */
    public Server(ServerApplicationInterface serverApplication) {
        super(serverApplication);
    }

    public Server getInstance(ServerApplicationInterface serverApplication){
        Server server = new Server(serverApplication);
        System.out.println("server created");
        return server;
    }

    public void broadcast(Message message){
        for (Socket client : clientList){
            try {
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                out.println(message.serializeToGson());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void send(Message message, String connectionId){
        Socket client = Server.clientConntectionMap.get(connectionId);
        try {
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            out.println(message.serializeToGson());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main (String[] args){
        int port = Integer.parseInt(args[0]);

        /*Thread readLineThread = new Thread(new Runnable() {
            @Override
            public void run() {
                String line;
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

                try {
                    while ((line = input.readLine()) != null) {
                        if (line.length() == 0)
                            break;

                        PlayerJoined joined = new PlayerJoined("Peschä", 0, 0);
                        Server.broadcast(joined);
                    }
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        });

        readLineThread.start();*/

        try (ServerSocket server = new ServerSocket(port) ){
            System.out.println("Server auf " + port + " gestartet ...");
            while(true){
                Socket client = server.accept();
                Thread serverThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                            Error error = new Error("OMG e fähler!");
                            out.println(error.serializeToGson());

                            String input;
                            while (true){
                                input = in.readLine();
                                System.out.println("Client(" + client.getRemoteSocketAddress() + "): " + input);
                                //out.println(input);
                            }
                        } catch (IOException e) {
                            System.out.println("Client(" + client.getRemoteSocketAddress() + ")disconnected");
                        } finally {
                            try {
                                if (client != null) {
                                    client.close();
                                }
                            } catch (IOException e){
                                e.printStackTrace();
                            }
                        }
                    }
                });
                serverThread.start();
                Server.clientList.add(client);
                Server.clientConntectionMap.put(client.getRemoteSocketAddress().toString(), client);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
