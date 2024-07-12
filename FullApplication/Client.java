package FullApplication;

import java.net.*;
import java.io.*;

public class Client{
    public static void main(String[] args) {
        try{
            Socket clientSock = new Socket("localhost",5555);
            //*A socket and its port is what will connect the client 2 server */

            //*Output Stream/
            PrintWriter prOutStream = new PrintWriter(clientSock.getOutputStream(), true);
            prOutStream.println("Hello, Im client");
            //*Output Stream is what we use to send data to a Server */

            InputStreamReader inStream = new InputStreamReader(clientSock.getInputStream());
            BufferedReader bufRead = new BufferedReader(inStream);
            String inStr = bufRead.readLine();
            System.out.println("Servre says to Client:"+inStr);

            bufRead.close();        //!Close Buffer 1st
            inStream.close();       //!Close InputStream 2nd
            prOutStream.close();    //!Close OutStream 3rd
                                    //!Sockets to be closed last
            clientSock.close();
        }catch(IOException er){
            er.printStackTrace();
        }

    }
    

}