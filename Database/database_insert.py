import sqlite3

def addCourse(courseName, courseCode):
    conn = sqlite3.connect('database.db')
    cursor = conn.cursor()
    query = "INSERT INTO courses(course_name, course_code) VALUES('" + courseName + "', '" + courseCode + "');"
    cursor.execute(query)
    # Saves the changes and closes the connection
    conn.commit()
    conn.close()
    
def addModule(moduleName, moduleCode, moduleCourseID):
    conn = sqlite3.connect('database.db')
    cursor = conn.cursor()
    query = ("INSERT INTO modules(module_name, module_code, module_course_id) VALUES(" + moduleName + ", " + moduleCode + ", " + moduleCourseID + ");")
    cursor.execute(query)
    # Saves the changes and closes the connection
    conn.commit()
    conn.close()
    
def addAssignment(assignmentName, assignmentDeadline, assignmentWeight, gradeReceived, assignmentModuleID):
    conn = sqlite3.connect('database.db')
    cursor = conn.cursor()
    query = ("INSERT INTO assignments(assignment_name, assignment_deadline, assignment_weight, grade_received, assignment_module_id) VALUES(" + assignmentName + ", " + assignmentDeadline + ", " + assignmentWeight + ", " + gradeReceived + ", " + assignmentModuleID + ");")
    cursor.execute(query)
    # Saves the changes and closes the connection
    conn.commit()
    conn.close()

def addStudySession(startTime, endTime, duration, location, productivity, sessionAssignmentID):
    conn = sqlite3.connect('database.db')
    cursor = conn.cursor()
    query = ("INSERT INTO study_sessions(start, end, duration, location, productivity, session_assignment_id) VALUES(" + startTime + ", " + endTime + ", " + duration + ", " + location + ", " + productivity + ", " + sessionAssignmentID + ");")
    cursor.execute(query)
    # Saves the changes and closes the connection
    conn.commit()
    conn.close()