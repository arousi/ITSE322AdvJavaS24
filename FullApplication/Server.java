package FullApplication;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket servSock = new ServerSocket(5555);

            Socket clientSock = servSock.accept();
            System.out.println("\nClient connected to me!\n");

            InputStreamReader in = new InputStreamReader(clientSock.getInputStream());
            BufferedReader bufRead = new BufferedReader(in);

            String str = bufRead.readLine();
            System.out.println("Client says: " + str);
            
            servSock.close();
            clientSock.close();

        } catch (Exception er) {
            er.printStackTrace();
        }
        finally{

        }

    }

}
