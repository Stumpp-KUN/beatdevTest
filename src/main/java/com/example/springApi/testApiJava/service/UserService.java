package com.example.springApi.testApiJava.service;

import com.example.springApi.testApiJava.exception.EntityNotFoundException;
import com.example.springApi.testApiJava.model.User;
import com.example.springApi.testApiJava.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User getUser(Long id){
        return userRepository.findById(id).orElseThrow(()->new EntityNotFoundException("There is not user with id "+id));
    }

    @Transactional
    public User updateUserStatus(User user){
        return userRepository.save(user);           //save==update
    }
}
