package binance.bot;

import binance.bot.core.Order;
import binance.bot.core.OrderRepository;

public class OrderServcie {
    private OrderRepository orderRepository;

    public OrderServcie(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public int makeOrder() {
        //1. вызосв ии б
        return 0;
    }

    public int buyBitcoin(double amount) {
        //1. вызосв ии бинанс апи для создания ордера
        int binanceId = 0; // вместо нуля подставь ийди из бинанса
        Order order = Order.buyBitcoinOrder(binanceId, amount);
        orderRepository.saveOrder(order);
        return binanceId;
    }

    public int sellBitcoin(double amount) {
        //1. вызосв ии бинанс апи для создания ордера
        int binanceId = 0; // вместо нуля подставь ийди из бинанса
        Order order = Order.sellBitcoinOrder(binanceId, amount);
        orderRepository.saveOrder(order);
        return binanceId;
    }
}
