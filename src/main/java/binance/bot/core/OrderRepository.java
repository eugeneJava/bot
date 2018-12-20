package binance.bot.core;

import binance.bot.db.DateFormatter;
import binance.bot.db.DbUtils;
import binance.bot.db.Repository;
import binance.bot.db.ResultTransformer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

public class OrderRepository extends Repository {

    public void saveOrder(Order order) {
        String sql = "INSERT INTO Orders(" +
                "binanceId, " +
                "pair, " +
                "amount, " +
                "direction, " +
                "date " +


                ") VALUES ("

                + order.getBinanceId() + ", "
                + DbUtils.addQuotes(order.getPair()) + ", "
                + order.getAmount() + ", "
                + DbUtils.addQuotes(order.getDirection().toString()) + ", "
                + DbUtils.addQuotes(DateFormatter.formatDate(order.getDate())) +
                ")";
        executeUpdate(sql);
    }

    public Set<Order> getAllOrders() {
        String sql = "SELECT * FROM Orders";
        return executeQuery(sql, new OrderResultTransformer());
    }

    private class OrderResultTransformer implements ResultTransformer<Set<Order>> {
        public Set<Order> transform(ResultSet resultSet) {
            Set<Order> orders = new LinkedHashSet<Order>();

              try {
                while(resultSet.next()){
                    int binanceId = resultSet.getInt("binanceId");
                    String pair = resultSet.getString("pair");
                    double amount = resultSet.getDouble("amount");
                    OrderDirection orderDirection = OrderDirection.valueOf(resultSet.getString("direction"));
                    String date = resultSet.getString("date");

                    Order order = new Order();
                    order.setBinanceId(binanceId);
                    order.setPair(pair);
                    order.setAmount(amount);
                    order.setDirection(orderDirection);
                    order.setDate(DateFormatter.parseDate(date));

                    orders.add(order);
                }
            } catch (SQLException e) {
                  throw new RuntimeException(e);
            }

            return orders;
        }
    }
}
