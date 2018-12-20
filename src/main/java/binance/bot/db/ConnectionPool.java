package binance.bot.db;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public enum  ConnectionPool {

    INSTANCE;

    private BasicDataSource dataSource = new BasicDataSource();

    ConnectionPool() {
        init();
    }

    private void init() {
        try {
            DbConfiguration dbConfiguration = new DbConfiguration();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl(getConnectionString(dbConfiguration));
            dataSource.setUsername(dbConfiguration.getUser());
            dataSource.setPassword(dbConfiguration.getPassword());
            dataSource.setInitialSize(3);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getConnectionString(DbConfiguration dbConfiguration) {
        String connectionString = String.format("jdbc:mysql://%s:3306/%s?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", dbConfiguration.getHost(), dbConfiguration.getDbName());
        return connectionString;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
