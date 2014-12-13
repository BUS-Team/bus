package br.com.pooler.db.dao;

import br.com.pooler.db.factory.PostgresFactoryDAO;
import org.joda.time.DateTime;

import java.sql.*;

/**
 * Created by breno on 13/12/14.
 */
public class ResponsePositionPostgresDAO implements ResponsePositionDAO {

    private Connection connetion;
    private PreparedStatement preparedStatement;

    public ResponsePositionPostgresDAO() throws Exception {
        connetion = new PostgresFactoryDAO().getConnection();
    }

    private static String query = "INSERT INTO response_positions(bus_line, date_received, content) VALUES (?, ?, ?)";

    @Override
    public void insertResponsePosition(String busLine, String responseContent) throws SQLException {
        connetion.setAutoCommit(false);
        preparedStatement = connetion.prepareStatement(query);
        preparedStatement.setInt(1, Integer.parseInt(busLine));
        preparedStatement.setTimestamp(2, new Timestamp(new DateTime().getMillis()));
        preparedStatement.setString(3, responseContent);
        preparedStatement.executeUpdate();
        connetion.commit();
        preparedStatement.close();
    }
}
