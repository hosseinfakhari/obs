package com.ukdri.obs.repository;

import com.ukdri.obs.model.ObservationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObservationTypeRepository extends JpaRepository<ObservationType, Integer> {
}
