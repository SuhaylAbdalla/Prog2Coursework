
public class database_get {
    
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
    } // SELECT duration FROM study_sessions WHERE start > beginning_timeframe AND end < end_timeframe; use AVG
}