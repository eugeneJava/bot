package binance.bot.core;

import java.util.Set;

public class Order {
    private String currency;
    private int amount;

    public Order(String currency,int amount) {
        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}
