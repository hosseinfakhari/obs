package com.ukdri.obs.model;

import java.time.ZonedDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ObservationTest {
    private Observation observation;

    @BeforeEach
    public void setUp() {
        observation = new Observation();
    }

    @Test
    public void testGetAndSetId() {
        observation.setId(1);
        assertEquals(1, observation.getId());
    }

    @Test
    public void testGetAndSetType() {
        ObservationType observationType = new ObservationType();
        observation.setType(observationType);
        assertEquals(observationType, observation.getType());
    }

    @Test
    public void testGetAndSetDate() {
        ZonedDateTime date = ZonedDateTime.now();
        observation.setDate(date);
        assertEquals(date, observation.getDate());
    }

    @Test
    public void testGetAndSetPatient() {
        observation.setPatient(123);
        assertEquals(123, observation.getPatient());
    }

    @Test
    public void testGetAndSetValue() {
        observation.setValue(42.0);
        assertEquals(42.0, observation.getValue(), 0.001);
    }

    @Test
    public void testDefaultValues() {
        assertEquals(0, observation.getId());
        assertNull(observation.getType());
        assertNull(observation.getDate());
        assertEquals(0, observation.getPatient());
        assertEquals(0.0, observation.getValue(), 0.001);
    }
}