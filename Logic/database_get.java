import java.sql.*;
public class database_get {

    public String getAllLocations() { // gets all locations that have been studied at
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/", // find the driver
                "username",
                "password"
            );
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("select location from study_sessions;");
            return result.getString(1);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String[] getTopLocations() { // gets the locations most frequently studied at
        String[] topLocations = {};
        return topLocations;
    } // SELECT location FROM study_sessions;

    public String[] getProductiveTimes() { // gets the times most frequently studied at 
        String[] productiveTimes = {};
        return productiveTimes;
    } // SELECT start, end, duration FROM study_sessions; use aggregations

    public double getAverageFocusTime(String timeframe) { // gets the average focus time of study sessions in a given timeframe
        return 0.0;
    } // talk to requirements

    public double getStudyHours(String timeframe) { // gets the number of hours studied in a given timeframe
        return 0.0;
    } // SELECT AVG (duration) FROM study_sessions WHERE start > beginning_timeframe AND end < end_timeframe;
}