import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class database_init {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/", // find the driver
                "username",
                "password"
            );

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE DATABASE user;");
            stmt.executeUpdate("CREATE TABLE courses (
                                    id_course INTEGER NOT NULL PRIMARY KEY,
                                    course_name TEXT NOT NULL,
                                    course_code TEXT NOT NULL);");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}