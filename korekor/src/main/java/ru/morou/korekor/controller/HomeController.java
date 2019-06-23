package ru.morou.korekor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String homepageMain(){
        return "index";
    }

    @GetMapping("/home-02")
    public String homepageTwo(){
        return "home-02";
    }

    @GetMapping("/home-03")
    public String homepageThree(){
        return "home-03";
    }
}
