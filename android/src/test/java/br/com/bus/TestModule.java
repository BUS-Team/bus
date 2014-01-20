package br.com.bus;

import com.google.inject.AbstractModule;

import br.com.bus.httpcommunication.HttpClient;
import br.com.bus.serialization.JsonSerializer;

import static org.mockito.Mockito.mock;

public class TestModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(HttpClient.class).toInstance(mock(HttpClient.class));
        bind(JsonSerializer.class).toInstance(mock(JsonSerializer.class));
    }
}

