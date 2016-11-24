package com.coinbase.exchange.api.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

/**
 * Created by irufus on 2/25/15.
 */
public class Detail  implements Serializable {
    private String order_id;
    private Integer trade_id;
    private String product_id;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Integer getTrade_id() {
        return trade_id;
    }

    public void setTrade_id(Integer trade_id) {
        this.trade_id = trade_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("order_id", order_id)
                .add("trade_id", trade_id)
                .add("product_id", product_id)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Detail)) return false;
        Detail detail = (Detail) o;
        return Objects.equal(getOrder_id(), detail.getOrder_id()) &&
                Objects.equal(getTrade_id(), detail.getTrade_id()) &&
                Objects.equal(getProduct_id(), detail.getProduct_id());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getOrder_id(), getTrade_id(), getProduct_id());
    }
}
