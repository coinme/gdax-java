package com.coinbase.exchange.api.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.joda.money.Money;

import java.io.Serializable;

/**
 * @author msmyers
 * @since 11/24/16
 * @see {https://docs.gdax.com/#list-payment-methods}
 */
public class PaymentMethodLimit implements Serializable {

    private Integer period_in_days;
    private Money total;
    private Money remaining;

    public Integer getPeriod_in_days() {
        return period_in_days;
    }

    public void setPeriod_in_days(Integer period_in_days) {
        this.period_in_days = period_in_days;
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

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("period_in_days", period_in_days)
                .add("total", total)
                .add("remaining", remaining)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentMethodLimit)) return false;
        PaymentMethodLimit that = (PaymentMethodLimit) o;
        return Objects.equal(getPeriod_in_days(), that.getPeriod_in_days()) &&
                Objects.equal(getTotal(), that.getTotal()) &&
                Objects.equal(getRemaining(), that.getRemaining());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getPeriod_in_days(), getTotal(), getRemaining());
    }
}
