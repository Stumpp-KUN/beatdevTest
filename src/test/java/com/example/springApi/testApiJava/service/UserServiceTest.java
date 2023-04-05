package com.example.springApi.testApiJava.service;
import com.example.springApi.testApiJava.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserServiceTest {
    @MockBean
    private UserService userService;
    private final Logger logger= LogManager.getRootLogger();

    private User getUser(){
        User user=new User();
        user.setId(1L);
        user.setName("testName");
        user.setSurname("testSurname");
        user.setEmail("testEmail");
        user.setPassword("qwertyuio");
        user.setUrl("fokmsfm");
        user.setStatus(true);
        return user;
    }

    @Test
    public void testCreateUser(){
    User user=getUser();
    when(userService.saveUser(any(User.class))).thenReturn(user);
    User tempUser=userService.saveUser(user);
    assertThat(!tempUser.getEmail().isBlank());
    }

    @Test
    public void testGetUser(){
    User user=getUser();
    given(userService.getUser(1L)).willReturn(user);
    User tempUser=userService.getUser(1L);
    assertEquals(tempUser.getId(),1);
    }

    @Test
    public void testUpdateUserStatus(){
    User user=getUser();
    when(userService.updateUserStatus(any(User.class))).thenReturn(user);
    User tempUser=userService.updateUserStatus(user);
    assertTrue(tempUser.getStatus());
    }
}
