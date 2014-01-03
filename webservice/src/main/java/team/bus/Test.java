package team.bus;

import team.bus.model.bean.BusStop;
import team.bus.model.bean.DataBaseInfo;
import team.bus.model.bean.Route;
import team.bus.model.dao.implementation.BusTimeDAOImpl;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author vinicius
 */
public class Test {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        //configurações do bd
        DataBaseInfo dbInfo = new DataBaseInfo();
        dbInfo.setHost("localhost");
        dbInfo.setDataBase("bus");
        dbInfo.setUser("postgres");
        dbInfo.setPassword("bus");
        //rota 307, sentido TERMINAL_CENTRAL
        Route route = new Route();
        route.setBusId(307);
        route.setDestination("TERMINAL_CENTRAL");
        
        BusStop busStop = new BusStop();
        busStop.setId(1);
        busStop.setName("ru_uel");
        
        BusTimeDAOImpl dao = new BusTimeDAOImpl(dbInfo);
        List<Time> times = dao.loadTimeRouteBusStop(route, busStop);
        
        System.out.println("Bus: " + route.getBusId());
        System.out.println("Destination: " + route.getDestination());
        System.out.println("Bus Stop name: " + busStop.getName());
        System.out.println("Times: ");
        for (Time t : times) 
            System.out.println(t);
    }
}
