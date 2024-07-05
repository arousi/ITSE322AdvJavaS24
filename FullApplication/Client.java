package FullApplication;

import java.net.*;
import java.io.*;

public class Client{
    public static void main(String[] args) {
        try{
            Socket clientSock = new Socket("localhost",5555);
            //*A socket and its port is what will connect the client 2 server */

            //*Output Stream/
            PrintWriter pr = new PrintWriter(clientSock.getOutputStream());
            pr.println("Hello, Im client");
            //*Output Stream is what we use to send data to a Server */

            pr.flush();
            clientSock.close();
        }catch(IOException er){
            er.printStackTrace();
        }

    }
    

}