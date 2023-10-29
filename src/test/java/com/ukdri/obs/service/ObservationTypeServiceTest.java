package com.ukdri.obs.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.ukdri.obs.model.ObservationType;
import com.ukdri.obs.repository.ObservationTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ObservationTypeServiceTest {
    @InjectMocks
    private ObservationTypeService observationTypeService;

    @Mock
    private ObservationTypeRepository observationTypeRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetObservationTypeById() {
        ObservationType observationType = new ObservationType();
        int id = 1;

        when(observationTypeRepository.findById(id)).thenReturn(Optional.of(observationType));

        ObservationType result = observationTypeService.getObservationTypeById(id);

        assertEquals(observationType, result);
    }

    @Test
    public void testGetObservationTypeByIdNotFound() {
        int id = 1;

        when(observationTypeRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            observationTypeService.getObservationTypeById(id);
        });
    }

    @Test
    public void testCreateObservationType() {
        ObservationType observationType = new ObservationType();

        when(observationTypeRepository.save(observationType)).thenReturn(observationType);

        ObservationType result = observationTypeService.createObservationType(observationType);

        assertEquals(observationType, result);
    }

    @Test
    public void testGetAllObservationType() {
        ObservationType observationType1 = new ObservationType();
        ObservationType observationType2 = new ObservationType();
        List<ObservationType> observationTypes = Arrays.asList(observationType1, observationType2);

        when(observationTypeRepository.findAll()).thenReturn(observationTypes);

        List<ObservationType> result = observationTypeService.getAllObservationType();

        assertEquals(2, result.size());
    }
}