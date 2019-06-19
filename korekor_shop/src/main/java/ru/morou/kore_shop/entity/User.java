package ru.morou.kore_shop.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

/**
 * @Access нужна для определения типа доступа (access type) для класса entity, суперкласса, embeddable или отдельных
 * атрибутов, то есть как JPA будет обращаться к атрибутам entity, как к полям класса (FIELD) или как к свойствам класса
 * (PROPERTY), имеющие гетеры (getter) и сетеры (setter).
 *
 * https://ru.stackoverflow.com/questions/874276/%D0%94%D0%BB%D1%8F-%D1%87%D0%B5%D0%B3%D0%BE-accesstype-field-%D0%B8-accesstype-property-%D0%B2-access
 */

// FIXME: 6/19/2019 implements UserDetails - когда следует использовать (на данный моменты мы работаем через UserDetailsService)?
// FIXME: 6/19/2019 @Access - когда следует использовать?

@Entity
@Table(name = "users")
//@Access(AccessType.FIELD)
public class User {

    // FIXME: 6/19/2019 Какая неприятность может произойти, если serialVersionUID не указан при UserDetails?
    private static final long serialVersionUID = 1L;

    // FIXME: 6/19/2019 GenerationType - когда следует использовать AUTO, а когда IDENTITY?
    // FIXME: 6/19/2019 Стоит ли написать так @Column(name = "user_id", nullable = false, updatable = false)?
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", unique = true, nullable = false)
    private String userName;

    /**
     * Аннотация @Pattern, предоставляя его регулярное выражение, которое гарантирует, что значение свойства
     * соответствует желаемому формату.
     * http: //www.regularexpressions.info/.
     */
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,60}",
            message="Password is invalid. It should contain at least one: digit, upper, lower case letter, special " +
                    "character and its length should be in range from 6 to 60 chars")
    @Column(name = "password", nullable = false)
    private String password;

//    @Transient
//    @Pattern(regexp="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,60}", message="Password confirmation is invalid. It should contain at least one: digit, "
//            + "upper, lower case letter, special character and its length should be in range from 6 to 60 chars")
//    private String passwordConfirmation;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone", nullable = false, unique = true)
    @Pattern(regexp="(^$|[0-9]{9})", message="Phone number format is not correct (NNNNNNNNN eg.: 700700700).")
    private String phone;

    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    @NotEmpty(message="post code cannot be empty.")
    @Column(name="postcode")
    @Pattern(regexp="[0-9]{2}\\-[0-9]{3}", message="Post code is incorrect (XX-XXX eg. 20-199).") //Polish zipcode
    private String postcode;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {
        this.roles = new HashSet<>();
    }

    public User(String userName, String password, String firstName, String lastName, String email, String phone,
                String address, String city, String postcode) {
        this(userName, password, firstName, lastName, email, phone, address, city, postcode, new HashSet<>());
    }

    public User(String userName, String password, String firstName, String lastName, String email, String phone,
                String address, String city, String postcode, Set<Role> roles) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.postcode = postcode;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", postcode='" + postcode + '\'' +
                ", roles=" + roles +
                '}';
    }
}
