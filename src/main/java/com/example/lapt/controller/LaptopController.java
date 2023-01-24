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

    @GetMapping("findById/{id}")
    public ResponseEntity<Optional<Laptop>> findById(@PathVariable Long id){
        return laptopService.findById(id);
    }




}
