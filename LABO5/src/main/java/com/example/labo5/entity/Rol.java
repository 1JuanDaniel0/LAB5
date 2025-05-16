package com.example.labo5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rol")
public class Rol {

    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idrol", nullable = false)
    private Integer idrol;

    @Column(name = "nombre", nullable = false)
    private String nombre;
}
