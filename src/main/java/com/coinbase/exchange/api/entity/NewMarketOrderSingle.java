package com.coinbase.exchange.api.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.math.BigDecimal;

/**
 * Created by irufus on 7/31/15.
 */
public class NewMarketOrderSingle extends NewOrderSingle {
    private BigDecimal size; //optional: Desired amount in BTC
    private BigDecimal funds; //optional: Desired amount of fiat funds to use

    public NewMarketOrderSingle() {
        setType("market");
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    @Override
    public BigDecimal getFunds() {
        return funds;
    }

    @Override
    public void setFunds(BigDecimal funds) {
        this.funds = funds;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("size", size)
                .add("funds", funds)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewMarketOrderSingle)) return false;
        NewMarketOrderSingle that = (NewMarketOrderSingle) o;
        return Objects.equal(getSize(), that.getSize()) &&
                Objects.equal(getFunds(), that.getFunds());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getSize(), getFunds());
    }
}
