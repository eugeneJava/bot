package binance.bot.core;

import java.time.LocalDateTime;

import static binance.bot.core.OrderDirection.BUY;
import static binance.bot.core.OrderDirection.SELL;

public class Order {
    private int binanceId;
    private String pair;
    private double amount;
    private OrderDirection direction;
    private LocalDateTime date;

    public Order(int binanceId, String pair, double amount, OrderDirection direction) {
        this.binanceId = binanceId;
        this.pair = pair;
        this.amount = amount;
        this.direction = direction;
        this.date = LocalDateTime.now();
    }

    public Order() {

    }

    public static Order buyBitcoinOrder(int binanceId, double amount) {
        return new Order(binanceId, "BTCUSDT", amount, BUY);
    }

    public static Order sellBitcoinOrder(int binanceId, double amount) {
        return new Order(binanceId,"BTCUSDT", amount, SELL);
    }

    public int getBinanceId() {
        return binanceId;
    }

    public Order setBinanceId(int binanceId) {
        this.binanceId = binanceId;
        return this;
    }

    public String getPair() {
        return pair;
    }

    public Order setPair(String pair) {
        this.pair = pair;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public Order setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public OrderDirection getDirection() {
        return direction;
    }

    public Order setDirection(OrderDirection direction) {
        this.direction = direction;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Order setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }
}
