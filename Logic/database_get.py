import sqlite3, pandas as pd

def getAllLocations():
    conn = sqlite3.connect('database.db')
    cursor = conn.cursor()

    query = ("SELECT location FROM study_sessions;")
    results = pd.read_sql_query(query,conn)
    print(results)

    # Saves the changes and closes the connection
    conn.commit()
    conn.close()

def getTopLocations():
    conn = sqlite3.connect('database.db')
    cursor = conn.cursor()

    query = ("SELECT location, COUNT(id_session) AS [TimesStudiedAt] FROM study_sessions GROUP BY location;")
    results = pd.read_sql_query(query,conn)
    print(results)

    # Saves the changes and closes the connection
    conn.commit()
    conn.close()
    
def getProductiveTimes():
    conn = sqlite3.connect('database.db')
    cursor = conn.cursor()

    query = ("SELECT start, COUNT(id_session) AS [TimesStudiedAt] FROM study_sessions GROUP BY start;")
    results = pd.read_sql_query(query,conn)
    print(results)

    # Saves the changes and closes the connection
    conn.commit()
    conn.close()

def getAverageProductivityByLocation():
    conn = sqlite3.connect('database.db')
    cursor = conn.cursor()

    query = ("SELECT location, AVG(productivity) AS [averageProductivity] FROM study_sessions GROUP BY location;")
    results = pd.read_sql_query(query,conn)
    print(results)

    # Saves the changes and closes the connection
    conn.commit()
    conn.close()

def getStudyHours(beginning_timeframe, end_timeframe):
    conn = sqlite3.connect('database.db')
    cursor = conn.cursor()

    query = ("SELECT AVG(duration) FROM study_sessions WHERE start >= " + beginning_timeframe + " AND end <= " + end_timeframe + ";")
    results = pd.read_sql_query(query,conn)
    print(results)

    # Saves the changes and closes the connection
    conn.commit()
    conn.close()