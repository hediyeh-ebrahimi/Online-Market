package com.tuturial.onlinemarket.model.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "order_item")
@Table(name = "order_item")
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "order_item_seq")
    @SequenceGenerator(name = "order_item_seq",sequenceName = "order_item_seq",allocationSize = 1)
    private Long orderItemId;

    @ManyToOne
    @JoinColumn(name = "product_id",foreignKey = @ForeignKey(name = "order_item_fk_product"),nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id",foreignKey = @ForeignKey(name = "order_item_fk_order"),nullable = false)
    private Order order;

    @Column(name = "cnt",columnDefinition = "number")
    private long cnt;

    @Column(name = "price",columnDefinition = "number")
    private Long price;

    @Column(name = "discount_price",columnDefinition = "number")
    private Long discountPrice;

    @Column(name = "create_at",columnDefinition = "date")
    @CreationTimestamp
    private LocalDate createdAt;

    @Column(name = "update_at",columnDefinition = "date")
    @UpdateTimestamp
    private LocalDate updatedAt;

    public OrderItem() {
    }

    public OrderItem(Product product, Order order, long cnt, Long price, Long discountPrice, LocalDate createdAt, LocalDate updatedAt) {
        this.product = product;
        this.order = order;
        this.cnt = cnt;
        this.price = price;
        this.discountPrice = discountPrice;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public long getCnt() {
        return cnt;
    }

    public void setCnt(long cnt) {
        this.cnt = cnt;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Long discountPrice) {
        this.discountPrice = discountPrice;
    }
}
