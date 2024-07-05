package FullApplication;

import java.net.*;
import java.io.*;

public class Client{
    try{
        Socket clientSock = new Socket("localhost",5555);

    }catch(IOException er){
        er.printStackTrace();
    }

}