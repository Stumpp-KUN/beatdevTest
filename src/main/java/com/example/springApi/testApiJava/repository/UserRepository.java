package com.example.springApi.testApiJava.repository;

import com.example.springApi.testApiJava.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
