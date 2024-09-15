package com.example.zoo_fantastico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.zoo_fantastico.entity.Creature;
import com.example.zoo_fantastico.repository.CreatureRepository;

@Service
public class CreatureService {
    private final CreatureRepository creatureRepository;

    @Autowired
    public CreatureService(CreatureRepository creatureRepository) {
        this.creatureRepository = creatureRepository;
    }

    public Creature createCreature(Creature creature) {
        return creatureRepository.save(creature);
    }
    public List<Creature> getAllCreatures() {
        return creatureRepository.findAll();
    }

}
