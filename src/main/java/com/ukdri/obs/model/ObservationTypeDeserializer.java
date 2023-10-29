package com.ukdri.obs.model;

import com.ukdri.obs.service.ObservationTypeService;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class ObservationTypeDeserializer extends StdDeserializer<ObservationType> {
    @Autowired
    ObservationTypeService observationTypeService;
    public ObservationTypeDeserializer() {
        this(null);
    }

    public ObservationTypeDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public ObservationType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Integer typeId = jsonParser.getIntValue();
        return observationTypeService.getObservationTypeById(typeId);
    }
}