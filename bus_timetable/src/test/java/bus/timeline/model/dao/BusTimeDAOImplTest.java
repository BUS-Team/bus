package bus.timeline.model.dao;

import bus.bustimeline.model.bean.BusStop;
import bus.bustimeline.model.bean.DataBaseInfo;
import bus.bustimeline.model.bean.Route;
import java.sql.Connection;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author vinicius
 */
public class BusTimeDAOImplTest {
    
    public BusTimeDAOImplTest() {
    }

    /**
     * Test of createConnection method, of class BusTimeDAOImpl.
     * 
     */
    @Ignore("This test really connect the database. To run, check the dbInfo.")
    @Test
    public void testCreateConnection() throws Exception {
        DataBaseInfo dbInfo = new DataBaseInfo();
        dbInfo.setHost("localhost");
        dbInfo.setDataBase("bus");
        dbInfo.setUser("postgres");
        dbInfo.setPassword("bus");
        
        BusTimeDAOImpl dao = new BusTimeDAOImpl(dbInfo);
        Connection expResult = null;
        Connection conn = dao.createConnection();
    }

}