package team.bus.model.dao;

import java.sql.SQLException;
import java.util.List;
import team.bus.model.bean.BusStop;

public interface BusStopDAO {
    List<BusStop> getAll() throws SQLException;    
}
