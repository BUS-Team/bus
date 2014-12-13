package br.com.pooler.module;

import br.com.pooler.config.AppConfiguration;

import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by breno on 13/12/14.
 */
public class PoolerModule {
    private final static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(4);

    public PoolerModule() throws Exception {
        for(String busLine : AppConfiguration.busLines) {
            scheduler.scheduleAtFixedRate(new Pooler(busLine), 0, 15, TimeUnit.SECONDS);
        }
    }
}
