package br.com.bus;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
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

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends ActionBarActivity implements RoboContext {

    private @Inject HttpClient client;

    private @Inject JsonSerializer serializer;

    private @InjectResource(R.string.stops_routes) String routeStops;

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
                List<Stop> stops = serializer.<Stop>deserializeList(content, Stop.class);
                buildSpinner(stops);
            }

            @Override
            public void onError(String error) {
                Toast.makeText(MainActivity.this, error, LENGTH_SHORT).show();
            }
        });
    }

    private void buildSpinner(List<Stop> stops) {
        ActionBar actionBar = getSupportActionBar();

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

        actionBar.setDisplayShowTitleEnabled(false);
        ArrayAdapter<Stop> adapter = new StopsAdapter(actionBar.getThemedContext(), stops);

        ActionBar.OnNavigationListener navigationListener = new ActionBar.OnNavigationListener() {
            @Override
            public boolean onNavigationItemSelected(int i, long l) {
                Toast.makeText(MainActivity.this, i + "  " + l, Toast.LENGTH_SHORT).show();
                return true;
            }
        };

        actionBar.setListNavigationCallbacks(adapter, navigationListener);
    }

    @Override
    public Map<Key<?>, Object> getScopedObjectMap() {
        return  new HashMap<Key<?>, Object>();
    }
}
