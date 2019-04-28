package ru.morou.XML;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;

/**
 * 1 Создать модель Пациент - поликлиника (используя Spring)
 * 2 Использовать 3 варианта: xml, javaConfig, autowired.
 *
 * @author asatyukova (Mori Morou)
 */
public class Patient {

    /**
     * Inversion control - это передача управления (мы передали управление медсестре для поиска доктора)
     * Dependency injection - это внедрение зависимостей 
     * Основной метод - медсестра через центральную регистратуру ищет доктора
     * @param args
     */
    public static void main(String[] args) {
        //интерфейс ApplicationContext выступает в роли медсестры
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        System.out.println("Hello, I need a doctor");
        // указываем боб и какого типа он будет (то есть интерфей)
        Registry registry = (Registry) context.getBean("registry", Registry.class);
        registry.findDoctor();
    }
}
