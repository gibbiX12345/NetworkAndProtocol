package network;


import com.sun.javafx.collections.MappingChange;
import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by vmadmin on 01.11.2016.
 */

public class Server extends Thread {
    private Socket client;
    private static List<Socket> clientList = new ArrayList<>();
    private static HashMap<String, Socket> clientConntectionMap = new HashMap<>();

    public Server(Socket client) {
        this.client = client;
        Server.clientList.add(client);
        Server.clientConntectionMap.put(client.getRemoteSocketAddress().toString(), client);
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            out.println("Hallo, ich bin der Server");

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

    public static void broadcast(String message){
        for (Socket client : clientList){
            try {
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void send(String message, String connectionId){
        Socket client = Server.clientConntectionMap.get(connectionId);
        try {
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            out.println(message);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main (String[] args){
        int port = Integer.parseInt(args[0]);

        Thread readLineThread = new Thread(new Runnable() {
            @Override
            public void run() {
                String line;
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

                try {
                    while ((line = input.readLine()) != null) {
                        if (line.length() == 0)
                            break;

                        Server.broadcast(line);
                    }
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        });

        readLineThread.start();

        try (ServerSocket server = new ServerSocket(port) ){
            System.out.println("Server auf " + port + " gestartet ...");
            while(true){
                Socket client = server.accept();
                new Server(client).start();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
