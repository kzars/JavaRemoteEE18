CREATE TABLE students(
	sid int NOT NULL,
    name text NOT NULL,
    PRIMARY KEY(sid)
);

CREATE TABLE teachers(
	tid int NOT NULL,
    name text NOT NULL,
    PRIMARY KEY(tid)
);

CREATE TABLE subjects(
	subid int NOT NULL,
    name text NOT NULL,
    PRIMARY KEY (subid)
);

CREATE TABLE grades(
	studentID int NOT NULL,
    teacherID int NOT NULL,
    subjectID int NOT NULL,
    grade int NOT NULL,
    PRIMARY KEY (studentID, teacherID, subjectID),
    FOREIGN KEY (studentID) REFERENCES students(sid),
    FOREIGN KEY (teacherID) REFERENCES teachers(tid),
    FOREIGN KEY (subjectID) REFERENCES subjects(subid)
);

-- Insert data in students table

INSERT INTO students (sid, name) VALUES(1, 'Simon');
INSERT INTO students (sid, name) VALUES(2, 'Alvin');
INSERT INTO students (sid, name) VALUES(3, 'Theo');
INSERT INTO students (sid, name) VALUES(4, 'Brittany');
INSERT INTO students (sid, name) VALUES(5, 'Jenette');
INSERT INTO students (sid, name) VALUES(6, 'Elenor');
INSERT INTO students (sid, name) VALUES(7, 'Stu');

SELECT * FROM students;

-- Insert data in teachers table

INSERT INTO teachers (tid, name) VALUES (1, 'Washington');
INSERT INTO teachers (tid, name) VALUES (2, 'Adams');
INSERT INTO teachers (tid, name) VALUES (3, 'Jefferson');
INSERT INTO teachers (tid, name) VALUES (4, 'Lincoln');

SELECT * FROM teachers;

-- Insert data in subjects table

INSERT INTO subjects (subid, name) VALUES (1, 'History');
INSERT INTO subjects (subid, name) VALUES (2, 'Biology');
INSERT INTO subjects (subid, name) VALUES (3, 'Math');

SELECT * FROM subjects;

-- Insert data in grades table

INSERT INTO grades (studentID, teacherID, subjectID, grade) VALUES (1, 2, 1, 9);
INSERT INTO grades (studentID, teacherID, subjectID, grade) VALUES (1, 2, 2, 10);
INSERT INTO grades (studentID, teacherID, subjectID, grade) VALUES (7, 4, 3, 6);
INSERT INTO grades (studentID, teacherID, subjectID, grade) VALUES (7, 3, 2, 4);
INSERT INTO grades (studentID, teacherID, subjectID, grade) VALUES (6, 2, 1, 5);
INSERT INTO grades (studentID, teacherID, subjectID, grade) VALUES (2, 4, 3, 5);
INSERT INTO grades (studentID, teacherID, subjectID, grade) VALUES (3, 4, 3, 8);
INSERT INTO grades (studentID, teacherID, subjectID, grade) VALUES (1, 2, 3, 10);
INSERT INTO grades (studentID, teacherID, subjectID, grade) VALUES (7, 4, 1, 8);
INSERT INTO grades (studentID, teacherID, subjectID, grade) VALUES (7, 3, 3, 3);
INSERT INTO grades (studentID, teacherID, subjectID, grade) VALUES (6, 2, 2, 5);

SELECT * FROM grades;

-- Cannot add non existing foreign key
INSERT INTO grades (studentID, teacherID, subjectID, grade) VALUES (12, 2, 2, 5);


-- SUM column values

SELECT SUM(grade) FROM grades;

SELECT SUM(grade) AS 'Simons grade sum' FROM grades WHERE studentID IN (SELECT sid FROM students WHERE name = 'Simon');


-- Print Students all info in order by name

SELECT * from students ORDER by name;

-- What is Biology id?

SELECT subid FROM subjects WHERE name = 'biology';

-- Grade in History for Simon

SELECT grade AS 'Simons grade for History' FROM grades WHERE subjectID = 1 AND studentID = 1;
SELECT grade AS 'Simons grade for History' FROM grades WHERE subjectID IN (SELECT subid FROM subjects WHERE name = 'History' ) AND studentID IN (SELECT sid FROM students WHERE name = 'Simon' );

-- Names of students who have not yet taken any class (not hardcoding sid 4 and 5)

SELECT name FROM students WHERE sid NOT IN (SELECT studentID FROM grades);
-- SELECT * FROM students WHERE name NOT IN(SELECT grades from grade);


-- Names of teachers that have not yet taught any class

-- Names of teachers who have taught Biology (sub sub query)

-- Names of students who have  taken at least one class



