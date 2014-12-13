package br.com.pooler.db.factory;

import java.sql.*;

import br.com.pooler.db.dao.DAOResponsePosition;
import br.com.pooler.db.dao.PostgresDAOResponsePosition;

/**
 * Created by breno on 13/12/14.
 */
public class PostgresDAOFactory extends DAOFactory {

    private static Connection connection = null;
    private String driverName = "org.postgresql.Driver";
    private String url = "jdbc:postgresql://127.0.0.1:5432/tcglpooling";
    private String user = "breno";
    private String password = "root";

    public PostgresDAOFactory() throws ClassNotFoundException {
        Class.forName(driverName);
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
    public DAOResponsePosition getResponsePositionDAO() throws Exception {
        return new PostgresDAOResponsePosition();
    }
}
