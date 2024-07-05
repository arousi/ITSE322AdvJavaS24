package FullApplication;

import java.net.*;
import java.io.*;

public class Client{
    public static void main(String[] args) {
        try{
            Socket clientSock = new Socket("localhost",5555);
            PrintWriter pr = new PrintWriter(clientSock.getOutputStream());
            pr.println("Hello, Im client");

            pr.flush();
            clientSock.close();
        }catch(IOException er){
            er.printStackTrace();
        }

    }
    

}