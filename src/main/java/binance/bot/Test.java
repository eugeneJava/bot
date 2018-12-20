package binance.bot;

import binance.bot.core.Order;
import binance.bot.core.OrderRepository;

public class Test {
    public static void main(String[] args) {
        OrderRepository orderRepository = new OrderRepository();


        orderRepository.saveOrder(Order.sellBitcoinOrder(12,23));
    }
}
