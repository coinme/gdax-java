package com.coinbase.exchange.api.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by irufus on 2/18/15.
 */
public class Hold  implements Serializable {
    private String created_at;
    private String update_at;
    private String order_id;
    private BigDecimal amount;
    private String account_id;

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("created_at", created_at)
                .add("update_at", update_at)
                .add("order_id", order_id)
                .add("amount", amount)
                .add("account_id", account_id)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hold)) return false;
        Hold hold = (Hold) o;
        return Objects.equal(getCreated_at(), hold.getCreated_at()) &&
                Objects.equal(getUpdate_at(), hold.getUpdate_at()) &&
                Objects.equal(getOrder_id(), hold.getOrder_id()) &&
                Objects.equal(getAmount(), hold.getAmount()) &&
                Objects.equal(getAccount_id(), hold.getAccount_id());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getCreated_at(), getUpdate_at(), getOrder_id(), getAmount(), getAccount_id());
    }
}
