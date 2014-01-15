package team.bus.model.dao.implementation;

import java.sql.Connection;

import java.util.Properties;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import team.bus.model.bean.DataBaseInfo;

public abstract class JDBCDAO {

    private static String host;
    //private static String port;
    private static String user;
    private static String password;
    private static String dbName;
    protected DataBaseInfo dataBaseInfo = null;

    public JDBCDAO() {
        Properties config = new Properties();
        try {
            //TODO: [HA][URGENT] Test this configuration.
            config.load(JDBCDAO.class.getClassLoader().getResourceAsStream("/database_config.properties"));

            host     = config.getProperty("host");
            //port     = config.getProperty("port");
            user     = config.getProperty("user");
            password = config.getProperty("password");
            dbName   = config.getProperty("dbName");

            //TODO: [HA][URGENT] Retirar essa definição daqui.
            DataBaseInfo dbi = new DataBaseInfo()
                    .withHost(host)
                    .withDataBase(dbName)
                    .withUser(user)
                    .withPassword(password);
            this.dataBaseInfo = dbi;
        } catch (Exception e) {
            Logger.getLogger(JDBCDAO.class.getName()).log(Level.CONFIG, null, e);
        }
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
