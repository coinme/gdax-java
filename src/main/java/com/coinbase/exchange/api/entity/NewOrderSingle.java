package com.coinbase.exchange.api.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by irufus on 2/25/15.
 */
public abstract class NewOrderSingle implements Serializable {
    private String client_oid; //optional
    private String type; //default is limit, other types are market and stop
    private String side;
    private String product_id;
    private String stp; //optional: values are dc, co , cn , cb
    private BigDecimal funds;

    public String getStp() {
        return stp;
    }

    public void setStp(String stp) {
        this.stp = stp;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getClient_oid() {
        return client_oid;
    }

    public void setClient_oid(String client_oid) {
        this.client_oid = client_oid;
    }

    public BigDecimal getFunds() {
        return funds;
    }

    public void setFunds(BigDecimal funds) {
        this.funds = funds;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("client_oid", client_oid)
                .add("type", type)
                .add("side", side)
                .add("product_id", product_id)
                .add("stp", stp)
                .add("funds", funds)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewOrderSingle)) return false;
        NewOrderSingle that = (NewOrderSingle) o;
        return Objects.equal(getClient_oid(), that.getClient_oid()) &&
                Objects.equal(getType(), that.getType()) &&
                Objects.equal(getSide(), that.getSide()) &&
                Objects.equal(getProduct_id(), that.getProduct_id()) &&
                Objects.equal(getStp(), that.getStp()) &&
                Objects.equal(getFunds(), that.getFunds());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getClient_oid(), getType(), getSide(), getProduct_id(), getStp(), getFunds());
    }
}
