package br.com.bus.httpcommunication;

import com.google.inject.Inject;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONObject;

import br.com.bus.R;
import roboguice.inject.InjectResource;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class AndroidAsyncHttpClient implements HttpClient{

    @Inject AsyncHttpClient client;

    @InjectResource(R.string.ip) String ip;

    @Override
    public void get(String route, HttpResultCallback callback) {
        String url = ip + route;
        client.get(url, new AndroidAsyncHttpHandler(callback));
    }

    public void post(String route, JSONObject object, HttpResultCallback callback) {
        throw new NotImplementedException();
    }

    private class AndroidAsyncHttpHandler extends AsyncHttpResponseHandler {

        private HttpResultCallback callback;

        public AndroidAsyncHttpHandler(HttpResultCallback callback) {
            this.callback = callback;
        }

        @Override
        public void onSuccess(String content) {
            this.callback.onSuccess(content);
        }

        @Override
        public void onFailure(Throwable throwable, String error) {
            callback.onError(error);
        }
    }

}
