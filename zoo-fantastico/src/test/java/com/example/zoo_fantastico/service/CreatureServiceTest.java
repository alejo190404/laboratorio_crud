package com.example.zoo_fantastico.service;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.example.zoo_fantastico.entity.Creature;
import com.example.zoo_fantastico.repository.CreatureRepository;

public class CreatureServiceTest {
    @Mock
    private CreatureRepository creatureRepository;
    @InjectMocks
    private CreatureService creatureService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetCreatureById_ShouldReturnCreature_WhenCreatureExists() throws Exception {
        // Arrange
        Long creatureId = 1L;
        Creature expectedCreature = new Creature();
        expectedCreature.setId(creatureId);
        when(creatureRepository.findById(creatureId)).thenReturn(Optional.of(expectedCreature));
        // Act
        Creature actualCreature = creatureService.getCreatureById(creatureId);
        // Assert
        assertNotNull(actualCreature);
        assertEquals(expectedCreature, actualCreature);
        verify(creatureRepository, times(1)).findById(creatureId);
    }

    @Test
    void testGetCreatureById_ShouldThrowException_WhenCreatureDoesNotExist() {
        // Arrange
        Long creatureId = 2L;
        when(creatureRepository.findById(creatureId)).thenReturn(Optional.empty());
        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> {
            creatureService.getCreatureById(creatureId);
        });
        verify(creatureRepository, times(1)).findById(creatureId);
    }
}