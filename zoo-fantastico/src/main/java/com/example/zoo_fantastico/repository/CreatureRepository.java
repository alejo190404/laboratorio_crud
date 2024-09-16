package com.example.zoo_fantastico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.zoo_fantastico.entity.Creature;

public interface CreatureRepository extends JpaRepository<Creature, Long>{
    //root user password: password
}
