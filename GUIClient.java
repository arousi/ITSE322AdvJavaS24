import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class GUIClient {
    private static JTextField radiusTextField;
    private static JLabel resultLabel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle Area Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel radiusLabel = new JLabel("Enter radius:");
        radiusTextField = new JTextField(10);
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());

        inputPanel.add(radiusLabel);
        inputPanel.add(radiusTextField);
        inputPanel.add(calculateButton);

        resultLabel = new JLabel();

        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(resultLabel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private static class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String serverAddress = "localhost";
            int serverPort = 12345;
            //*This here is the client code */
            //TODO should make it call the server file with some await
            
            try {
                Socket socket = new Socket(serverAddress, serverPort);
                // Create input and output streams for communication
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Read radius from the text field
                double radius = Double.parseDouble(radiusTextField.getText());

                // Send the radius to the server
                out.println(radius);

                // Receive the area from the server
                double area = Double.parseDouble(in.readLine());
                resultLabel.setText("Area: " + area);

                // Close the connection
                in.close();
                out.close();
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}