package FullApplication;

import java.net.*;
import java.io.*;

public class Client{
    public static void main(String[] args) {
        try{
            Socket clientSock = new Socket("localhost",5555);
            //*A socket and its port is what will connect the client 2 server */

            //*Output Stream/
            PrintWriter pr = new PrintWriter(clientSock.getOutputStream(), true);
            pr.println("Hello, Im client");
            //*Output Stream is what we use to send data to a Server */

            InputStreamReader in = new InputStreamReader(clientSock.getInputStream());
            BufferedReader bufRead = new BufferedReader(in);
            String inStr = bufRead.readLine();
            System.out.println("Servre says to Client:"+inStr);

            bufRead.close();//!Close Buffer 1st
            in.close();     //!Close InputStream 2nd
            pr.close();     //!Close OutStream 3rd
                            //!Sockets to be closed last
            clientSock.close();
        }catch(IOException er){
            er.printStackTrace();
        }

    }
    

}