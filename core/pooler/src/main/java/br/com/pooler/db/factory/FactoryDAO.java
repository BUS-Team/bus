package br.com.pooler.db.factory;

import br.com.pooler.db.DataBaseType;
import br.com.pooler.db.dao.ResponsePositionDAO;

import java.sql.Connection;

/**
 * Created by breno on 13/12/14.
 */
public abstract class FactoryDAO {

    public abstract ResponsePositionDAO getResponsePositionDAO() throws Exception;

    public abstract Connection getConnection() throws Exception;

    public static FactoryDAO getDAOFactory(DataBaseType dataBaseType) throws ClassNotFoundException {
        switch (dataBaseType) {
            case POSTGRES:
                return new PostgresFactoryDAO();
            case MYSQL:
                return null;
            default:
                return null;
        }
    }
}
