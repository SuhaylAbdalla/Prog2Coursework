import sqlite3
import pandas as pd

# @author lulo166
#not finished yet, need to find a way to integrate the timeframe variable. 

conn = sqlite3.connect('database.db')
cursor = conn.cursor()

query = ("SELECT AVG (duration) FROM study_sessions WHERE start > beginning_timeframe AND end < end_timeframe;")
results = pd.read_sql_query(query,conn)
print(results)

# Saves the changes and closes the connection
conn.commit()
conn.close()