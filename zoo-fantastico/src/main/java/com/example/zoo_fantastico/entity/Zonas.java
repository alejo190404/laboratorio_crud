package com.example.zoo_fantastico.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;

@Entity
@Data // Esto es opcional pueden usarlo o crear los getter y setters
@NoArgsConstructor

public class Zonas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nombre;
    private String descripcion;
    private int capacity;
    private Long id;

}



