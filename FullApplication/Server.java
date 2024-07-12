package FullApplication;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        try {
            // *Socket */
            ServerSocket servSock = new ServerSocket(5555);
            Socket clientSock = servSock.accept();
            // *Server Socket will connect to the same port in Client file */
            System.out.println("\nClient connected to me!\n");
            // prints after .accept(); becomes true

            // *Input Stream */
            InputStreamReader inStream = new InputStreamReader(clientSock.getInputStream());
            // *Input Stream reads from Output Stream init in the Client */

            // *Buffer then takes the input from Istream to process it */
            BufferedReader bufRead = new BufferedReader(inStream);
            String str = bufRead.readLine();
            // *str to store what the Buffere has read */

            // Print the mssg sent from Client, OutStream-Client then InputStream-Server
            // then Buffer-Server then str<-Buffer-Server

            System.out.println("Client says: " + str);
            // Print Client msg

            PrintWriter prOutStream = new PrintWriter(clientSock.getOutputStream(), true);
            prOutStream.println("Hi Im server");

            bufRead.close();      //!Close Buffer 1st
            inStream.close();     //!Close InputStream 2nd
            prOutStream.close();   //!Close OutStream 3rd
                                    //!Sockets to be closed last
            clientSock.close();
            servSock.close();

        } catch (Exception er) {
            er.printStackTrace();
        }
        }

    }


