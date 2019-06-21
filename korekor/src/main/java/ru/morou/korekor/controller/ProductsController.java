package ru.morou.korekor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductsController {

    @GetMapping("/product")
    public String productsPage(){
        return "product";
    }

    @GetMapping("/product-detail")
    public String productDetailPage(){
        return "product-detail";
    }
}
