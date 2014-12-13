package br.com.pooler.db.dao;

import java.sql.SQLException;

/**
 * Created by breno on 13/12/14.
 */
public interface ResponsePositionDAO {
    public void insertResponsePosition(String busLine, String responsePosition) throws SQLException;
}
