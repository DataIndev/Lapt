package com.example.lapt;

import com.example.lapt.entity.Laptop;
import com.example.lapt.repository.LaptopRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LaptApplication {

    public static void main(String[] args) {

        SpringApplication.run(LaptApplication.class, args);
//
//        ApplicationContext context = SpringApplication.run(LaptApplication.class, args);
//
//        LaptopRepo repo = context.getBean(LaptopRepo.class);
//
//
//        Laptop laptop1 = new Laptop(1L,"Lenovo", "Thinkpad","120.000");
//
//        repo.save(laptop1);
    }

}
