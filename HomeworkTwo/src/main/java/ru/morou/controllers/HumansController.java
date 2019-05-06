package ru.morou.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.morou.entites.Human;
import ru.morou.repositories.HumansRepository;


import java.util.List;

@Controller
@RequestMapping("/humans")
public class HumansController
{
    @Autowired
    private HumansRepository humansRepository;

    @ResponseBody
    @RequestMapping("/list")
    public List<Human> getList(Model uiModel)
    {
        return humansRepository.getHumans();
    }

    @RequestMapping("/form")
    public String showForm(Model uiModel)
    {
        final Human human = new Human();
        uiModel.addAttribute("human", human);
        return "human-form";
    }

    @ResponseBody
    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("humans") Human human) {
        String result = humansRepository.getData(human);
        return result == null ? "Unknown person" : result;
    }
}
