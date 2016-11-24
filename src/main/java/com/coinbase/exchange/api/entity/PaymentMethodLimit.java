package com.coinbase.exchange.api.entity;

import org.joda.money.Money;

import java.io.Serializable;

/**
 * @author msmyers
 * @since 11/24/16
 */
public class PaymentMethodLimit implements Serializable {

    private int periodInDays;
    private Money total;
    private Money remaining;

    public int getPeriodInDays() {
        return periodInDays;
    }

    public void setPeriodInDays(int periodInDays) {
        this.periodInDays = periodInDays;
    }

    public Money getTotal() {
        return total;
    }

    public void setTotal(Money total) {
        this.total = total;
    }

    public Money getRemaining() {
        return remaining;
    }

    public void setRemaining(Money remaining) {
        this.remaining = remaining;
    }
}
