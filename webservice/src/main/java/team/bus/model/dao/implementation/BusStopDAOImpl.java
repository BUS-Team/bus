package team.bus.model.dao.implementation;

import team.bus.model.dao.BusStopDAO;
import team.bus.model.bean.*;

import java.sql.*;
import java.util.*;
import team.bus.model.dao.sql.BusStopSQL;

public class BusStopDAOImpl extends JDBCDAO implements BusStopDAO {
    private List<BusStop> busStop = null;

    public BusStopDAOImpl(List<BusStop> busStopImpl)  {
        if (busStopImpl == null)
            throw new IllegalArgumentException("The argument from constructor "
                    + "shouldn't be null. Argument ex: new ArrayList<BusStop>");
        this.busStop = busStopImpl;        
    }
        
    @Override
    public List<BusStop> getAll() throws SQLException {
        Connection con = null;
        try {
            con = this.createConnection();
        } catch (ClassNotFoundException ex) {
            //TODO: [HA][URGENT] Tratar o erro.
        }
        PreparedStatement stmt = 
                con.prepareStatement(BusStopSQL.SELECT_ALL);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
            this.loadBusStop(rs);
        }
        return this.busStop;
    }

    private void loadBusStop(ResultSet rs) throws SQLException {
        BusStop bs = new BusStop()
                .withId(rs.getInt("id"))
                .withName(rs.getString("name"));
        this.busStop.add(bs);
    }
}