package br.com.bus;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.inject.Inject;
import com.google.inject.Key;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.bus.httpcommunication.HttpClient;
import br.com.bus.httpcommunication.HttpResultCallback;
import br.com.bus.model.Stop;
import br.com.bus.serialization.JsonSerializer;
import roboguice.RoboGuice;
import roboguice.inject.InjectResource;
import roboguice.util.RoboContext;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends ActionBarActivity implements RoboContext {

     @Inject
     private HttpClient client;

    @Inject
    private JsonSerializer serializer;

    @InjectResource(R.string.stops_routes)
    private String routeStops;

	@Override
	public void onCreate(Bundle savedInstanceState) {
        RoboGuice.getInjector(this).injectMembers(this);

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

        this.requestPositions();
	}
    
    private void requestPositions() {

        client.get(routeStops, new HttpResultCallback() {
            @Override
            public void onSuccess(String content) {
                List<Stop> stops = serializer.<List<Stop>>deserialize(content);
                buildCheckBox(stops);
            }

            @Override
            public void onError(String error) {
                Toast.makeText(MainActivity.this, error, LENGTH_SHORT).show();
            }
        });
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

    private void buildCheckBox(List<Stop> stops) {
        Toast.makeText(this, stops.size()+"", LENGTH_LONG).show();
    }

    @Override
    public Map<Key<?>, Object> getScopedObjectMap() {
        return  new HashMap<Key<?>, Object>();
    }
}
