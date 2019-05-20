SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS students;

CREATE TABLE students (
    id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) DEFAULT NULL,
    score INT(11) NOT NULL,
    PRIMARY KEY(id)
) ENGINE=InnoDB CHARSET=utf8;