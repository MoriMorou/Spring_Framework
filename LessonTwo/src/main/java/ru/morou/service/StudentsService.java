package ru.morou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.morou.entites.Student;
import ru.morou.repositories.StudentsRepository;

@Service
public class StudentsService {

    private StudentsRepository studentsRepository;

    @Autowired
    public void setStudentsRepository(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public Student getStudentByID(int id){
        Student student = studentsRepository.findOneByID(id);
        return student;
    }
    public StudentsService() {

    }
}
