import sqlite3

# @author lulo166

# Connexion to the DB (or creation if it doesn't exist)
conn = sqlite3.connect('database.db')
cursor = conn.cursor()

# Commands to add values to the db, use as a template

# need system for automated id numbering
cursor.execute('''
INSERT INTO courses VALUES (1, "Computer Science", "bla");
''')

cursor.execute('''
INSERT INTO modules VALUES (5, "Programming 2", "CM12005", 1);
);
''')

cursor.execute('''
INSERT INTO assignments VALUES (2, "Prog 2 CW 2", '2026-05-01 20:00:00.000', 50.0, NULL, 5);
''')

# need to code the duration to autocomplete
cursor.execute('''
INSERT INTO study_sessions VALUES (4, '2026-04-13 12:35:00.000', NULL, NULL, "My room", 8, 2);
''')


# Saves the changes and closes the connection
conn.commit()
conn.close()