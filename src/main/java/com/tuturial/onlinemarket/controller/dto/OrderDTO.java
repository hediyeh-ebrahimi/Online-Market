package com.tuturial.onlinemarket.controller.dto;

public class OrderDTO {
    private String productName;
    private long cnt;
    private String firstName;
    private String lastName;
    private String status;
    private long totalPrice;
    private long totalDiscountPrice;

    public OrderDTO() {
    }

    public OrderDTO(String productName, long cnt, String firstName, String lastName, String status, long totalPrice, long totalDiscountPrice) {
        this.productName = productName;
        this.cnt = cnt;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.totalPrice = totalPrice;
        this.totalDiscountPrice = totalDiscountPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getCnt() {
        return cnt;
    }

    public void setCnt(long cnt) {
        this.cnt = cnt;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getTotalDiscountPrice() {
        return totalDiscountPrice;
    }

    public void setTotalDiscountPrice(long totalDiscountPrice) {
        this.totalDiscountPrice = totalDiscountPrice;
    }
}
