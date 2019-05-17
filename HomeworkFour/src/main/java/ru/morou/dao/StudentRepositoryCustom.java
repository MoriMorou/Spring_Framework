package ru.morou.dao;

import ru.morou.entities.Student;

import java.util.List;

public interface StudentRepositoryCustom {
    List<Student> getByName(String name);
    List<Student> getMaxScore();
}