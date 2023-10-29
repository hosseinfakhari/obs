package com.ukdri.obs.model;

import com.ukdri.obs.service.ObservationTypeService;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class ObservationTypeDeserializer extends StdDeserializer<ObservationType> {
    private final ObservationTypeService observationTypeService;

    public ObservationTypeDeserializer(ObservationTypeService observationTypeService) {
        super(ObservationType.class);
        this.observationTypeService = observationTypeService;
    }

    @Override
    public ObservationType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Integer typeId = jsonParser.getIntValue();
        return observationTypeService.getObservationTypeById(typeId);
    }
}