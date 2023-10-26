package com.ukdri.obs.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ukdri.obs.model.Observation;
import com.ukdri.obs.service.ObservationService;

@RestController
@RequestMapping("/api/observation")
public class ObservationController {

    @Autowired
    private ObservationService observationService;

    @GetMapping("/")
    public List<Observation> getAllObservation(){
        // pagination
        return observationService.getAllObservations();
    }

    @GetMapping("/{id}/")
    public Observation getObservation(@PathVariable UUID id){
        // pagination
        return observationService.getObservationById(id);
    }

    @PostMapping("/")
    public Observation CreateObservation(@RequestBody Observation observation) {
        // validation
        return observationService.createObservation(observation);
    }

    @PutMapping("/{id}/")
    public Observation UpdateObservation(@PathVariable UUID id, @RequestBody Observation observation) {
        return observationService.updateObservation(id, observation);
    }

    @DeleteMapping("/{id}/")
    public ResponseEntity<HttpStatus> DeleteObservation(@PathVariable UUID id) {
        observationService.deleteObservation(id);
        return ResponseEntity.ok().build();
    }
}
