package ru.morou.kore_shop.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

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
public class Customer implements Serializable {

    // FIXME: 6/19/2019 Какая неприятность может произойти, если serialVersionUID не указан при UserDetails?
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", unique = true, nullable = false)
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @NotEmpty(message="post code cannot be empty.")
    @Column(name="postcode")
    @Pattern(regexp="[0-9]{2}\\-[0-9]{3}", message="Post code is incorrect (XX-XXX eg. 20-199).")
    private String postcode;

    @Column(name = "phone")
    @Pattern(regexp="(^$|[0-9]{9})", message="Phone number format is not correct (NNNNNNNNN eg.: 700700700).")
    private String phone;

    @Column(name = "status")
    private boolean status;

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

    // FIXME: 7/5/2019 Проверить!!!
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date userData;

    @ManyToOne(optional = false)
    private Role role;

    public Customer() {
    }

    // FIXME: 7/5/2019 проверить
    public Customer(String userName, String email, String firstName, String lastName, String address, String city, String country, @NotEmpty(message = "post code cannot be empty.") @Pattern(regexp = "[0-9]{2}\\-[0-9]{3}", message = "Post code is incorrect (XX-XXX eg. 20-199).") String postcode, @Pattern(regexp = "(^$|[0-9]{9})", message = "Phone number format is not correct (NNNNNNNNN eg.: 700700700).") String phone, boolean status, @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,60}",
            message = "Password is invalid. It should contain at least one: digit, upper, lower case letter, special " +
                    "character and its length should be in range from 6 to 60 chars") String password, Date userData, Role role) {
        this.userName = userName;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.country = country;
        this.postcode = postcode;
        this.phone = phone;
        this.status = status;
        this.password = password;
        this.userData = userData;
        this.role = role;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getUserData() {
        return userData;
    }

    public void setUserData(Date userData) {
        this.userData = userData;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", postcode='" + postcode + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", password='" + password + '\'' +
                ", userData=" + userData +
                ", role=" + role +
                '}';
    }
}
