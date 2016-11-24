package com.coinbase.exchange.api.entity;

import org.joda.money.Money;

import java.io.Serializable;

/**
 * @author msmyers
 * @since 11/24/16
 */
public class PaymentMethodLimitSet implements Serializable {

    private PaymentMethodLimit[] buy;
    private PaymentMethodLimit[] sell;
    private PaymentMethodLimit[] instant_buy;
    private PaymentMethodLimit[] instant_sell;
    private PaymentMethodLimit[] deposit;
    private PaymentMethodLimit[] withdraw;

    public PaymentMethodLimit[] getBuy() {
        return buy;
    }

    public void setBuy(PaymentMethodLimit[] buy) {
        this.buy = buy;
    }

    public PaymentMethodLimit[] getSell() {
        return sell;
    }

    public void setSell(PaymentMethodLimit[] sell) {
        this.sell = sell;
    }

    public PaymentMethodLimit[] getInstant_buy() {
        return instant_buy;
    }

    public void setInstant_buy(PaymentMethodLimit[] instant_buy) {
        this.instant_buy = instant_buy;
    }

    public PaymentMethodLimit[] getInstant_sell() {
        return instant_sell;
    }

    public void setInstant_sell(PaymentMethodLimit[] instant_sell) {
        this.instant_sell = instant_sell;
    }

    public PaymentMethodLimit[] getDeposit() {
        return deposit;
    }

    public void setDeposit(PaymentMethodLimit[] deposit) {
        this.deposit = deposit;
    }

    public PaymentMethodLimit[] getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(PaymentMethodLimit[] withdraw) {
        this.withdraw = withdraw;
    }
}
