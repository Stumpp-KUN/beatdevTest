package com.example.springApi.testApiJava.web.dto;

import com.example.springApi.testApiJava.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDTOForCreate extends UserDTO{
    @NotBlank(message = "password should not be blank")
    private String password;

    public UserDTOForCreate(User user) {
        setName(user.getName());
        setSurname(user.getSurname());
        setEmail(user.getEmail());
        setUrl(user.getUrl());
        setPassword(user.getPassword());
        setOnline(user.isStatus());
    }

    public UserDTOForCreate(String name,String surname,String email,String url,Boolean online,String password){
        setName(name);
        setSurname(surname);
        setUrl(url);
        setEmail(email);
        setOnline(online);
        setPassword(password);
    }

    public User getEntity(){
        User user=new User();
        user.setName(getName());
        user.setSurname(getSurname());
        user.setEmail(getEmail());
        user.setUrl(getUrl());
        user.setStatus(isOnline());
        user.setPassword(getPassword());
        return user;
    }
}
