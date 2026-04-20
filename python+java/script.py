import sqlite3
import pandas as pd

# @author lulo166

# Connexion to the DB (or creation if it doesn't exist)
conn = sqlite3.connect('databaseTest.db')
cursor = conn.cursor()

query = ("SELECT id_session FROM study_sessions;")
results = pd.read_sql_query(query,conn)
print(results)

# Saves the changes and closes the connection
conn.commit()
conn.close()