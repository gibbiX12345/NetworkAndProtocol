package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by vmadmin on 01.11.2016.
 */
public class Client {

    public static void main(String[] args){
        String host = args[0];
        int port = Integer.parseInt(args[1]);

        try{
            Socket socket = new Socket(host, port);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(in.readLine());

            System.out.println("> ");
            String line;
            while ((line = input.readLine()) != null){
                if (line.length() == 0)
                    break;

                out.println(line);
                System.out.println("Antwort vom Server:");
                System.out.println(in.readLine());
                System.out.println("> ");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
