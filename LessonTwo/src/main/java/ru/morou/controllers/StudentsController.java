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

    // запрос через ? знак (/showStudentByID?id=7
//    @RequestMapping(path = "/showStudentByID", method = RequestMethod.GET)
//    @ResponseBody
//    public Student showStudentByID(Model uiModel, @RequestParam int id) {
//        Student student = studentsService.getStudentByID(id);
//        return student;
//    }

    // запрос через / (то есть /showStudentByID/7)
    @RequestMapping(path = "/showStudentByID/{sid}", method = RequestMethod.GET)
    @ResponseBody
    public Student showStudentById(@PathVariable("sid") int id) {
        Student student = studentsService.getStudentByID(id);
        return student;
    }

    // Отличия RequestMethod.GET от RequestMethod.POST в том что в get передача id, а в post передача объекта
    // Например для регистрации или авторизации
    @RequestMapping(path = "/setStudentByID", method = RequestMethod.POST)
    public void setStudent(@RequestBody Student student) {
        System.out.println(student.getFirstName() + " " + student.getLastName());
    }

    @RequestMapping("/showForm")
    public String showSimpleForm(Model uiModel) {
        Student student = new Student();
        uiModel.addAttribute("student", student);
        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student) {
        return "student-form-result";
    }
}
