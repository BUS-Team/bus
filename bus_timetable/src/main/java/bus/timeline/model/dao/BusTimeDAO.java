package bus.timeline.model.dao;

import bus.bustimeline.model.bean.BusStop;
import bus.bustimeline.model.bean.Route;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author vinicius
 */
public interface BusTimeDAO {
    //TODO: Improve this method name, loadTimeRouteBusStop sound weird
    public List<Time> loadTimeRouteBusStop(Route route, BusStop busStop) 
                                                        throws SQLException;
}
