package br.com.bus;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.google.inject.Key;
import com.google.inject.internal.util.$ToStringBuilder;

import org.json.JSONArray;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.bus.httpcommunication.AndroidAsyncHttpClient;
import br.com.bus.httpcommunication.HttpResultCallback;
import br.com.bus.model.Stop;
import roboguice.RoboGuice;
import roboguice.inject.InjectResource;
import roboguice.util.RoboContext;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends ActionBarActivity implements RoboContext {

     @Inject
     private AndroidAsyncHttpClient client;

    @InjectResource(R.string.stops_routes)
    private String routeStops;

    @Inject
    private ObjectMapper mapper;

	@Override
	public void onCreate(Bundle savedInstanceState) {
        RoboGuice.getInjector(this).injectMembers(this);

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

        this.requestPositions();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.import_data:
			this.requestPositions();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void requestPositions() {

        client.get(routeStops, new HttpResultCallback() {
            @Override
            public void onSuccess(String content) {

                List<Stop> stops = null;
                try {
                    stops = mapper.readValue(content, new TypeReference<List<Stop>>(){});
                } catch (IOException e) {
                    e.printStackTrace();
                }
                MainActivity.this.buildCheckBox(stops);
            }

            @Override
            public void onError(String error) {
                Toast.makeText(MainActivity.this, error, LENGTH_SHORT).show();
            }
        });
	}

    private void buildCheckBox(List<Stop> stops) {
        Toast.makeText(this, stops.size(), LENGTH_LONG).show();
    }

    @Override
    public Map<Key<?>, Object> getScopedObjectMap() {
        return  new HashMap<Key<?>, Object>();
    }
}
