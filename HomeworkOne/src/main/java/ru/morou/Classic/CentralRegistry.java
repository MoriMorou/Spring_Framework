package ru.morou.Classic;

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
        System.out.println("Hello, I need a doctor");
        doctor.patientAdmission();
    }
}
