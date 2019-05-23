package ru.morou.services;

import ru.morou.entities.Course;
import ru.morou.entities.Student;
import ru.morou.repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {
    private StudentsRepository studentsRepository;

    private CoursesService coursesService;

    @Autowired
    public void setStudentsRepository(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Autowired
    public void setCoursesService(CoursesService coursesService) {
        this.coursesService = coursesService;
    }

    public StudentsService() {
    }

    public List<Student> getAllStudentsList() {
        return (List<Student>)studentsRepository.findAll();
    }

    public void addStudent(Student s) {
        studentsRepository.save(s);
    }

    public void removeById(Long id) {
        studentsRepository.deleteById(id);
    }

    public List<Course> getCoursesByStudentId(Long id) {
        return studentsRepository.findOneById(id).getCourses();
    }

    public List<Course> getMissingCoursesByStudentId(Long id) {
        List<Course> courses = coursesService.getAllCourses();
        List<Course> studentsCourses = studentsRepository.findOneById(id).getCourses();
        courses.removeAll(studentsCourses);
        return courses;
    }
}
