package com.example.lapt.service;


import com.example.lapt.controller.LaptopController;
import com.example.lapt.entity.Laptop;
import com.example.lapt.repository.LaptopRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class LaptopService{
    private final LaptopRepo repo;
    Logger logger = LoggerFactory.getLogger(LaptopController.class);

    //CREATE LAPTOP
    public Laptop addLaptop(Laptop laptop) {
        return repo.save(laptop);
    }

    //FIND BY ID
    public Optional<Laptop> findById(Long id){
        return repo.findById(id);
    }

    //FIND ALL LAPTOPS
    public List<Laptop> findAll(){
        return repo.findAll();

    }

    //UPDATE DETAILS
    public void updateLaptop(Laptop laptop){
        if(repo.existsById(laptop.getId())){
            repo.save(laptop);
        }
    }

    //DELETE BY ID
    public void deleteById(Long id){
        repo.deleteById(id);
    }

    //DELETE ALLL
    public void deleteAll(){
        repo.deleteAll();
    }



}
