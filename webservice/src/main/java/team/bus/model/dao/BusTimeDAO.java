package team.bus.model.dao;

import team.bus.model.bean.BusStop;
import team.bus.model.bean.Route;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

public interface BusTimeDAO {
    //TODO: Improve this method name, loadTimeRouteBusStop sound weird
    public List<Time> loadTimeRouteBusStop(Route route, BusStop busStop) 
                                                        throws SQLException;
}
