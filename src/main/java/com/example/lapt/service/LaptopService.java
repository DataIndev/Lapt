package com.example.lapt.service;


import com.example.lapt.controller.LaptopController;
import com.example.lapt.entity.Laptop;
import com.example.lapt.repository.LaptopRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class LaptopService {
    private final LaptopRepo repo;
    Logger logger = LoggerFactory.getLogger(LaptopController.class);


    //CREATE LAPTOP
    public ResponseEntity<Laptop> createLaptop(Laptop laptop) {
        return ResponseEntity.ok(repo.save(laptop));
    }

    //FIND BY ID
    public ResponseEntity<Optional<Laptop>> findById(Long id) {
        return ResponseEntity.ok(repo.findById(id));
    }

    //FIND ALL LAPTOP
    public ResponseEntity<List<Laptop>> findAll() {
        return ResponseEntity.ok(repo.findAll());
    }

    //UPDATE LAPTOP
    public ResponseEntity<Laptop> updateLaptop(Laptop laptop) {

        return repo.existsById(laptop.getId()) ? ResponseEntity.ok((repo.save(laptop))) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //DELETE LAPTOP BY ID
    public ResponseEntity<String> deleteLaptopById(Long id) {
        repo.deleteById(id);
        return ResponseEntity.ok("Laptop with id " + id + "was delete successfully");
    }

    //DELETE ALL LAPTOPS
    public ResponseEntity<String> deleteAll() {
        return ResponseEntity.ok("All data deleted successfully");
    }


}
