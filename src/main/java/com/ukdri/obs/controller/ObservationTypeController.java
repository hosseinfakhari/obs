package com.ukdri.obs.controller;

import com.ukdri.obs.model.ObservationType;
import com.ukdri.obs.service.ObservationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/observation/type")
public class ObservationTypeController {
    @Autowired
    private ObservationTypeService observationTypeService;

    @GetMapping("/")
    public List<ObservationType> getAllObservationType() {
        return observationTypeService.getAllObservationType();
    }

    @PostMapping("/")
    public ObservationType createObservationType(@RequestBody ObservationType observationType){
        return observationTypeService.createObservationType(observationType);
    }
}
