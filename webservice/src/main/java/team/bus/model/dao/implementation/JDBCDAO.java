package team.bus.model.dao.implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import team.bus.model.bean.DataBaseInfo;

public abstract class JDBCDAO {

    protected DataBaseInfo dataBaseInfo = null;

    public JDBCDAO() {
        //TODO: [HA][URGENT] Retirar essa definição daqui.
        DataBaseInfo dbi = new DataBaseInfo()
                .withHost("localhost")
                .withDataBase("bus")
                .withUser("postgres")
                .withPassword("123456");

        this.dataBaseInfo = dbi;
    }

    protected Connection createConnection() throws SQLException,
            ClassNotFoundException {

        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://";
        url += this.dataBaseInfo.getHost();
        url += ":";
        url += this.dataBaseInfo.getPort();
        url += "/";
        url += this.dataBaseInfo.getDataBase();

        Properties properties = new Properties();
        properties.setProperty("user", this.dataBaseInfo.getUser());
        properties.setProperty("password", this.dataBaseInfo.getPassword());

        Connection conn = DriverManager.getConnection(url, properties);

        return conn;
    }
}
