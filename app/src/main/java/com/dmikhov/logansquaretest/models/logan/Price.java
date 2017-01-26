package com.dmikhov.logansquaretest.models.logan;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by dmikhov on 26.01.2017.
 */
@JsonObject
public class Price {
    @JsonField
    String currency;
    @JsonField
    int amount;

    public Price() {}

    public Price(String currency, int amount) {
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
        return "JPrice{" +
                "currency='" + currency + '\'' +
                ", amount=" + amount +
                '}';
    }
}
