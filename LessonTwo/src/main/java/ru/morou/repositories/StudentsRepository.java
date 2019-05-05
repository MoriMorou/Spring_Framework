package ru.morou.repositories;

import org.springframework.stereotype.Component;
import ru.morou.entites.Student;

/**
 * Хранилище (эмитация базы данных)
 */

@Component
public class StudentsRepository {

    public Student findOneByID(int id){
        Student student = new Student();
        student.setFirstName("Ivan " + id);
        student.setLastName("Ivanov " +id);
        return student;
    }
}
