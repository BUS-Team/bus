package br.com.pooler.db.dao;

import br.com.pooler.db.bean.ResponsePosition;

import java.sql.SQLException;

/**
 * Created by breno on 13/12/14.
 */
public interface DAOResponsePosition {
    public void insertResponsePosition(ResponsePosition responsePosition) throws SQLException;
}
