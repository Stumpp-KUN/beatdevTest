package com.example.springApi.testApiJava.rest;

import com.example.springApi.testApiJava.web.dto.UserDTOForCreate;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Test
    public void testAddNewUser() {
        UserDTOForCreate userDTO = new UserDTOForCreate("John", "Doe", "johnddosse@gmail.com", "http://example.com", true, "password");
        given()
                .contentType("application/json")
                .body(userDTO)
                .when()
                .post("/api/v1/users/")
                .then()
                .statusCode(201)
                .body("id", notNullValue());
    }

    @Test
    public void testGetUser() {
        Long id = 10L;
        given()
                .pathParam("id", id)
                .when()
                .get("/api/v1/users/{id}")
                .then()
                .statusCode(200)
                .body("id", equalTo(id.intValue()));
    }

    @Test
    public void testUpdateUserStatus() {
        Long id = 10L;
        given()
                .pathParam("id", id)
                .when()
                .put("/api/v1/users/{id}/status")
                .then()
                .statusCode(200)
                .body("id", equalTo(id.intValue()))
                .body("previousStatus", notNullValue())
                .body("currentStatus", notNullValue());
    }
}
