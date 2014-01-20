package br.com.bus;

import roboguice.RoboGuice;

public class TestApp extends App{

    @Override
    public void onCreate() {
        super.onCreate();

        RoboGuice.setBaseApplicationInjector(this, RoboGuice.DEFAULT_STAGE,
                RoboGuice.newDefaultRoboModule(this), new TestModule());
    }
}
