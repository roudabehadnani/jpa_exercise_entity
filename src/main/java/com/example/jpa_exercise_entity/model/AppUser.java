package com.example.jpa_exercise_entity.model;

import java.time.LocalDate;
import java.util.Objects;

public class AppUser {

    private int userId;
    private String userName;
    private String lastName;
    private LocalDate birthDate;
    private boolean active = true;
    private String password;


    public AppUser() {
    }

    public AppUser(int userId, String userName, String lastName, LocalDate birthDate, String password) {
        this.userId = userId;
        this.userName = userName;
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
        return userId == appUser.userId && active == appUser.active && Objects.equals(userName, appUser.userName) && Objects.equals(lastName, appUser.lastName) && Objects.equals(birthDate, appUser.birthDate) && Objects.equals(password, appUser.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, lastName, birthDate, active, password);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", active=" + active +
                ", password='" + password + '\'' +
                '}';
    }
}
