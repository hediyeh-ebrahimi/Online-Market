package com.tuturial.onlinemarket.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Image implements Serializable {

    @Id
    @Column(name = "image_id", columnDefinition = "number")
    @SequenceGenerator(name = "image_seq", sequenceName = "image_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_seq")
    private Long imageId;

    @ManyToOne
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "image_fk_product"), nullable = false)
    private Product product;

    @Column(name = "image_address" ,columnDefinition = "nvarchar2(255)")
    private String imageAddress;


    public Image() {
    }

    public Image(Product product, String imageAddress) {
        this.product = product;
        this.imageAddress = imageAddress;
    }


    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }
}
