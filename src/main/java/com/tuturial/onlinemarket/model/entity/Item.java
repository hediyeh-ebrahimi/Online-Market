package com.tuturial.onlinemarket.model.entity;

public class Item {
    private Long productId;
    private Long cnt;

    public Item() {
    }

    public Item(Long productId, Long cnt) {
        this.productId = productId;
        this.cnt = cnt;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCnt() {
        return cnt;
    }

    public void setCnt(Long cnt) {
        this.cnt = cnt;
    }
}
