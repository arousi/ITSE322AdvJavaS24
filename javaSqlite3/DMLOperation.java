import java.util.Scanner;
import java.sql.*;

public class DMLOperation {

  static void printTableContent(Connection c) {
    Statement stmt = null;
    String name = "";
    float price = 0.0f;
    int quantity = 0;
    int id;
    try {
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM Product;");
      System.out.println("==============================================");
      System.out.println("ID\t Name\t\t Price\t Qty "); /*Labels */
      while (rs.next()) {
        id = rs.getInt("p_id");
        name = rs.getString("p_name");
        quantity = rs.getInt("quantity");
        price = rs.getFloat("price");
        System.out.println(id + "\t " + name + " \t\t " + price + "\t\t " + quantity);/*Output */
        System.out.println("==============================================");
      }
      rs.close();
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    } finally {
      try {
        if (stmt != null) {
          stmt.close();
        }
      } catch (SQLException e) {
        System.err.println("Error closing statement: " + e.getMessage());
      }
    }
  }

  public static void main(String args[]) {
    String flag = "Y";
    do {
      Connection c = null;
      Statement stmt = null;

      System.out.println("Select DML Operation For Product Table...");
      System.out.println("1. Insert");
      System.out.println("2. Update");
      System.out.println("3. Delete");
      System.out.println("4. Select");
      System.out.println("5. Exit");
      Scanner reader = new Scanner(System.in);
      System.out.println("Enter a choice between 1-6: ");
      int n = reader.nextInt();

      try {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:SqliteJavaDB.db");
        c.setAutoCommit(false);
        stmt = c.createStatement();
        String name = "", sql = "";
        float price = 0.0f;
        int quantity = 0;
        int id;
        Scanner scanName;
        switch (n) {
          case 1: // *Insert */
            printTableContent(c);
            scanName = new Scanner(System.in);
            System.out.println("Enter Product Name:");
            name = scanName.nextLine();
            System.out.println("Enter Product Price:");
            price = scanName.nextFloat();
            System.out.println("Enter Product Quantity:");
            quantity = scanName.nextInt();

            sql = "INSERT INTO Product (p_name,price,quantity) " +
                "VALUES ('" + name + "'," +
                price + "," + quantity + ")";
            stmt.executeUpdate(sql);

            System.out.println("Inserted Successfully!!!\nHere is the data:");
            printTableContent(c);
            // TODO make it in a function to print the data from the table

            // TODO End of function body
            break;
          case 2: // *Update */
            printTableContent(c);
            System.out.println("Enter Product id:");
            scanName = new Scanner(System.in);
            id = scanName.nextInt();
            System.out.println("Enter Product Name:");
            scanName = new Scanner(System.in);
            name = scanName.nextLine();
            System.out.println("Enter Product Price:");
            price = scanName.nextFloat();
            System.out.println("Enter Product Quantity:");
            quantity = scanName.nextInt();

            sql = "UPDATE Product SET p_name = '" + name + "',price=" + price
                + ",quantity=" + quantity +
                " WHERE p_id=" + id;
            stmt.executeUpdate(sql);

            System.out.println("Updated Successfully!!!\nHere is the Updated data:");
            printTableContent(c);
            break;
          case 3: // *Delete */
            System.out.println("Enter Product id:");
            scanName = new Scanner(System.in);

            id = scanName.nextInt();
            sql = "DELETE FROM Product WHERE p_id=" + id + ";";
            stmt.executeUpdate(sql);

            System.out.println("Deleted Successfully!!!");
            break;
          case 4: // *Select and print all table data*/
            printTableContent(c);
            break;
          case 5: // *Exit */
            c.close();
            System.exit(0);
            break;
          default: // *ELSE */
            System.out.println("stupid human!!! Wrong Choice...");
            continue;
        }
        stmt.close();
        c.commit();
        c.close();
      } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
      }
      System.out.println("Continue Y OR N?");
      reader = new Scanner(System.in);
      flag = reader.nextLine();
    } while (flag.equalsIgnoreCase("Y"));
    System.exit(0);
  }
}