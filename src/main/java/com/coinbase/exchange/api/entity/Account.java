package com.coinbase.exchange.api.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by irufus on 2/18/15.
 */
public class Account implements Serializable {
    private String id;
    private BigDecimal balance;
    private BigDecimal hold;
    private BigDecimal available;
    private String currency;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getHold() {
        return hold;
    }

    public void setHold(BigDecimal hold) {
        this.hold = hold;
    }

    public BigDecimal getAvailable() {
        return available;
    }

    public void setAvailable(BigDecimal available) {
        this.available = available;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("balance", balance)
                .add("hold", hold)
                .add("available", available)
                .add("currency", currency)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equal(getId(), account.getId()) &&
                Objects.equal(getBalance(), account.getBalance()) &&
                Objects.equal(getHold(), account.getHold()) &&
                Objects.equal(getAvailable(), account.getAvailable()) &&
                Objects.equal(getCurrency(), account.getCurrency());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getBalance(), getHold(), getAvailable(), getCurrency());
    }
}
