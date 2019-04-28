//package ru.morou.autowired;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component("nurse")
//public class Nurse {
//
//    private String patienName;
//
//    public Nurse(String name) {
//        this.patienName = name;
//    }
//
//    public String getPatienName() {
//        return patienName;
//    }
//
//    @Autowired(required = false)
//    public void setPatienName(String name) {
//        System.out.println("Your name please");
//        this.patienName = name;
//    }
//
//
//}
