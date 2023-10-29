package com.ukdri.obs.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ObservationTypeTest {
    private ObservationType observationType;

    @BeforeEach
    public void setUp() {
        observationType = new ObservationType();
    }

    @Test
    public void testGetAndSetId() {
        observationType.setId(1);
        assertEquals(1, observationType.getId());
    }

    @Test
    public void testGetAndSetName() {
        observationType.setName("Blood Pressure");
        assertEquals("Blood Pressure", observationType.getName());
    }

    @Test
    public void testGetAndSetUnit() {
        observationType.setUnit("mmHg");
        assertEquals("mmHg", observationType.getUnit());
    }

    @Test
    public void testDefaultValues() {
        assertEquals(0, observationType.getId());
        assertNull(observationType.getName());
        assertNull(observationType.getUnit());
    }
}