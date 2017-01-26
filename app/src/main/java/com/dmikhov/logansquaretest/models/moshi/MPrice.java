package com.dmikhov.logansquaretest.models.moshi;

/**
 * Created by dmikhov on 26.01.2017.
 */
public class MPrice {
    String currency;
    int amount;

    public MPrice() {}

    public MPrice(String currency, int amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "MPrice{" +
                "currency='" + currency + '\'' +
                ", amount=" + amount +
                '}';
    }
}
