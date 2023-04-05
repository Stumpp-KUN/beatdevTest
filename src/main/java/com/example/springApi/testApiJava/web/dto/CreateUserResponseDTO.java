package com.example.springApi.testApiJava.web.dto;

import com.example.springApi.testApiJava.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CreateUserResponseDTO {
    private Long id;

    public CreateUserResponseDTO(User user){
        setId(user.getId());
    }
}
