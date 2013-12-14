package br.com.bus;

import com.google.inject.Binder;
import com.google.inject.Module;

import br.com.bus.httpcommunication.AndroidAsyncHttpClient;
import br.com.bus.httpcommunication.HttpClient;

public class BusModule implements Module {
    @Override
    public void configure(Binder binder) {
        binder.bind(HttpClient.class).to(AndroidAsyncHttpClient.class);
    }
}
