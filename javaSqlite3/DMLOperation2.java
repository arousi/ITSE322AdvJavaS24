import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.*;


public class DMLOperation2 {

    static Connection createTableGetConn() throws SQLException {
        Connection connLink = null;
        connLink = DriverManager.getConnection("jdbc:sqlite:SqliteJavaDB.db");
        System.out.println("\n[DB Created/Connected successfully]");
        return connLink;
    }

    static void printTableContent(Connection c) {
        String sql = "SELECT * FROM Product;";
        try (Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("===================================================");
            System.out.println("ID\t Name\t\t Price\t\t Qty "); /* Labels */
            while (rs.next()) {
                int id = rs.getInt("p_id");
                String name = rs.getString("p_name");
                int quantity = rs.getInt("quantity");
                float price = rs.getFloat("price");
                /* Output */
                System.out.println(id + "\t " + name + " \t\t " + price + "\t\t " + quantity);
                System.out.println("-------------------------------------------------");
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        }
        System.out.println("===================================================");
    }

    static void insertProduct(Connection c, Scanner scanner) {
        printTableContent(c);
        try {
            System.out.println("Enter Product Name:");
            String name = scanner.nextLine();
            System.out.println("Enter Product Price:");
            float price = scanner.nextFloat();
            System.out.println("Enter Product Quantity:");
            int quantity = scanner.nextInt();

            String sql = "INSERT INTO Product (p_name, price, quantity) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = c.prepareStatement(sql)) {
                pstmt.setString(1, name);
                pstmt.setFloat(2, price);
                pstmt.setInt(3, quantity);
                pstmt.executeUpdate();
            }

            System.out.println("Inserted Successfully!!!\nHere is the data:");
            printTableContent(c);
        } catch (SQLException | InputMismatchException e) {
            System.err.println("Error inserting product: " + e.getMessage());
        }
    }

    static void updateProduct(Connection c, Scanner scanner) {
        printTableContent(c);
        try {
            System.out.println("Enter Product id:");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            System.out.println("Enter Product Name:");
            String name = scanner.nextLine();
            System.out.println("Enter Product Price:");
            float price = scanner.nextFloat();
            System.out.println("Enter Product Quantity:");
            int quantity = scanner.nextInt();

            String sql = "UPDATE Product SET p_name = ?, price = ?, quantity = ? WHERE p_id = ?";
            try (PreparedStatement pstmt = c.prepareStatement(sql)) {
                pstmt.setString(1, name);
                pstmt.setFloat(2, price);
                pstmt.setInt(3, quantity);
                pstmt.setInt(4, id);
                pstmt.executeUpdate();
            }

            System.out.println("Updated Successfully!!!\nHere is the Updated data:");
            printTableContent(c);
        } catch (SQLException | InputMismatchException e) {
            System.err.println("Error updating product: " + e.getMessage());
        }
    }

    static void deleteProduct(Connection c, Scanner scanner) {
        try {
            printTableContent(c);
            System.out.println("Enter Product id:");
            int id = scanner.nextInt();

            String sql = "DELETE FROM Product WHERE p_id = ?";
            try (PreparedStatement pstmt = c.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            }

            System.out.println("Deleted Successfully!!!");
        } catch (SQLException | InputMismatchException e) {
            System.err.println("Error deleting product: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String flag = "Y";
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                try {
                    Connection c = createTableGetConn();
                    c.setAutoCommit(false);

                    System.out.println("Select DML Operation For Product Table..");
                    System.out.println("1. Insert\n2. Update\n3. Delete\n4. Select\n5. Exit");

                    System.out.println("Enter a choice between 1-5: ");
                    int n = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over

                    switch (n) {
                        case 1: // Insert
                            insertProduct(c, scanner);
                            break;
                        case 2: // Update
                            updateProduct(c, scanner);
                            break;
                        case 3: // Delete
                            deleteProduct(c, scanner);
                            break;
                        case 4: // Select
                            printTableContent(c);
                            break;
                        case 5: // Exit
                            c.close();
                            System.exit(0);
                        default:
                            System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                            continue;
                    }
                    c.commit();
                    c.close();
                } catch (SQLException | InputMismatchException e) {
                    System.err.println("Error: " + e.getMessage());
                    System.exit(1);
                }

                System.out.println("Continue Y OR N?");
                flag = scanner.nextLine();
            } while (flag.equalsIgnoreCase("Y"));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}
