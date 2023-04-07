package com.example.springApi.testApiJava.web.dto;

import com.example.springApi.testApiJava.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class UserDTOForUpdate extends UserDTO{
    private Long id;
    public UserDTOForUpdate(User user) {
        setName(user.getName());
        setSurname(user.getSurname());
        setEmail(user.getEmail());
        setUrl(user.getUrl());
        setOnline(user.isStatus());
        setId(user.getId());
    }

    @JsonIgnore
    public User getEntity(){
        User user=new User();
        user.setName(getName());
        user.setSurname(getSurname());
        user.setEmail(getEmail());
        user.setUrl(getUrl());
        user.setStatus(isOnline());
        user.setId(getId());
        return user;

    }
}
