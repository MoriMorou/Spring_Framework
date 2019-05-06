package ru.morou.entites;

public class Human {
    private String firstName;
    private String lastName;
    private String sex;
    private String[] education;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String[] getEducation() {
        return education;
    }

    public void setEducation(String[] education) {
        this.education = education;
    }
}
