package com.ecommerce.Ecommerce.Dtos;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AdminDto {
    @Size(min = 3, max = 20, message = "Invalid first name! (3-20 characters)")
    private String firstName;

    @Size(min = 3, max = 20, message = "Invalid last name! (3-20 characters)")
    private String lastName;

    private String username;

    @Size(min = 5, max = 15, message = "Invalid password! (5-15 characters)")
    private String password;

    private String repeatPassword;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
