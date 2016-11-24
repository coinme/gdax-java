package com.coinbase.exchange.api.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by irufus on 2/18/15.
 */
public class Fill implements Serializable {
    private Integer trade_id;
    private String product_id;
    private Double size;
    private String order_id;
    private String created_at;
    private BigDecimal fee;
    private Boolean settled;
    private String side;

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public Boolean getSettled() {
        return settled;
    }

    public void setSettled(Boolean settled) {
        this.settled = settled;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public Integer getTrade_id() {
        return trade_id;
    }

    public void setTrade_id(Integer trade_id) {
        this.trade_id = trade_id;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("trade_id", trade_id)
                .add("product_id", product_id)
                .add("size", size)
                .add("order_id", order_id)
                .add("created_at", created_at)
                .add("fee", fee)
                .add("settled", settled)
                .add("side", side)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fill)) return false;
        Fill fill = (Fill) o;
        return Objects.equal(getTrade_id(), fill.getTrade_id()) &&
                Objects.equal(getProduct_id(), fill.getProduct_id()) &&
                Objects.equal(getSize(), fill.getSize()) &&
                Objects.equal(getOrder_id(), fill.getOrder_id()) &&
                Objects.equal(getCreated_at(), fill.getCreated_at()) &&
                Objects.equal(getFee(), fill.getFee()) &&
                Objects.equal(getSettled(), fill.getSettled()) &&
                Objects.equal(getSide(), fill.getSide());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getTrade_id(), getProduct_id(), getSize(), getOrder_id(), getCreated_at(), getFee(), getSettled(), getSide());
    }
}
