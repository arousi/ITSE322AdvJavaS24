import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.BorderLayout;
import java.sql.ResultSet;

public class DMLOperationGUI extends JFrame implements ActionListener {

    public static Connection createTableGetConn() {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:SqliteJavaDB.db");
            System.out.println("\n[DB Created/Connected successfuly]");
        } catch (Exception er) {
            System.out.println("/nError");
            System.err.println(er.getClass().getName() + ":" + er.getMessage());
            System.exit(0);
        }
        return connection;
    }

    private Connection connection;
    private final JButton insertButton;
    private final JButton updateButton;
    private final JButton deleteButton;
    private final JButton selectButton;
    private final JTextArea outputTextArea;
    private final JTextField nameField;
    private final JTextField priceField;
    private final JTextField quantityField;
    private final JTextField idField;


    public DMLOperationGUI(Connection connection) throws SQLException {
        this.connection = connection;

        // Initialize UI components
        
        outputTextArea = new JTextArea(7, 35);

        nameField = new JTextField(15);
        priceField = new JTextField(10);
        quantityField = new JTextField(10);
        idField = new JTextField(10);

        insertButton = new JButton("Insert");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        selectButton = new JButton("Select");

        // Add action listeners
        insertButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        selectButton.addActionListener(this);

        // Layout components
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(insertButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(selectButton);

        JPanel inputPanel = new JPanel();

        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(priceField);

        inputPanel.add(new JLabel("Quantity:"));
        inputPanel.add(quantityField);

        inputPanel.add(new JLabel("ID (Update/Delete):"));
        inputPanel.add(idField);

        JPanel outputPanel = new JPanel();
        outputPanel.add(new JScrollPane(outputTextArea));

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(buttonPanel, BorderLayout.NORTH);
        getContentPane().add(inputPanel, BorderLayout.CENTER);
        getContentPane().add(outputPanel, BorderLayout.SOUTH);

        // Set window properties
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String action = e.getActionCommand();
            switch (action) {
                case "Insert":
                    // **Insert product functionality**
                    String name = nameField.getText();
                    float price = Float.parseFloat(priceField.getText());
                    int quantity = Integer.parseInt(quantityField.getText());
                    insertProduct(connection, name, price, quantity);
                    outputTextArea.setText("Product Inserted Successfully!");
                    printTableContent(connection, outputTextArea); // Update table after insert
                    break;
                case "Update":
                    // **Update product functionality**
                    name = nameField.getText();
                    price = Float.parseFloat(priceField.getText());
                    quantity = Integer.parseInt(quantityField.getText());
                    int id = Integer.parseInt(idField.getText());
                    updateProduct(connection, id, name, price, quantity);
                    outputTextArea.setText("Product Updated Successfully!");
                    printTableContent(connection, outputTextArea); // Update table after update
                    break;
                case "Delete":
                    // **Delete product functionality**
                    id = Integer.parseInt(idField.getText());
                    deleteProduct(connection, id);
                    outputTextArea.setText("Product Deleted Successfully!");
                    printTableContent(connection, outputTextArea); // Update table after delete
                    break;
                case "Select":
                    // **Select and display product data functionality**
                    printTableContent(connection, outputTextArea);
                    break;
            }
            // Clear input fields after successful operations
            nameField.setText("");
            priceField.setText("");
            quantityField.setText("");
            idField.setText("");
        } catch (Exception ex) {
            // Handle
        }
    }

    private void insertProduct(Connection connection, String name, float price, int quantity) throws SQLException {
        // Enable auto-commit to simplify the example (consider using transactions for
        // real applications)
        connection.setAutoCommit(true);

        String sql = "INSERT INTO Product (p_name, price, quantity) VALUES ('" + name + "', " + price + ", " + quantity
                + ")";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);

        // No need to commit as auto-commit is enabled
    }

    private void updateProduct(Connection connection, int id, String name, float price, int quantity)
            throws SQLException {
        // Enable auto-commit to simplify the example (consider using transactions for
        // real applications)
        connection.setAutoCommit(true);

        String sql = "UPDATE Product SET p_name='" + name + "', price=" + price + ", quantity=" + quantity
                + " WHERE p_id=" + id;
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);

        // No need to commit as auto-commit is enabled
    }

    private void deleteProduct(Connection connection, int id) throws SQLException {

        // Consider using transactions for real applications to ensure data integrity
        try (Statement statement = connection.createStatement()) {
            String sql = "DELETE FROM Product WHERE p_id=" + id;
            statement.executeUpdate(sql);
        } catch (SQLException sqle) {
            // Handle specific SQL exceptions (e.g., foreign key constraint violation)
            outputTextArea.setText("Error deleting product: " + sqle.getMessage());
            // Consider checking for specific error codes (e.g., ORA-02292 for foreign key
            // constraint violation)
            // and providing more informative messages
            throw sqle; // Re-throw the exception for caller handling (consider if needed)
        }
    }

    private void printTableContent(Connection connection, JTextArea outputTextArea) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM Product";
            ResultSet resultSet = statement.executeQuery(sql);

            // Clear the output area before displaying new data
            outputTextArea.setText("");

            // Iterate through the result set and display product information
            while (resultSet.next()) {
                int productId = resultSet.getInt("p_id");
                String productName = resultSet.getString("p_name");
                float productPrice = resultSet.getFloat("price");
                int productQuantity = resultSet.getInt("quantity");

                String productInfo = String.format("ID: %d     Name: %s\t Price: %.2f\t Quantity: %d\n", productId,
                        productName, productPrice, productQuantity);
                outputTextArea.append(productInfo);
            }
        }
    }

    public static void main(String args[]) throws SQLException {
        Connection c = null;
        c = createTableGetConn();
        DMLOperationGUI gui = new DMLOperationGUI(c);
    }
}