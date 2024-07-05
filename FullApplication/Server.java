package FullApplication;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket servSock = new ServerSocket(5555);

            Socket clientSock = servSock.accept();
            System.out.println("Client connected to me!");
        } catch (Exception er) {
            er.printStackTrace();
        }

    }

}
