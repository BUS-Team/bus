package br.com.bus.serialization;

public interface JsonSerializer {

    public <T> T deserialize(String objectJson);

    public <T> String serialize(T object);
}
