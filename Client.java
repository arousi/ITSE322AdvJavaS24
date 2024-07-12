import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);

            
            // Create input and output streams for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read radius from the user
            double radius = 10.0; // You can change the radius value here or take input from the user
            System.out.println("Sending radius: " + radius);

            // Send the radius to the server
            out.println(radius);

            // Receive the area from the server
            double area = Double.parseDouble(in.readLine());
            System.out.println("Received area: " + area);

            // Close the connection
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}