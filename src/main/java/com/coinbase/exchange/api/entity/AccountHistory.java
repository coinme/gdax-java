package com.coinbase.exchange.api.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by irufus on 2/18/15.
 */
public class AccountHistory implements Serializable {
    private Integer id;
    private String created_at;
    private BigDecimal amount;
    private BigDecimal balance;
    private String type;
    private Detail detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("created_at", created_at)
                .add("amount", amount)
                .add("balance", balance)
                .add("type", type)
                .add("detail", detail)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountHistory)) return false;
        AccountHistory that = (AccountHistory) o;
        return Objects.equal(getId(), that.getId()) &&
                Objects.equal(getCreated_at(), that.getCreated_at()) &&
                Objects.equal(getAmount(), that.getAmount()) &&
                Objects.equal(getBalance(), that.getBalance()) &&
                Objects.equal(getType(), that.getType()) &&
                Objects.equal(getDetail(), that.getDetail());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getCreated_at(), getAmount(), getBalance(), getType(), getDetail());
    }
}
