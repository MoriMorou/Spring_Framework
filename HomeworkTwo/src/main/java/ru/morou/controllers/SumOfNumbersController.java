package ru.morou.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/SumOfNumbers")
public class SumOfNumbersController {
    @RequestMapping("/")
    public String hello(Model uiModel) {
        uiModel.addAttribute("name", "World!");
        return "index";
    }
}
