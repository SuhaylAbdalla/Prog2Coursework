import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class database_init {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/user",
                "username",
                "password"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}