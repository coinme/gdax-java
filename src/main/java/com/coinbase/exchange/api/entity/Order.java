package com.coinbase.exchange.api.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by irufus on 2/18/15.
 */
public class Order  implements Serializable {
    private String id;
    private BigDecimal size;
    private BigDecimal price;
    private String product_id;
    private String status;
    private BigDecimal filled_size;
    private BigDecimal fill_fees;
    private Boolean settled;
    private String side;
    private String created_at;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getFilled_size() {
        return filled_size;
    }

    public void setFilled_size(BigDecimal filled_size) {
        this.filled_size = filled_size;
    }

    public BigDecimal getFill_fees() {
        return fill_fees;
    }

    public void setFill_fees(BigDecimal fill_fees) {
        this.fill_fees = fill_fees;
    }

    public Boolean getSettled() {
        return settled;
    }

    public void setSettled(Boolean settled) {
        this.settled = settled;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
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
                .add("id", id)
                .add("size", size)
                .add("price", price)
                .add("product_id", product_id)
                .add("status", status)
                .add("filled_size", filled_size)
                .add("fill_fees", fill_fees)
                .add("settled", settled)
                .add("side", side)
                .add("created_at", created_at)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equal(getId(), order.getId()) &&
                Objects.equal(getSize(), order.getSize()) &&
                Objects.equal(getPrice(), order.getPrice()) &&
                Objects.equal(getProduct_id(), order.getProduct_id()) &&
                Objects.equal(getStatus(), order.getStatus()) &&
                Objects.equal(getFilled_size(), order.getFilled_size()) &&
                Objects.equal(getFill_fees(), order.getFill_fees()) &&
                Objects.equal(getSettled(), order.getSettled()) &&
                Objects.equal(getSide(), order.getSide()) &&
                Objects.equal(getCreated_at(), order.getCreated_at());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getSize(), getPrice(), getProduct_id(), getStatus(), getFilled_size(), getFill_fees(), getSettled(), getSide(), getCreated_at());
    }
}
