package br.com.pooler.db.dao;

import br.com.pooler.db.bean.ResponsePosition;
import br.com.pooler.db.factory.DAOFactory;
import br.com.pooler.db.factory.PostgresDAOFactory;

import java.sql.*;

/**
 * Created by breno on 13/12/14.
 */
public class PostgresDAOResponsePosition implements DAOResponsePosition {

    private Connection connetion;
    private PreparedStatement preparedStatement;

    public PostgresDAOResponsePosition() throws Exception {
        connetion = new PostgresDAOFactory().getConnection();
    }

    private static String query = "INSERT INTO response_position(bus_line, date_received, content) VALUES (?, ?, ?)";

    @Override
    public void insertResponsePosition(ResponsePosition responsePosition) throws SQLException {
        connetion.setAutoCommit(false);
        preparedStatement = connetion.prepareStatement(query);
        preparedStatement.setInt(1, responsePosition.getBusLine());
        preparedStatement.setTimestamp(2, new Timestamp(responsePosition.getDateTime().getMillis()));
        preparedStatement.setString(3, responsePosition.getContent());
        preparedStatement.executeUpdate();
        connetion.commit();
        preparedStatement.close();
    }
}
