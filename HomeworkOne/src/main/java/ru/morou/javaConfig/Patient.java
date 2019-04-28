package ru.morou.javaConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Patient {

    /**
     * Inversion control - это передача управления (мы передали управление медсестре для поиска доктора)
     * Dependency injection - это внедрение зависимостей
     * Bean - это экземпляр класса, который создал spring
     * Основной метод - медсестра через центральную регистратуру ищет доктора
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("Hello, I need a doctor");
        Registry registry = context.getBean("registryMain", Registry.class);
        registry.findDoctor();
    }
}
