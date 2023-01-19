package com.example.lapt.controller;

import com.example.lapt.entity.Laptop;
import com.example.lapt.service.LaptopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class LaptopController {

    private final LaptopService laptopService;

    @GetMapping("/getLaptopById/{id}")
    public ResponseEntity<Optional<Laptop>> getLaptopById(@PathVariable Long id){
        return  ResponseEntity.ok(laptopService.findById(id));
    }

    @GetMapping("/saludo")
    public ResponseEntity<String> getLaptopById(){
        return ResponseEntity.ok("Hola mundo");
    }

    @PostMapping("/createLaptop")
    public ResponseEntity<Laptop> createLaptop(@RequestBody Laptop laptop){
        return ResponseEntity.ok(laptopService.addLaptop(laptop));
    }

    @PostMapping("/saludo2")
    public ResponseEntity<String> saludo2(){
        return ResponseEntity.ok("Saludo 2");
    }
}
