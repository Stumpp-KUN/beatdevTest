package com.example.springApi.testApiJava.web.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

@Data
public abstract class UserDTO {
    @Size(min = 2,message = "Min lenght, should be longer then 2")
    private String name;
    @NotBlank(message = "Surname should not be blank")
    private String surname;
    @Size(max = 20,min = 4,message = "email range 4<x<20")
    @Email(message = "there is not email!")
    private String email;
    @NotBlank
    private String url;
    private boolean online;
}
