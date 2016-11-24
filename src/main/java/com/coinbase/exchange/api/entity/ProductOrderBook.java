package com.coinbase.exchange.api.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.List;

/**
 * Created by irufus on 8/3/15.
 */
public class ProductOrderBook  implements Serializable {

    private Integer sequence;
    private List<List<String>> bids;
    private List<List<String>> asks;

    public List<List<String>> getAsks() {
        return asks;
    }

    public void setAsks(List<List<String>> asks) {
        this.asks = asks;
    }

    public List<List<String>> getBids() {
        return bids;
    }

    public void setBids(List<List<String>> bids) {
        this.bids = bids;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("sequence", sequence)
                .add("bids", bids)
                .add("asks", asks)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductOrderBook)) return false;
        ProductOrderBook that = (ProductOrderBook) o;
        return Objects.equal(getSequence(), that.getSequence()) &&
                Objects.equal(getBids(), that.getBids()) &&
                Objects.equal(getAsks(), that.getAsks());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getSequence(), getBids(), getAsks());
    }
}
