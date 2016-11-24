package com.coinbase.exchange.api.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by irufus on 7/31/15.
 */
public class NewLimitOrderSingle extends NewOrderSingle{
    private BigDecimal price;
    private BigDecimal size;

    public NewLimitOrderSingle(){
        setType("limit");
    }

    public BigDecimal getPrice() {
        return price;
    }


    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("price", price)
                .add("size", size)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewLimitOrderSingle)) return false;
        NewLimitOrderSingle that = (NewLimitOrderSingle) o;
        return Objects.equal(getPrice(), that.getPrice()) &&
                Objects.equal(getSize(), that.getSize());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getPrice(), getSize());
    }
}
