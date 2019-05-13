SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS students;

CREATE TABLE students (
    id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) DEFAULT NULL,
    PRIMARY KEY(id)
) ENGINE=InnoDB CHARSET=utf8;

DROP TABLE IF EXISTS courses;

CREATE TABLE courses (
    id INT(11) NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) DEFAULT NULL,
    PRIMARY KEY(id)
) ENGINE=InnoDB CHARSET=utf8;

DROP TABLE IF EXISTS marks;

CREATE TABLE marks (
    id INT(11) NOT NULL AUTO_INCREMENT,
    mark INT(11) DEFAULT NULL,
    PRIMARY KEY(id)
) ENGINE=InnoDB CHARSET=utf8;

DROP TABLE IF EXISTS students_courses;

CREATE TABLE students_courses (
    id INT(11) NOT NULL AUTO_INCREMENT,
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    marks INT,
    FOREIGN KEY(student_id) REFERENCES students(id),
    FOREIGN KEY(course_id) REFERENCES courses(id),
    PRIMARY KEY(id)
) ENGINE=InnoDB CHARSET=utf8;

INSERT INTO students (id, name) VALUES (1, "Mori");
INSERT INTO students (id, name) VALUES (2, "Dany");
INSERT INTO students (id, name) VALUES (3, "Mikko");
INSERT INTO students (id, name) VALUES (4, "Lila");

INSERT INTO courses(id, title) VALUES (1, "Java");
INSERT INTO courses(id, title) VALUES (2, "Python");
INSERT INTO courses(id, title) VALUES (3, "AI");
INSERT INTO courses(id, title) VALUES (4, "IOS");

INSERT INTO students_courses(id, student_id, course_id, marks) VALUES (1, 1, 1, 5);
INSERT INTO students_courses(id, student_id, course_id, marks) VALUES (2, 1, 3, 4);
INSERT INTO students_courses(id, student_id, course_id, marks) VALUES (3, 2, 2, 5);
INSERT INTO students_courses(id, student_id, course_id, marks) VALUES (4, 3, 4, 5);
INSERT INTO students_courses(id, student_id, course_id, marks) VALUES (5, 4, 1, 3);
INSERT INTO students_courses(id, student_id, course_id, marks) VALUES (6, 4, 4, 5);