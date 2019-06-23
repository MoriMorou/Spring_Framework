package ru.morou.korekor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShoppingCart {

    @GetMapping("/shopping-cart")
    public String shoppingCartPage(){
        return "shopping-cart";
    }
}
