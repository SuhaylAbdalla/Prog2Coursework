import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class database_insert {

    private static final String DB_URL = "jdbc:sqlite:database.db"; // to be edited when correct driver found
    
    public void addCourse(int courseID, String courseName, String courseCode) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("INSERT INTO courses VALUES(" + courseID + ", " + courseName + ", " + courseCode + ");");
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    public void addModule(int moduleID, String moduleName, String moduleCode, int moduleCourseID) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("INSERT INTO modules VALUES(" + moduleID + ", " + moduleName + ", " + moduleCode + ", " + moduleCourseID + ");");
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    public void addAssignment(int assignmentID, String assignmentName, String assignmentDeadline, double assignmentWeight, double gradeReceived, int assignmentModuleID) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("INSERT INTO assignments VALUES(" + assignmentID + ", " + assignmentName + ", " + assignmentDeadline + ", " + assignmentWeight + ", " + gradeReceived + ", " + assignmentModuleID +");");
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    public void addStudySession(int sessionID, String startTime, String endTime, double duration, String location, int productivity, int sessionAssignmentID) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("INSERT INTO study_sessions VALUES(" + sessionID + ", " + startTime + ", " + endTime + ", " + duration + ", " + location + ", " + productivity + ", " + sessionAssignmentID +");");
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}