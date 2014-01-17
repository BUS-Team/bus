package br.com.bus.serialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.google.inject.Inject;

import java.io.IOException;
import java.util.List;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class JacksonSerializer implements JsonSerializer {

    @Inject
    private ObjectMapper mapper;

    @Override
    public <T> List<T> deserializeList(String objectJson, Class<T> clazz) {
        List<T> objects = null;

        try {
            CollectionType type = mapper.getTypeFactory().constructCollectionType(List.class, clazz);
            objects = mapper.readValue(objectJson, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objects;
    }

    @Override
    public <T> T deserializeObject(String objectJson, Class<T> clazz) {
        T object = null;
        try {
            object = mapper.readValue(objectJson, clazz);
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
