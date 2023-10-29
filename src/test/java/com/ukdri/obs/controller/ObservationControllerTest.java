package com.ukdri.obs.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

import com.ukdri.obs.model.Observation;
import com.ukdri.obs.service.ObservationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

@WebMvcTest(ObservationController.class)
public class ObservationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ObservationService observationService;

    @Test
    public void testGetAllObservation() throws Exception {
        // Mock the behavior of observationService.getAllObservations()
        when(observationService.getAllObservations()).thenReturn(Arrays.asList(new Observation(), new Observation()));

        mockMvc.perform(get("/api/observation/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void testGetObservation() throws Exception {
        int id = 1;
        Observation observation = new Observation();

        // Mock the behavior of observationService.getObservationById(id)
        when(observationService.getObservationById(id)).thenReturn(observation);

        mockMvc.perform(get("/api/observation/1/", id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testDeleteObservation() throws Exception {
        int id = 1;

        mockMvc.perform(delete("/api/observation/{id}/", id))
                .andExpect(status().isOk());
    }
}
