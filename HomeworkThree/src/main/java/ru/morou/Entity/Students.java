package ru.morou.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
public class Students extends AbstractEntity {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idstudents")
    private int idstudents;

    @Getter
    @Setter
    @Column(name = "fullname")
    private String fullname;

    @ManyToMany
    @JoinTable(
            name = "lessons_has_students",
            joinColumns = @JoinColumn(name = "students_idstudents"),
            inverseJoinColumns = @JoinColumn(name = "lessons_idlessons")
    )
    private List<Students> studentsList;

    public Students() {
    }

    @Override
    public String toString() {
        return "Students{" +
                "idstudents=" + idstudents +
                ", fullname='" + fullname + '\'' +
                ", studentsList=" + studentsList +
                '}';
    }
}
