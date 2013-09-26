package bus.timetable.model.dao;

import bus.timetable.model.dao.BusTimeDAOImpl;
import bus.timetable.model.bean.BusStop;
import bus.timetable.model.bean.DataBaseInfo;
import bus.timetable.model.bean.Route;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author vinicius
 */
public class BusTimeDAOImplTest {
    DataBaseInfo dbInfo;
    
    public BusTimeDAOImplTest() {
        this.dbInfo = new DataBaseInfo();
        dbInfo.setHost("localhost");
        dbInfo.setDataBase("bus");
        dbInfo.setUser("postgres");
        dbInfo.setPassword("bus");
    }

    /**
     * Test of createConnection method, of class BusTimeDAOImpl.
     * 
     */
    @Ignore("This test really connect the database. To run, check the dbInfo.")
    @Test
    public void testCreateConnection() throws Exception {        
        BusTimeDAOImpl dao = new BusTimeDAOImpl(this.dbInfo);
        dao.createConnection();
    }
    
    /** Test LoadTimeRouteBusStop.
     * Query for: bus_id = 307
     *            destination = TERMINAL_CENTRAL
     *            bus_stop_name
     */
    @Test
    public void testLoadTimeRouteBusStop() throws SQLException {
        
        Route route = new Route();
        route.setBusId(307);
        route.setDestination("TERMINAL_CENTRAL");
        
        BusStop busStop = new BusStop();
        busStop.setId(1);
        busStop.setName("ru_uel");
        
        BusTimeDAOImpl dao = new BusTimeDAOImpl(this.dbInfo);
        List<Time> times = dao.loadTimeRouteBusStop(route, busStop);
        for (Time t : times) 
            System.out.println(t);
        
    }

}