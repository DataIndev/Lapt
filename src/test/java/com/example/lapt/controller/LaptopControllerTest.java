package com.example.lapt.controller;

import com.example.lapt.entity.Laptop;
import org.apache.coyote.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port).basicAuthentication("user","user");
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void createLaptop() {
    }

    @ParameterizedTest
    @ValueSource(longs = {1,2,3,4,5,6})
    void findById(Long id) {
        ResponseEntity<Laptop> response = testRestTemplate.getForEntity("/api/v1/findById/" + id, Laptop.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void findAll() {
        ResponseEntity<?> response = testRestTemplate.getForEntity("/api/v1/findAll", List.class );
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void deleteAll() {
    }
}