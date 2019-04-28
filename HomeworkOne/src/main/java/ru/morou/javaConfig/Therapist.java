package ru.morou.javaConfig;

import org.springframework.stereotype.Component;

@Component("therapist")
public class Therapist implements Doctor {
    @Override
    public void patientAdmission() {
        System.out.println("The therapist are waiting in cabinet 315");
    }
}
