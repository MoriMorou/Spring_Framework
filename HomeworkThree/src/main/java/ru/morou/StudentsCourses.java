//package ru.morou;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "students_courses")
//public class StudentsCourses {
//
//    @Id
//    @GeneratedValue(strategy =  GenerationType.IDENTITY)
//    @Column(name = "id")
//    private int id;
//
//    @Column(name = "marks")
//    private int marks;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getMarks() {
//        return marks;
//    }
//
//    public void setMarks(int marks) {
//        this.marks = marks;
//    }
//
//    public StudentsCourses() {
//    }
//
//    @Override
//    public String toString() {
//        return "StudentsCourses{" +
//                "id=" + id +
//                ", marks=" + marks +
//                '}';
//    }
//}
