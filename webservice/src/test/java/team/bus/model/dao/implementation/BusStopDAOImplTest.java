package team.bus.model.dao.implementation;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import team.bus.model.bean.BusStop;

public class BusStopDAOImplTest {
    
    public BusStopDAOImplTest() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorParamNull() {
        System.out.println("testConstructorParamNull");
        BusStopDAOImpl busStopDAOImpl = new BusStopDAOImpl(null);
    }
    
    @Test
    public void testGetAll() throws Exception {
        System.out.println("testGetAll");
        
        BusStop bs = null;
        
        List<BusStop> busStops = new ArrayList<BusStop>();
        
        bs = new BusStop().withId(1).withName("RU - Bairro-Centro");
        busStops.add(bs);

        bs = new BusStop().withId(1).withName("RU - Centro-Bairro");
        busStops.add(bs);

        bs = new BusStop().withId(1).withName("RU - CCH");
        busStops.add(bs);

        bs = new BusStop().withId(1).withName("RU - CCB");
        busStops.add(bs);

        bs = new BusStop().withId(1).withName("RU - CCA");
        busStops.add(bs);
        
        BusStopDAOImpl bsdi = new BusStopDAOImpl(new ArrayList<BusStop>());
        
    }
    
}
