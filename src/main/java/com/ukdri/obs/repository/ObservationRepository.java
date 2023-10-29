package com.ukdri.obs.repository;

import com.ukdri.obs.model.Observation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObservationRepository extends JpaRepository<Observation, Integer> {

}