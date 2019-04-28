package ru.morou.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * вместо xml
 */

@Configuration
@ComponentScan("ru.morou.javaConfig")
public class AppConfig {
    // определяем surgeon через scan
//    @Bean(name = "surgeon")
//    public Doctor doctor() {
//        return new Surgeon();
//    }

    @Bean(name = "registryMain")
    public Registry registry(Doctor surgeon){
        CentralRegistry registry = new CentralRegistry();
        registry.setDoctors(surgeon);
        return registry;
    }
}
