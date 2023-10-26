package com.ukdri.obs.model;

import java.time.ZonedDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "observations")
public class Observation {

    @Id
    private UUID id;

    private String type;

    private ZonedDateTime date;

    private int patient;

    private double value;

    private String unit;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getType() {
        return type;
      }
    
      public void setType(String type) {
        this.type = type;
      }
    
      public ZonedDateTime getDate() {
        return date;
      }
    
      public void setDate(ZonedDateTime date) {
        this.date = date;
      }
    
      public int getPatient() {
        return patient;
      }
    
      public void setPatient(int patient) {
        this.patient = patient;
      }
    
      public double getValue() {
        return value;
      }
    
      public void setValue(double value) {
        this.value = value;
      }
    
      public String getUnit() {
        return unit;
      }
    
      public void setUnit(String unit) {
        this.unit = unit;
      }
}