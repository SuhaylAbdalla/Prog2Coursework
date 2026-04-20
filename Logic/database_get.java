import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class database_get {

    private static final String DB_URL = "jdbc:sqlite:database.db"; // to be edited when correct driver found

    public String getAllLocations() { // gets all locations that have been studied at
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT location FROM study_sessions;");
            closeDatabaseConnection() // added the code to close the connection to the db
            return result.getString(1);
        }
        catch (Exception e) {
            return e.toString();
        }
    }
    
    public String getTopLocations() { // gets the locations most frequently studied at
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT location, COUNT(id_session) AS [TimesStudiedAt] FROM study_sessions GROUP BY location;");
            closeDatabaseConnection() // added the code to close the connection to the db
            return result.getString(1); // temporary; currently only returns the locations
        }
        catch (Exception e) {
            return e.toString();
        }
    }

    public String getProductiveTimes() { // gets the times most frequently studied at - needs date attribute in the study_sessions table to work effectively
         try {
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT start, COUNT(id_session) AS [TimesStudiedAt] FROM study_sessions GROUP BY start;");
            closeDatabaseConnection() // added the code to close the connection to the db
            return result.getString(1); // temporary; currently only returns the start times
        }
        catch (Exception e) {
            return e.toString();
        }
    }

    public String getAverageProductivityByLocation() { // gets the average productivity at each location
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT location, AVG(productivity) AS [averageProductivity] FROM study_sessions GROUP BY location;");
            closeDatabaseConnection() // added the code to close the connection to the db
            return result.getString(1);
        }
        catch (Exception e) {
            return e.toString();
        }
    }

    public double getStudyHours(String timeframe) { // gets the number of hours studied in a given timeframe
        return 0.0;
    } // SELECT AVG (duration) FROM study_sessions WHERE start > beginning_timeframe AND end < end_timeframe;
}