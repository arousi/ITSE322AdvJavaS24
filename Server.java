import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server started. Waiting for client...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // Create input and output streams for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read radius from the client
            double radius = Double.parseDouble(in.readLine());
            System.out.println("Received radius: " + radius);

            // Calculate area
            double area = Math.PI * radius * radius;

            // Send the area back to the client
            out.println(area);
            System.out.println("Sent area: " + area);

            // Close the connections
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}