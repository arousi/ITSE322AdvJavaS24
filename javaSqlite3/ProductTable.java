import java.sql.*;

public class ProductTable {
    public static void main(String args[]) {
        Connection c = null;
        Statement stmt = null;
        try {
            System.out.println("Entered try block"); //*custome comment */
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:SqliteJavaDB.db");
            System.out.println("Database Opened...\n");
            stmt = c.createStatement();
            String sql = "CREATE TABLE Product " +
                    "(p_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " p_name TEXT NOT NULL, " +
                    " price REAL NOT NULL, " +
                    " quantity INTEGER) ";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
            System.out.println("Database Closed...\n");
        } catch (Exception e) {
            System.out.println("Entered catch block"); //*custome comment */
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table Product Created Successfully!!!");
    }
}
