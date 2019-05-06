package ru.morou.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.morou.entites.Human;
import ru.morou.service.HumansService;

@Controller
@RequestMapping("/human")
public class HumansController {
    private HumansService humansService;

    @Autowired
    public void setHumansService(HumansService humansService) {
        this.humansService = humansService;
    }

    @RequestMapping("/showHuman")
    public String hello(Model uiModel, @ModelAttribute("human") Human human) {
        human = humansService.getHumanByID(10);
        uiModel.addAttribute("human", human);
        System.out.println(human.getFirstName() + " " + human.getLastName());
        return "humans";
    }

    // запрос через ? знак (/showStudentByID?id=7
//    @RequestMapping(path = "/showHumanByID", method = RequestMethod.GET)
//    @ResponseBody
//    public Human showStudentByID(Model uiModel, @RequestParam int id) {
//        Human human = studentsService.getStudentByID(id);
//        return human;
//    }

    // запрос через / (то есть /showStudentByID/7)
    @RequestMapping(path = "/showHumanByID/{sid}", method = RequestMethod.GET)
    @ResponseBody
    public Human showHumanById(@PathVariable("sid") int id) {
        Human human = humansService.getHumanByID(id);
        return human;
    }

    // Отличия RequestMethod.GET от RequestMethod.POST в том что в get передача id, а в post передача объекта
    // Например для регистрации или авторизации
    @RequestMapping(path = "/setHumanByID", method = RequestMethod.POST)
    public void setHuman(@RequestBody Human human) {
        System.out.println(human.getFirstName() + " " + human.getLastName());
    }

    @RequestMapping("/showForm")
    public String showSimpleForm(Model uiModel) {
        Human human = new Human();
        uiModel.addAttribute("human", human);
        return "human-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("human") Human human) {
        return "human-form-result";
    }
}
