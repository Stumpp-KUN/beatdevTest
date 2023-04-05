package com.example.springApi.testApiJava.web.contoller;

import com.example.springApi.testApiJava.web.dto.CreateUserResponseDTO;
import com.example.springApi.testApiJava.web.dto.UpdateUserStatusResponseDTO;
import com.example.springApi.testApiJava.web.dto.UserDTOForCreate;
import com.example.springApi.testApiJava.web.dto.UserDTOForRead;
import com.example.springApi.testApiJava.web.facade.UserFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(path = "/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @PostMapping("/")
    public ResponseEntity<CreateUserResponseDTO> addNewUser(@RequestBody @Valid UserDTOForCreate userDTO) throws InterruptedException {
        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(5, 11));
        return new ResponseEntity<>(userFacade.createUser(userDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTOForRead> getUser(@PathVariable Long id) throws InterruptedException {
        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(5, 11));
        return new ResponseEntity<>(userFacade.getUser(id),HttpStatus.OK);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<UpdateUserStatusResponseDTO> updateUserStatus(@PathVariable Long id) throws InterruptedException {
        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(5, 11));
        return new ResponseEntity<>(userFacade.updateUserStatus(id),HttpStatus.OK);

    }

}
