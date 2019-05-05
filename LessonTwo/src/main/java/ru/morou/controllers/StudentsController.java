package ru.morou.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.morou.entites.Student;
import ru.morou.service.StudentsService;

@Controller
@RequestMapping("/student")
public class StudentsController {
    private StudentsService studentsService;

    @Autowired
    public void setStudentsService(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @RequestMapping("/showStudent")
    public String hello(Model uiModel, @ModelAttribute("student") Student student) {
        student = studentsService.getStudentByID(10);
        uiModel.addAttribute("student", student);
        System.out.println(student.getFirstName() + " " + student.getLastName());
        return "students";
    }
}
