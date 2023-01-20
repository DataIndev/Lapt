package com.example.lapt.security.entity;

import com.example.lapt.security.enums.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Transactional
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NonNull
    private String userName;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String userPassword;
    @Column(unique = true)
    @NonNull
    private String userEmail;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name ="rol_id"))
    private Set<Rol> roles = new HashSet<Rol>();

}
