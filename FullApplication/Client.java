package FullApplication;

import java.net.*;
import java.io.*;

public class Client{
    public static void main(String[] args) {
        try{
            Socket clientSock = new Socket("localhost",5555);
    
        }catch(IOException er){
            er.printStackTrace();
        }
    }
    

}