package binance.bot.db;

import java.util.Properties;

public class DbConfiguration {
    private String host;
    private String dbName;
    private String user;
    private String password;

    DbConfiguration() {
        load();
    }

    private void load() {
        try {
            Properties properties = new Properties();
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
            host = properties.getProperty("host", "localhost");
            dbName = properties.getProperty("dbName", "binanceBot");
            user = properties.getProperty("user", "admin");
            password = properties.getProperty("password", "");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getHost() {
        return host;
    }

    public String getDbName() {
        return dbName;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
