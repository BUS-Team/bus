package bus.timeline.model.dao;

import bus.bustimeline.model.bean.BusStop;
import bus.bustimeline.model.bean.DataBaseInfo;
import bus.bustimeline.model.bean.Route;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author vinicius
 */
public class BusTimeDAOImpl implements BusTimeDAO {
    
    private DataBaseInfo dataBaseInfo;
    
    public BusTimeDAOImpl(DataBaseInfo dataBaseInfo) {
        this.dataBaseInfo = dataBaseInfo;
    }
    
    protected Connection createConnection() throws SQLException {
        String url = "jdbc:postgresql://";
        url += this.dataBaseInfo.getHost();
        url += '/';
        url += this.dataBaseInfo.getDataBase();
        
        Properties props = new Properties();
        props.setProperty("user", this.dataBaseInfo.getUser());
        props.setProperty("password", this.dataBaseInfo.getPassword());
        
        Connection conn = DriverManager.getConnection(url, props);
        
        return conn;
    }

    public List<Time> loadTimeRouteBusStop(Route route, BusStop busStop) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
