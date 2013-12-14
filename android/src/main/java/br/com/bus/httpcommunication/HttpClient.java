package br.com.bus.httpcommunication;

import org.json.JSONObject;

public interface HttpClient {
    public void get(String route, HttpResultCallback callback);
    public void post(String route, JSONObject object, HttpResultCallback callback);
}
