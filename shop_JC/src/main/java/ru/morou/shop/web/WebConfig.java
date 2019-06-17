package ru.morou.shop.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Метод addViewControllers () получает ViewControllerRegistry, который можно использовать для регистрации одного
     * или нескольких контроллеров представления.
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/abc").setViewName("index");
        registry.addViewController("/myAccount");
    }
}