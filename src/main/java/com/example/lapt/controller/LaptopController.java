package com.example.lapt.controller;

import com.example.lapt.entity.Laptop;
import com.example.lapt.service.LaptopService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class LaptopController {

    private final LaptopService laptopService;

    @PostMapping("/create")
    public ResponseEntity<Laptop> createLaptop(@RequestBody Laptop laptop) {
        return laptopService.createLaptop(laptop);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Optional<Laptop>> findById(@PathVariable Long id) {
        return laptopService.findById(id);
    }

    @GetMapping("findAll")
    public ResponseEntity<List<Laptop>> findAll() {
        return laptopService.findAll();
    }

    @PutMapping("/update")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        return laptopService.updateLaptop(laptop);
    }

    @DeleteMapping("/delete/{id5}")
    public ResponseEntity<String> deeleteById(@PathVariable Long id){
        return laptopService.deleteLaptopById(id);
    }

    @DeleteMapping("deleteAll")
    public ResponseEntity<String> deleteAll(){
        return laptopService.deleteAll();
    }


}
