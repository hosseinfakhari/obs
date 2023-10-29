package com.ukdri.obs.service;

import com.ukdri.obs.model.Observation;
import com.ukdri.obs.model.ObservationType;
import com.ukdri.obs.repository.ObservationRepository;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ObservationServiceTest {

    @InjectMocks
    private ObservationService observationService;

    @Mock
    private ObservationRepository observationRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllObservations() {
        Observation observation1 = new Observation();
        Observation observation2 = new Observation();
        List<Observation> observations = Arrays.asList(observation1, observation2);

        when(observationRepository.findAll()).thenReturn(observations);

        List<Observation> result = observationService.getAllObservations();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetObservationById() {
        Observation observation = new Observation();
        int id = 1;

        when(observationRepository.findById(id)).thenReturn(Optional.of(observation));

        Observation result = observationService.getObservationById(id);

        assertEquals(observation, result);
    }

    @Test
    public void testGetObservationByIdNotFound() {
        int id = 1;

        when(observationRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            observationService.getObservationById(id);
        });
    }

    @Test
    public void testCreateObservation() {
        Observation observation = new Observation();

        when(observationRepository.save(observation)).thenReturn(observation);

        Observation result = observationService.createObservation(observation);

        assertEquals(observation, result);
    }

    @Test
    public void testUpdateObservation() {
        int id = 1;
        Observation existingObservation = new Observation();
        Observation updatedObservation = new Observation();
        ObservationType observationType = new ObservationType();
        updatedObservation.setType(observationType);
        updatedObservation.setDate(ZonedDateTime.now());

        when(observationRepository.findById(id)).thenReturn(Optional.of(existingObservation));
        when(observationRepository.save(existingObservation)).thenReturn(existingObservation);

        Observation result = observationService.updateObservation(id, updatedObservation);

        assertEquals(updatedObservation.getType(), result.getType());
        assertEquals(updatedObservation.getDate(), result.getDate());
        // Add more assertions for other updated fields
    }

    @Test
    public void testDeleteObservation() {
        int id = 1;

        observationService.deleteObservation(id);

        verify(observationRepository).deleteById(id);
    }
}