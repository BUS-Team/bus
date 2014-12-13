package br.com.pooler.db.factory;

import java.io.*;
import java.sql.*;
import java.util.Map;

import br.com.pooler.db.dao.ResponsePositionPostgresDAO;
import br.com.pooler.db.dao.ResponsePositionDAO;
import org.yaml.snakeyaml.Yaml;

/**
 * Created by breno on 13/12/14.
 */
public class PostgresFactoryDAO extends FactoryDAO {
    InputStream input;
    Map<String,String> conf;

    private static Connection connection = null;
    private String driverName;
    private String url;
    private String user;
    private String password;

    public PostgresFactoryDAO() throws ClassNotFoundException {
        try {
            input = this.getClass().getResourceAsStream("/config.yml");
            conf = (Map<String, String>) new Yaml().load(input);

            driverName = conf.get("driverName");
            url = conf.get("url");
            user = conf.get("user");
            password = conf.get("password");

            Class.forName(driverName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws Exception {
        if (connection == null) {
            return connection = DriverManager.getConnection(url, user, password);
        } else {
            return connection;
        }
    }

    @Override
    public ResponsePositionDAO getResponsePositionDAO() throws Exception {
        return new ResponsePositionPostgresDAO();
    }
}
