package ru.morou.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Аннотация @SpringBootApplication ясно показывает, что это приложение Spring Boot.
 * @SpringBootApplication - составное приложение, которое объединяет три другие аннотации:
 *  @SpringBootConfiguration - обозначает этот класс как класс конфигурации.
 *  @EnableAutoConfiguration - включает автоматическую настройку Spring Boot.
 *  @ComponentScan - включает сканирование компонентов. Это позволяет вам объявить другие
 * классы с аннотациями
 *
 * @author Mori Morou
 */
@SpringBootApplication
public class ShopApplication {

    public static void main(String[] args) {
        SpringApplication.run (ShopApplication.class, args);
    }
}
