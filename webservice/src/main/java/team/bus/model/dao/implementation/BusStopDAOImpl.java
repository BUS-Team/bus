package team.bus.model.dao.implementation;

import java.sql.Connection;
import java.sql.SQLException;
import team.bus.model.dao.BusStopDAO;
import team.bus.model.bean.BusStop;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BusStopDAOImpl extends JDBCDAO implements BusStopDAO {

    private List<BusStop> busStop = null;
    public BusStopDAOImpl() {
        this.busStop = new ArrayList<BusStop>();
    }
    
    public BusStopDAOImpl(List<BusStop> listImplementation)  {
        this.busStop = listImplementation;
    }
    
    @Override
    public List<BusStop> getAll() {
        try {
            Connection con = this.createConnection();
            Prepares
        } catch (SQLException ex) {
            //TODO: [HA][URGENT] tratar o erro;
        }
        return this.busStop;
    }
}
