package com.example.lapt.repository;

import com.example.lapt.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LaptopRepo extends JpaRepository<Laptop, Long> {

    public Optional<Laptop> findById(Long id);

    public boolean existsById(Long id);

    public boolean existsByMarca(String marca);

    public boolean existsByModelo(String modelo);


}
