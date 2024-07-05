package FullApplication;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        try {
            //*Socket */
            ServerSocket servSock = new ServerSocket(5555);
            Socket clientSock = servSock.accept();
            //*Server Socket will connect to the same port in Client file */
            System.out.println("\nClient connected to me!\n");
            //prints after .accept(); becomes true

            //*Input Stream */
            InputStreamReader in = new InputStreamReader(clientSock.getInputStream());
            //*Input Stream reads from Output Stream init in the Client */

            //*Buffer then takes the input from Istream to process it */
            BufferedReader bufRead = new BufferedReader(in);
            String str = bufRead.readLine();
            //*str to store what the Buffere has read */

            //Print the mssg sent from Client, OutStream-Client then InputStream-Server
            //then Buffer-Server then str<-Buffer-Server

            System.out.println("Client says: " + str);
            //Print Client msg
            
            servSock.close();
            clientSock.close();

        } catch (Exception er) {
            er.printStackTrace();
        }
        finally{

        }

    }

}
