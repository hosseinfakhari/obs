package com.ukdri.obs.service;

import com.ukdri.obs.model.Observation;
import com.ukdri.obs.repository.ObservationRepository;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ObservationService {

  @Autowired
  private ObservationRepository observationRepository;

  public List<Observation> getAllObservations() {
    return observationRepository.findAll();
  }

  public Observation getObservationById(UUID id) {
    return observationRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Observation not found with id " + id)); 
  }

  public Observation createObservation(Observation observation) {
    observation.setId(UUID.randomUUID());
    return observationRepository.save(observation);
  }

  public Observation updateObservation(UUID id, Observation observationUpdate) {
    Observation observation = getObservationById(id);
    observation.setType(observationUpdate.getType());
    observation.setDate(observationUpdate.getDate());
    // ... update other fields
    return observationRepository.save(observation);
  }

  public void deleteObservation(UUID id) {
    observationRepository.deleteById(id);
  }

}