package ru.morou.javaConfig;

import org.springframework.stereotype.Component;

@Component("surgeon")
public class Surgeon implements Doctor {
    @Override
    public void patientAdmission() {
        System.out.println("The Surgeon are waiting in cabinet 665");
    }
}
