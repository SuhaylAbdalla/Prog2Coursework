import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LogicJava {

    public String getAllLocations() { // gets all locations that have been studied at
        try {
            ProcessBuilder pb = new ProcessBuilder("python", "getAllLocations.py");
            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            int exitCode = process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public String getTopLocations() { // gets the locations most frequently studied at
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT location, COUNT(id_session) AS [TimesStudiedAt] FROM study_sessions GROUP BY location;");
            conn.close();
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
            conn.close();
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
            conn.close();
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