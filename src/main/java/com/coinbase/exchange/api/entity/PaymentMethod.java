package com.coinbase.exchange.api.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

/**
 * @author msmyers
 * @since 11/24/16
 * @see {https://docs.gdax.com/#list-payment-methods}
 */
public class PaymentMethod implements Serializable {

    private String id;
    private String type;
    private String name;
    private String currency;
    private Boolean primary_buy;
    private Boolean primary_sell;

    private Boolean allow_sell;
    private Boolean allow_buy;
    private Boolean allow_deposit;
    private Boolean allow_withdraw;

    private PaymentMethodLimitSet limits;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getPrimary_buy() {
        return primary_buy;
    }

    public void setPrimary_buy(Boolean primary_buy) {
        this.primary_buy = primary_buy;
    }

    public Boolean getPrimary_sell() {
        return primary_sell;
    }

    public void setPrimary_sell(Boolean primary_sell) {
        this.primary_sell = primary_sell;
    }

    public Boolean getAllow_sell() {
        return allow_sell;
    }

    public void setAllow_sell(Boolean allow_sell) {
        this.allow_sell = allow_sell;
    }

    public Boolean getAllow_buy() {
        return allow_buy;
    }

    public void setAllow_buy(Boolean allow_buy) {
        this.allow_buy = allow_buy;
    }

    public Boolean getAllow_deposit() {
        return allow_deposit;
    }

    public void setAllow_deposit(Boolean allow_deposit) {
        this.allow_deposit = allow_deposit;
    }

    public Boolean getAllow_withdraw() {
        return allow_withdraw;
    }

    public void setAllow_withdraw(Boolean allow_withdraw) {
        this.allow_withdraw = allow_withdraw;
    }

    public PaymentMethodLimitSet getLimits() {
        return limits;
    }

    public void setLimits(PaymentMethodLimitSet limits) {
        this.limits = limits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentMethod)) return false;
        PaymentMethod that = (PaymentMethod) o;
        return Objects.equal(getId(), that.getId()) &&
                Objects.equal(getType(), that.getType()) &&
                Objects.equal(getName(), that.getName()) &&
                Objects.equal(getCurrency(), that.getCurrency()) &&
                Objects.equal(getPrimary_buy(), that.getPrimary_buy()) &&
                Objects.equal(getPrimary_sell(), that.getPrimary_sell()) &&
                Objects.equal(getAllow_sell(), that.getAllow_sell()) &&
                Objects.equal(getAllow_buy(), that.getAllow_buy()) &&
                Objects.equal(getAllow_deposit(), that.getAllow_deposit()) &&
                Objects.equal(getAllow_withdraw(), that.getAllow_withdraw()) &&
                Objects.equal(getLimits(), that.getLimits());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("type", type)
                .add("name", name)
                .add("currency", currency)
                .add("primary_buy", primary_buy)
                .add("primary_sell", primary_sell)
                .add("allow_sell", allow_sell)
                .add("allow_buy", allow_buy)
                .add("allow_deposit", allow_deposit)
                .add("allow_withdraw", allow_withdraw)
                .add("limits", limits)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getType(), getName(), getCurrency(), getPrimary_buy(), getPrimary_sell(), getAllow_sell(), getAllow_buy(), getAllow_deposit(), getAllow_withdraw(), getLimits());
    }
}
