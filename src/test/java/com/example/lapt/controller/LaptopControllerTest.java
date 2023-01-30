package com.example.lapt.controller;

import com.example.lapt.entity.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.List;
import java.util.Scanner;

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
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port).basicAuthentication("user", "user");
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void createLaptop() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        String json = """
                {
                "id":1,
                "marca": "Toshiba",
                "modelo":"Force 3",
                "precio": "5000"
                }
                """;

        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/v1/create",HttpMethod.POST,request, Laptop.class);

        Laptop result = response.getBody();

        assert result != null;
        assertEquals(1L, result.getId());

    }

    @ParameterizedTest
    @ValueSource(longs = {1, 2, 3, 4, 5, 6})
    void findById(Long id) {
        ResponseEntity<Laptop> response = testRestTemplate.getForEntity("/api/v1/findById/" + id, Laptop.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void findAll() {
        ResponseEntity<?> response = testRestTemplate.getForEntity("/api/v1/findAll", List.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    void update() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        String json = """
                {
                "id":1,
                "marca": "Toshiba",
                "modelo":"Force 3",
                "precio": "5000"
                }
                """;
        HttpEntity<String> request = new HttpEntity<>(json,headers);
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/v1/update", HttpMethod.PUT,request, Laptop.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    void deleteById() {


    }

    @Test
    void deleteAll() {
    }
}