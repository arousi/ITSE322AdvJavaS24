
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Connectivity {
    public static void main(String args[]){
        Connection conn = null;
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:SqliteJavaDB.db");
            System.out.println("DB Created/Connected successfuly");//*Custome Comment
        }catch(Exception er){
            System.out.println("/nError");
            System.err.println(er.getClass().getName() + ":" + er.getMessage());
            System.exit(0);
        }
        System.out.println("database successfully created");//*Custome Comment
    }
}
