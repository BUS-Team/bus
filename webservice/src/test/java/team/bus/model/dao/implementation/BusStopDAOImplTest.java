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
        
        BusStop busStop = null;
        
        List<BusStop> busStops = new ArrayList<BusStop>();
        
        busStop = new BusStop().withId(1).withName("RU - Bairro-Centro");
        busStops.add(busStop);

        busStop = new BusStop().withId(2).withName("RU - Centro-Bairro");
        busStops.add(busStop);

        busStop = new BusStop().withId(3).withName("RU - CCH");
        busStops.add(busStop);

        busStop = new BusStop().withId(4).withName("RU - CCB");
        busStops.add(busStop);

        busStop = new BusStop().withId(5).withName("RU - CCA");
        busStops.add(busStop);
        
        BusStopDAOImpl bsdi = new BusStopDAOImpl(new ArrayList<BusStop>());
        List<BusStop> result = bsdi.getAll();
        
        System.out.println("#Expected");
        for (BusStop bs : busStops) {
            System.out.println("id: " + bs.getId() + " name: " + bs.getName());
        }

        System.out.println("#Result");
        for (BusStop bs : result) {
            System.out.println("id: " + bs.getId() + " name: " + bs.getName());
        }
        
        assertEquals(result, busStops);        
    }
    
}
