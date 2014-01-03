package team.bus.model.dao.implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import team.bus.model.bean.DataBaseInfo;

public abstract class JDBCDAO {
    protected DataBaseInfo dataBaseInfo = null;
    
    protected Connection createConnection() throws SQLException, 
            ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        
        String url = "jdbc:postgresql://";
        url += this.dataBaseInfo.getHost();
        url += ":";
        url += this.dataBaseInfo.getPort();
        url += "/";
        url += this.dataBaseInfo.getDataBase();
        
        Properties props = new Properties();
        props.setProperty("user", this.dataBaseInfo.getUser());
        props.setProperty("password", this.dataBaseInfo.getPassword());
        
        Connection conn = DriverManager.getConnection(url, props);
        
        return conn;
    }    
}
