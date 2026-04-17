import java.sql.*;
/**
 *
 * @author oluwabukunmi
 * @author lulo166
 */

// HAS NOT BEEN TESTED STILL A WORK IN PROGRESS :P
public class DatabaseConnection {
    
    private static final String DB_URL = "jdbc:sqlite:studytracker.db";
    private static Connection conn = null;
    
    public static Connection getConnection() throws SQLException{
        
        //check if the database doesn't exist yet
        if(conn == null || conn.isClosed()){
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Database connection established");  
        }
        return conn;
    }
    
    public static void closeDatabaseConnection(){
        if(conn !=null){
            try{
                conn.close();
                System.out.println("Database connection closed");
            } catch(SQLException e){
                System.err.println("Error when closing conection : " + e.getMessage());
            }
        }
    }
    
    
    //create all the tables within the database + test
    
    public static void main(String[] args) {
        
        /*also might change to CREATE TABLE IF NOT EXISTS tableName just in
        case??? not sure though comeback to this later
        
        */
        
        //potential user table??? also are we doing email? double check here as well
        
        
        String create_user = "CREATE TABLE users (id_user INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT NOT NULL UNIQUE, username TEXT NOT NULL UNIQUE, password TEXT NOT NULL);";
        
        
        String create_course = "CREATE TABLE courses (id_course INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, course_name TEXT NOT NULL, course_code TEXT NOT NULL);";
        
        
        String create_module = "CREATE TABLE modules (id_module INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, module_name TEXT NOT NULL, module_code TEXT NOT NULL, module_course_id INTEGER NOT NULL, FOREIGN KEY (module_course_id) REFERENCES courses(id_course));";
        
        //assignments include exams as well !!
        String create_assignment = "CREATE TABLE assignments (id_assignment INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, assignment_title TEXT NOT NULL, assignment_deadline DATETIME, assignment_weight FLOAT, grade_received FLOAT, assignment_module_id INTEGER NOT NULL, FOREIGN KEY (assignment_module_id) REFERENCES modules(id_module));";
        
        String create_study_session = "CREATE TABLE study_sessions (id_session INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, start DATETIME NOT NULL, end DATETIME, duration TIME, location Text, productivity INTEGER NOT NULL CHECK(productivity >= 0 AND productivity <11), session_assignment_id INTEGER NOT NULL, FOREIGN KEY (session_assignment_id) REFERENCES assignments(id_assignment));";

        String insert_test = "INSERT INTO courses VALUES (1, 'Computer Science', 'bla');";

        String recovery_test = "SELECT id FROM courses;";
        
        //execute all sql statements 
    
        try(Statement stmt = getConnection().createStatement()){
        stmt.execute(create_user);
        stmt.execute(create_course);
        stmt.execute(create_module);
        stmt.execute(create_assignment);
        stmt.execute(create_study_session);
        stmt.execute(insert_test);
        stmt.execute(recovery_test);
        } catch(SQLException e){
            System.err.println("Error when initialising the database : " + e.getMessage());
        }
    } 
}
