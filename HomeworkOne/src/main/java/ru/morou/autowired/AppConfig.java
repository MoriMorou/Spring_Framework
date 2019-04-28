package ru.morou.autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.morou.autowired")
public class AppConfig {
//    @Bean(name = "surgeon")
//    public Doctor doctor() {
//        return new Surgeon();
//    }
//
//    @Bean(name = "registryMain")
//    public Registry registry(Doctor doctor){
//        CentralRegistry registry = new CentralRegistry();
//        registry.setDoctors(doctor);
//        return registry;
//    }
}
