package uz.pdp.appmultithreading.functionalProgramming;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Student {

    private String fullName;
    private String phoneNumber;
    private Integer age;
    private LocalDateTime birthDate;
    private GenderEnum gender;

    public Student(String fullName, String phoneNumber, Integer age, LocalDateTime birthDate, GenderEnum gender) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                '}';
    }
}
