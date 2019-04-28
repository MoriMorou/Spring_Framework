package ru.morou.autowired;

import org.springframework.stereotype.Component;

@Component("registryMain")
public class CentralRegistry implements Registry {
    public Doctor doctor;

    public Doctor getDoctors() {
        return doctor;
    }

    public void setDoctors(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public void findDoctor() {
        doctor.patientAdmission();
    }
}
