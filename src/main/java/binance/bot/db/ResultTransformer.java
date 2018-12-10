package binance.bot.db;

import java.sql.ResultSet;

public interface ResultTransformer<R> {
    public R transform(ResultSet resultSet);
}
