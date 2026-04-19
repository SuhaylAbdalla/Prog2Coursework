import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class database_init {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
             Statement stmt = conn.createStatement()) {
            // Creates the db in the current directory, unsure if this needs changing or not

            // Creates the different tables of the db
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS courses (
                    course_id INTEGER NOT NULL PRIMARY KEY,
                    course_name TEXT NOT NULL,
                    course_code TEXT NOT NULL
                );
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS modules (
                    module_id INTEGER NOT NULL PRIMARY KEY,
                    module_name TEXT NOT NULL,
                    module_code TEXT NOT NULL,
                    module_course_id INTEGER NOT NULL,
                    FOREIGN KEY (module_course_id) REFERENCES courses (id_course)
                );
            """);

            // Exams count as assignment
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS assignments (
                    assignment_id INTEGER  NOT NULL PRIMARY KEY,
                    assignment_title TEXT NOT NULL,
                    assignment_deadline DATETIME,
                    assignment_weight REAL,
                    grade_received REAL,
                    assignment_module_id INTEGER NOT NULL,
                    FOREIGN KEY (assignment_module_id) REFERENCES modules (id_module)
                );
            """);

            // Can't have multiple assignments per session
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS study_sessions (
                    session_id INTEGER  NOT NULL PRIMARY KEY,
                    start DATETIME NOT NULL,
                    end DATETIME,
                    duration TIME,
                    location TEXT,
                    productivity INTEGER  NOT NULL CHECK (productivity > 0 AND productivity < 11),
                    session_assignment_id INTEGER NOT NULL,
                    FOREIGN KEY (session_assignment_id) REFERENCES assignments (id_assignment)
                );
            """);

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
        // Connection automatically closed by try statement
    }
}
