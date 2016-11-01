package network;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by vmadmin on 01.11.2016.
 */

public class Server extends Thread {
    private Socket client;

    public Server(Socket client) {
        this.client = client;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            out.println("Hallo, ich bin der Server");

            String input;
            while ((input = in.readLine()) != null){
                out.println(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (client != null) {
                    client.close();
                }
            } catch (IOException e){

            }
        }
    }

    public static void main (String[] args){
        int port = Integer.parseInt(args[0]);

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
