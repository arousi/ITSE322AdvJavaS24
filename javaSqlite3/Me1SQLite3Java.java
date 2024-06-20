import java.beans.Statement;
import java.sql.Connection;
import java.util.Scanner;

import javax.sql.DataSource;

public class Me1SQLite3Java {
    public static void main(String[] args) {
        Connection conlink = null;
        Statement stmt = null;

        System.out.println("Select DML Operation For Product Table...");
        System.out.println("1. Insert\n2. Update\n3. Delete\n4. Select\n5. Exit");
        System.out.println("Enter a choice between 1-6: ");

        Scanner scn = new Scanner(System.in);
        int tempVar = reader.nextInt();

        try {
            Class.forName("org.sqlite.JDBC");
            conlink = DataSource.class.GETCONNEC
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
