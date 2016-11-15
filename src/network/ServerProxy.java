package network;

import protocol.serverToClient.Error;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by vmadmin on 01.11.2016.
 */
public class ServerProxy {
    private static PrintWriter writer;

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
            String line;
            Thread serverThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Socket socket = new Socket(host, port);
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                        while (true) {
                            String input = in.readLine();
                            System.out.println("Server: " + input);
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            });
            serverThread.start();
            while ((line = input.readLine()) != null){
                if (line.length() == 0)
                    break;

                Error error = new Error("HiiilffeeeeeeE!!! figg di du arschloch");
                send(error);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void send (Message message){
        writer.println(message.serializeToGson());
    }
}
