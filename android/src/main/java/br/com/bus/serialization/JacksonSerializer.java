package br.com.bus.serialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;

import java.io.IOException;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class JacksonSerializer implements JsonSerializer {

    @Inject
    private ObjectMapper mapper;

    @Override
    public <T> T deserialize(String objectJson) {
        T object = null;

        try {
            object = mapper.readValue(objectJson, new TypeReference<T>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return object;
    }

    @Override
    public <T> String serialize(T object) {
        throw new NotImplementedException();
    }
}
