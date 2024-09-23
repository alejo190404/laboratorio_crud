package com.example.zoo_fantastico.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.zoo_fantastico.entity.Zonas;

public interface ZonaRepository extends JpaRepository<Zonas, Long> {
}
