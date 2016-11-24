package com.coinbase.exchange.api.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentMethodLimitSet)) return false;
        PaymentMethodLimitSet that = (PaymentMethodLimitSet) o;
        return Objects.equal(getBuy(), that.getBuy()) &&
                Objects.equal(getSell(), that.getSell()) &&
                Objects.equal(getInstant_buy(), that.getInstant_buy()) &&
                Objects.equal(getInstant_sell(), that.getInstant_sell()) &&
                Objects.equal(getDeposit(), that.getDeposit()) &&
                Objects.equal(getWithdraw(), that.getWithdraw());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getBuy(), getSell(), getInstant_buy(), getInstant_sell(), getDeposit(), getWithdraw());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("buy", buy)
                .add("sell", sell)
                .add("instant_buy", instant_buy)
                .add("instant_sell", instant_sell)
                .add("deposit", deposit)
                .add("withdraw", withdraw)
                .toString();
    }
}
