package team.bus.model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import team.bus.model.dao.BusStopDAO;
import team.bus.model.bean.BusStop;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import team.bus.model.bean.DataBaseInfo;


public class BusStopDAOImpl extends JDBCDAO implements BusStopDAO {
    private List<BusStop> busStop = null;
    
    public BusStopDAOImpl()  {
        this.busStop = new ArrayList<BusStop>();
        
        //TODO: [HA][URGENT] Retirar essa definição daqui.
        DataBaseInfo dbi = 
                new DataBaseInfo().withHost("localhost")
                .withDataBase("bus")
                .withUser("postgres")
                .withPassword("123456");
        
        this.dataBaseInfo = dbi;
    }
    
    private final static String SELECT_ALL = 
            "SELECT id, name FROM localization.bus_stop";
    
    @Override
    public List<BusStop> getAll() throws SQLException {
        Connection con = null;
        try {
            con = this.createConnection();
        } catch (ClassNotFoundException ex) {
            
        }
        PreparedStatement stmt = con.prepareStatement(BusStopDAOImpl.SELECT_ALL);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
            BusStop bs = new BusStop()
                    .withId(rs.getInt("id"))
                    .withName(rs.getString("name"));
            this.busStop.add(bs);
        }
        return this.busStop;
    }
}
