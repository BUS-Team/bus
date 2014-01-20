package br.com.bus;

import android.support.v7.app.ActionBar;

import com.google.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowHandler;
import org.robolectric.shadows.ShadowToast;

import java.util.ArrayList;
import java.util.List;

import br.com.bus.httpcommunication.HttpClient;
import br.com.bus.httpcommunication.HttpResultCallback;
import br.com.bus.model.Stop;
import br.com.bus.serialization.JsonSerializer;
import roboguice.RoboGuice;
import roboguice.inject.InjectResource;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    private @InjectResource(R.string.stops_routes) String routeStops;

    private MainActivity mainActivity;

    private List<Stop> stopsFixture = createStops();

    @Inject
    private HttpClient client;

    @Inject
    private JsonSerializer serializer;

    @Before
    public void setupTests() {

        mainActivity = Robolectric.buildActivity(MainActivity.class).create().get();
        RoboGuice.getInjector(Robolectric.application).injectMembers(this);

        when(serializer.<Stop>deserializeList(anyString(), eq(Stop.class))).thenReturn(stopsFixture);
    }

    @Test  @Config(reportSdk = 10)
    public void shouldBuildSpinnerOnActionBar(){
        getCallback().onSuccess("");

        ActionBar actionBar = mainActivity.getSupportActionBar();

        assertEquals(actionBar.getNavigationItemCount(), stopsFixture.size());
    }

    public void shouldNotifyWhenRequestGivesError(){
        String requestFailedMessage = "Request Failed";

        getCallback().onError(requestFailedMessage);

        assertEquals(ShadowToast.getTextOfLatestToast(), requestFailedMessage);
    }

    public HttpResultCallback getCallback() {
        ArgumentCaptor<HttpResultCallback> callback = ArgumentCaptor.forClass(HttpResultCallback.class);
        verify(client).get(anyString(), callback.capture());
        return callback.getValue();
    }

    private List<Stop> createStops() {
        List<Stop> stops = new ArrayList<Stop>(2);

        stops.add(new Stop(1, "RU"));
        stops.add(new Stop(2, "CCB"));

        return stops;
    }

}
