package com.example.jpa_exercise_entity.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //AUTO INCREMENT
    private int userId;

    @Column(length = 100, nullable = false, unique = true)
    private String userName;

    @Column(length = 100, nullable = false)
    private String firstName;

    @Column(length = 100, nullable = false)
    private String lastName;

    @Column(nullable = false)
    private LocalDate birthDate;

    private boolean active = true;

    @Column(length = 100, nullable = false)
    private String password;


    protected  AppUser() {
    }

    public AppUser(String userName, String firstName, String lastName, LocalDate birthDate, String password) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return userId == appUser.userId && active == appUser.active && Objects.equals(userName, appUser.userName) && Objects.equals(firstName, appUser.firstName) && Objects.equals(lastName, appUser.lastName) && Objects.equals(birthDate, appUser.birthDate) && Objects.equals(password, appUser.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, firstName, lastName, birthDate, active, password);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", active=" + active +
                ", password='" + password + '\'' +
                '}';
    }
}
