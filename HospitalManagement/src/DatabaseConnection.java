import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    final static String user = "root";
    final static String password = "SQL@$trong01";
    final static  String dbUrl = "jdbc:mysql://localhost:3306/hospital";

    public static Connection getConnection(){
        Connection conn = null;

        System.out.println("\n------------------Connecting Database------------------\n");
        try {
            conn = DriverManager.getConnection(dbUrl, user, password);
            System.out.println("\n------------------Connection Successful------------------\n");

        } catch (SQLException e) {
            System.out.println("Connection Failed" + e);
        }

        return conn;
    }
}
