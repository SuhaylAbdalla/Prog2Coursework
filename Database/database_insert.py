import sqlite3

def addCourse(courseID, courseName, courseCode):
    conn = sqlite3.connect('database.db')
    cursor = conn.cursor()
    query = ("INSERT INTO courses VALUES(" + courseID + ", " + courseName + ", " + courseCode + ");")
    cursor.execute(query)
    # Saves the changes and closes the connection
    conn.commit()
    conn.close()
    
def addModule(moduleID, moduleName, moduleCode, moduleCourseID):
    conn = sqlite3.connect('database.db')
    cursor = conn.cursor()
    query = ("INSERT INTO modules VALUES(" + moduleID + ", " + moduleName + ", " + moduleCode + ", " + moduleCourseID + ");")
    cursor.execute(query)
    # Saves the changes and closes the connection
    conn.commit()
    conn.close()
    
def addAssignment(assignmentID, assignmentName, assignmentDeadline, assignmentWeight, gradeReceived, assignmentModuleID):
    conn = sqlite3.connect('database.db')
    cursor = conn.cursor()
    query = ("INSERT INTO assignments VALUES(" + assignmentID + ", " + assignmentName + ", " + assignmentDeadline + ", " + assignmentWeight + ", " + gradeReceived + ", " + assignmentModuleID + ");")
    cursor.execute(query)
    # Saves the changes and closes the connection
    conn.commit()
    conn.close()

def addStudySession(sessionID, startTime, endTime, duration, location, productivity, sessionAssignmentID):
    conn = sqlite3.connect('database.db')
    cursor = conn.cursor()
    query = ("INSERT INTO study_sessions VALUES(" + sessionID + ", " + startTime + ", " + endTime + ", " + duration + ", " + location + ", " + productivity + ", " + sessionAssignmentID + ");")
    cursor.execute(query)
    # Saves the changes and closes the connection
    conn.commit()
    conn.close()