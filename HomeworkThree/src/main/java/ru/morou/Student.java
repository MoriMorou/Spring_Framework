package ru.morou;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "students_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )

//    @OneToMany(mappedBy = "students")
//    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
//    private List<StudentsCourses> marks;

    private List<Course> courseList;

    public int getId() {
        return id;
    }

//    public List<StudentsCourses> getMarks() {
//        return marks;
//    }
//
//    public void setMarks(List<StudentsCourses> marks) {
//        this.marks = marks;
//    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public Student() {
    }

    @Override
    public String toString() {
        String allCourses="";
        for (Course c: courseList) {
            allCourses += c.getTitle() + " ";
        }
        return "Student [" + id + " " + name + " " + "[ " + allCourses + "] ]";
    }
}
