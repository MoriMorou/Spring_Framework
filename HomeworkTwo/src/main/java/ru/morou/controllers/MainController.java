package ru.morou.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.morou.entites.Human;
import ru.morou.service.HumanService;

@Controller
@RequestMapping("/")
public class MainController {
    private HumanService humanService;

    @Autowired
    public void setHumanService(HumanService humanService) {
        this.humanService = humanService;
    }

    @RequestMapping("/")
    public String showHomePage() {
        return "index";
    }

    @RequestMapping(path = "/add/{sa}/{sb}", method = RequestMethod.GET)
    public String add(Model model, @PathVariable("sa") int a, @PathVariable("sb") int b) {
        return "add";
    }

    @RequestMapping(path = "/addHuman")
    public void setHuman(@RequestBody Human human) {
        System.out.println();
    }
}