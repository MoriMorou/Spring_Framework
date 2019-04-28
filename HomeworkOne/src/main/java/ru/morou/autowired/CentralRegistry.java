package ru.morou.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("registry")
public class CentralRegistry implements Registry {
    public Doctor doctor;

    public Doctor getDoctors() {
        return doctor;
    }

    @Autowired(required = false)
    @Qualifier("surgeon")
    public void setDoctors(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public void findDoctor() {
        doctor.patientAdmission();
    }
}
