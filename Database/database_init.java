import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class database_init {
    public static void main(String[] args) {
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/",
            "username",
            "password"
        );

        Statement stmt = conn.createStatement();
        stmt.executeUpdate("CREATE DATABASE user");
    }
}