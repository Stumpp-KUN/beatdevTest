package com.example.springApi.testApiJava.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    private Boolean status;
    private String url; //работал с base64, но видимо тут принимаю ссылку в интернете на хрананение изобр
    private String password;
}
