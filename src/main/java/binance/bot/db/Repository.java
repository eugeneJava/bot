package binance.bot.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Repository {

    public void executeUpdate(String sql) {
        Statement statement = null;
        try {
            statement = ConnectionPool.INSTANCE.getConnection().createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public <R> R executeQuery(String sql, ResultTransformer<R> transformer) {
        Statement statement = null;
        try {
            statement = ConnectionPool.INSTANCE.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            R result = transformer.transform(resultSet);
            resultSet.close();
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
