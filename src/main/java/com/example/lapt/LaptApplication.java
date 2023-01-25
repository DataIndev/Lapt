package com.example.lapt;

import com.example.lapt.entity.Laptop;
import com.example.lapt.repository.LaptopRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LaptApplication {

    public static void main(String[] args) {

        //SpringApplication.run(LaptApplication.class, args);

        ApplicationContext context = SpringApplication.run(LaptApplication.class, args);

        LaptopRepo repo = context.getBean(LaptopRepo.class);


        Laptop laptop1 = new Laptop("Lenovo", "Thinkpad","120.000");
        Laptop laptop2 = new Laptop("Hp", "Pavilon","130.000");
        Laptop laptop3 = new Laptop("Gigabyte", "G5 MD","210.000");
        Laptop laptop4 = new Laptop("Asus", "Rog STRIX","190.000");

        repo.save(laptop1);
        repo.save(laptop2);
        repo.save(laptop3);
        repo.save(laptop4);

    }

}
