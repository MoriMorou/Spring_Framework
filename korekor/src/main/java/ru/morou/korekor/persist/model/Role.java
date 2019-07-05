package ru.morou.korekor.persist.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user_roles")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "role", unique = true, nullable = false)
    private String role;

    @OneToMany(
            mappedBy = "role",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<User> users;

    @OneToMany(
            mappedBy = "role",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<Staff> staff;

    public Role() {
    }
//
//    public Role(String role, List<User> users) {
//        this.role = role;
//        this.users = users;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }
}
