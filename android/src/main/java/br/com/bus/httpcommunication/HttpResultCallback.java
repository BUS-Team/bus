package br.com.bus.httpcommunication;

public interface HttpResultCallback {

    public void onSuccess(String content);

    public void onError(String error);
}
