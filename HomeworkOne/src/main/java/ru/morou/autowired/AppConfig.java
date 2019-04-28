package ru.morou.autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name = "surgeon")
    public Doctor doctor() {
        return new Surgeon();
    }

    @Bean(name = "registryMain")
    public Registry registry(Doctor doctor){
        CentralRegistry registry = new CentralRegistry();
        registry.setDoctors(doctor);
        return registry;
    }
}
