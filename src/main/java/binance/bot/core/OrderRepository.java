package binance.bot.core;

import binance.bot.db.Repository;
import binance.bot.db.ResultTransformer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

public class OrderRepository extends Repository {

    public void saveOrder(Order order) {
        String sql = "INSERT INTO Orders(currency, amount) VALUES (" + order.getCurrency() + ", " + order.getAmount() + ")";
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
                    String currency = resultSet.getString("currency");
                    int amount = resultSet.getInt("amount");
                    orders.add(new Order(currency, amount));
                }
            } catch (SQLException e) {
                  throw new RuntimeException(e);
            }

            return orders;
        }
    }
}
