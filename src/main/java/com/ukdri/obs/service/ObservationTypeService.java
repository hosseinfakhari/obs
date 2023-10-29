package com.ukdri.obs.service;

import com.ukdri.obs.model.ObservationType;
import com.ukdri.obs.repository.ObservationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObservationTypeService {
    @Autowired
    private ObservationTypeRepository observationTypeRepository;

    public ObservationType getObservationTypeById(Integer id) {
        return observationTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Observation Type not found with id " + id));
    }

    public ObservationType createObservationType(ObservationType observationType) {
        return observationTypeRepository.save(observationType);
    }

    public List<ObservationType> getAllObservationType(){
        return observationTypeRepository.findAll();
    }
}
