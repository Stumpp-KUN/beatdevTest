package com.example.springApi.testApiJava.web.facade;

import com.example.springApi.testApiJava.model.User;
import com.example.springApi.testApiJava.service.UserService;
import com.example.springApi.testApiJava.web.dto.CreateUserResponseDTO;
import com.example.springApi.testApiJava.web.dto.UpdateUserStatusResponseDTO;
import com.example.springApi.testApiJava.web.dto.UserDTOForCreate;
import com.example.springApi.testApiJava.web.dto.UserDTOForRead;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;

    public CreateUserResponseDTO createUser(UserDTOForCreate userDTO){
        return new CreateUserResponseDTO(userService.saveUser(userDTO.getEntity()));
    }

    public UserDTOForRead getUser(Long id){
        return new UserDTOForRead(userService.getUser(id));
    }

    public UpdateUserStatusResponseDTO updateUserStatus(Long id){
        User user=userService.getUser(id);
        user.setStatus(!user.isStatus());
        userService.updateUserStatus(user);
        return new UpdateUserStatusResponseDTO(id,!user.isStatus(),user.isStatus());
    }
}
