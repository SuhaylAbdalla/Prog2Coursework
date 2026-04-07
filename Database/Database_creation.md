CREATE TABLE courses (
    id_course INTEGER NOT NULL PRIMARY KEY,
    course_name TEXT NOT NULL,
    course_code TEXT NOT NULL
);

CREATE TABLE modules (
    id_module INTEGER NOT NULL PRIMARY KEY,
    module_name TEXT NOT NULL,
    module_code TEXT NOT NULL,
    module_course_id INTEGER NOT NULL,
    FOREIGN KEY (module_course_id) REFERENCES courses (id_course)
);

# exams count as assignment, at least in the back end
CREATE TABLE assignments (
    id_assignment INTEGER NOT NULL PRIMARY KEY,
    assignment_title TEXT NOT NULL,
    assignment_deadline DATETIME,
    assignment_weight FLOAT,
    grade_received FLOAT,
    assignment_module_id INTEGER NOT NULL,
    FOREIGN KEY (assignment_module_id) REFERENCES modules (id_module)
);

# For now, you cannot have multiple assignment per study session 
CREATE TABLE study_sessions (
    id_session INTEGER NOT NULL PRIMARY KEY,
    start DATETIME NOT NULL,
    end DATETIME,
    duration DATETIME,
    session_assignment_id INTEGER NOT NULL,
    FOREIGN KEY (session_assignment_id) REFERENCES assignments (id_assignment)
);