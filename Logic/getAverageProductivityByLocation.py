import sqlite3
import pandas as pd

# @author lulo166
#not finished yet

conn = sqlite3.connect('database.db')
cursor = conn.cursor()

query = ("SELECT location, AVG(productivity) AS [averageProductivity] FROM study_sessions GROUP BY location;")
results = pd.read_sql_query(query,conn)
print(results)

# Saves the changes and closes the connection
conn.commit()
conn.close()