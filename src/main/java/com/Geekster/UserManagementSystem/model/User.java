package com.Geekster.UserManagementSystem.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NotNull
    @Length(min = 4, max = 9, message = "Error : 1. id cannot be null 2. Minimum 4 characters and Maximum 9 Characters")
    private String id ;

    @NotNull
    @Length(min = 3, max = 9, message = "Error : 1. id cannot be null 2. Minimum 3 characters and Maximum 9 Characters")
    private String name;

    @Email(message = "Please provide correct Email Id")
    private String email;

    @Size(min = 10, max = 12, message = "Mobile number should be Valid")
    private String mobileNo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    private LocalTime time;


}
