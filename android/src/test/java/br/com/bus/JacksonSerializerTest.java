package br.com.bus;


import com.fasterxml.jackson.databind.ObjectMapper;
import  com.google.inject.Guice;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import javax.inject.Inject;

import br.com.bus.model.Stop;
import br.com.bus.serialization.JacksonSerializer;
import roboguice.inject.InjectResource;

import static org.junit.Assert.assertEquals;

public class JacksonSerializerTest {

    private static final String STOP_JSON = "{\"id\":1, \"name\":\"RU\"}";
    private String STOP_JSON_LIST = "[{\"id\" : 1, \"name\": \"RU\"}, {\"id\": 2, \"name\": \"CCB\"}, {\"id\": 3, \"name\": \"CCH\"}]";

    private JacksonSerializer serializer;

    @Before
    public void createSerializer() {
        serializer = Guice.createInjector(new BusModule()).getInstance(JacksonSerializer.class);
    }

    @Test
    public void shouldDeserializeSingleStop() {
        Stop stop = serializer.<Stop>deserializeObject(STOP_JSON, Stop.class);
        assertEquals(stop.getId(), 1L);
        assertEquals(stop.getName(), "RU");
    }

    @Test
    public void shouldReturnStopsSize(){
        List<Stop> stops = this.deserializeStops(STOP_JSON_LIST);

        assertEquals(stops.size(), 3);
    }

    @Test
    public void shouldDeserializeStopsWithFields() {
        List<Stop> stops = this.deserializeStops(STOP_JSON_LIST);

        assertEquals(stops.get(0).getId(), 1L);
        assertEquals(stops.get(1).getId(), 2L);
        assertEquals(stops.get(2).getId(), 3L);

        assertEquals(stops.get(0).getName(), "RU");
        assertEquals(stops.get(1).getName(), "CCB");
        assertEquals(stops.get(2).getName(), "CCH");
    }

    private List<Stop> deserializeStops(String jsonObject) {
        return serializer.<Stop>deserializeList(STOP_JSON_LIST, Stop.class);

    }
}
