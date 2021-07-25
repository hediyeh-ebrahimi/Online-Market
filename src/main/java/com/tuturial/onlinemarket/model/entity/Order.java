package com.tuturial.onlinemarket.model.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "order")
@Table (name = "orders")
public class Order implements Serializable {
    @Id
    @Column(name = "order_id",columnDefinition = "number")
    @SequenceGenerator(name = "orders_seq",sequenceName = "orders_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "orders_seq")
    private Long orderId;


    //clientId
    @Column(name = "first_name",columnDefinition = "nvarchar2(20)")
    private String firstName;

    @Column(name = "last_name",columnDefinition = "nvarchar2(30)")
    private String lastName;

    @Column(name = "total_amount",columnDefinition = "number")
    private Long totalAmount;

    @Column(name = "create_at",columnDefinition = "date")
    @CreationTimestamp
    private LocalDate createdAt;

    @Column(name = "update_at",columnDefinition = "date")
    @UpdateTimestamp
    private LocalDate updatedAt;

    @Column(name = "status",columnDefinition = "nvarchar2(30)")
    private Status status;

    public Order() {
    }

    public Order(String firstName, String lastName, Long totalAmount, LocalDate createdAt, LocalDate updatedAt, Status status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalAmount = totalAmount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
