package br.com.bus.serialization;

import java.util.List;

public interface JsonSerializer {

    public <T> List<T> deserializeList(String objectJson, Class<T> clazz);

    public <T> T deserializeObject(String objectJson, Class<T> clazz);

    public <T> String serialize(T object);
}
