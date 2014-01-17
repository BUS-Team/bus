package br.com.bus;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import roboguice.RoboGuice;
import roboguice.inject.InjectResource;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    private @InjectResource(R.string.stops_routes) String routeStops;

    private MainActivity mainActivity;

    @Before
    public void setupTests() {
        mainActivity = Robolectric.buildActivity(MainActivity.class).create().get();
        RoboGuice.getInjector(mainActivity).injectMembers(this);
    }

    @Test
    public void oneEqualsOne(){
    }
}
