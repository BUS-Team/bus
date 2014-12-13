package br.com.pooler.db.factory;

import br.com.pooler.db.DataBaseType;
import br.com.pooler.db.dao.DAOResponsePosition;

import java.sql.Connection;

/**
 * Created by breno on 13/12/14.
 */
public abstract class DAOFactory {

    public abstract DAOResponsePosition getResponsePositionDAO() throws Exception;

    public abstract Connection getConnection() throws Exception;

    public static DAOFactory getDAOFactory(DataBaseType dataBaseType) throws ClassNotFoundException {
        switch (dataBaseType) {
            case POSTGRES:
                return new PostgresDAOFactory();
            case MYSQL:
                return null;
            default:
                return null;
        }
    }
}
