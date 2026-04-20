import sqlite3

# @author lulo166

# Connexion to the DB (or creation if it doesn't exist)
conn = sqlite3.connect('database.db')
cursor = conn.cursor()

# Create the different tables of the database

# Is there a course code for computer science, I can't find one ?
cursor.execute('''
CREATE TABLE courses (
    id_course INTEGER NOT NULL PRIMARY KEY,
    course_name TEXT NOT NULL,
    course_code TEXT NOT NULL 
);
''')

cursor.execute('''
CREATE TABLE modules (
    id_module INTEGER NOT NULL PRIMARY KEY,
    module_name TEXT NOT NULL,
    module_code TEXT NOT NULL,
    module_course_id INTEGER NOT NULL,
    FOREIGN KEY (module_course_id) REFERENCES courses (id_course)
);
''')

# exams count as assignment, at least in the back end
cursor.execute('''
CREATE TABLE assignments (
    id_assignment INTEGER NOT NULL PRIMARY KEY,
    assignment_title TEXT NOT NULL,
    assignment_deadline DATETIME,
    assignment_weight FLOAT,
    grade_received FLOAT,
    assignment_module_id INTEGER NOT NULL,
    FOREIGN KEY (assignment_module_id) REFERENCES modules (id_module)
);
''')

# For now, you cannot have multiple assignment per study session
cursor.execute('''
CREATE TABLE study_sessions (
    id_session INTEGER NOT NULL PRIMARY KEY,
    start DATETIME NOT NULL,
    end DATETIME,
    duration TIME,
    location TEXT,
    productivity INTEGER NOT NULL CHECK (productivity > 0 AND productivity < 11),
    session_assignment_id INTEGER NOT NULL,
    FOREIGN KEY (session_assignment_id) REFERENCES assignments (id_assignment)
);
''')



# need system for automated id numbering
cursor.execute('''
INSERT INTO courses VALUES (1, "Computer Science", "bla");
''')

cursor.execute('''
INSERT INTO modules VALUES (5, "Programming 2", "CM12005", 1);
''')

cursor.execute('''
INSERT INTO assignments VALUES (2, "Prog 2 CW 2", '2026-05-01 20:00:00.000', 50.0, NULL, 5);
''')

# need to code the duration to autocomplete
cursor.execute('''
INSERT INTO study_sessions VALUES (4, '2026-04-13 12:35:00.000', NULL, NULL, "My room", 8, 2);
''')

print (cursor.execute('''
SELECT id_session FROM study_sessions;
'''))

# Saves the changes and closes the connection
conn.commit()
conn.close()