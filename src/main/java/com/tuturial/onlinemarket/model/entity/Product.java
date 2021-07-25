package com.tuturial.onlinemarket.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Base64;
import java.util.List;

@Entity
@Table
public class Product implements Serializable {

    @Id
    @Column(name = "product_id",columnDefinition = "number")
    @SequenceGenerator(name = "product_seq",sequenceName = "product_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_seq")
    private Long productId;

    @Column(name = "title",columnDefinition = "nvarchar2(20)")
    private String title;

//    @Transient
//    @Column(name = "title",columnDefinition = "nvarchar2(20)")
//    private String image;

    @Transient
    @Lob
    @Column(name = "Image")
    private byte[] image;

    @Column(name = "image_address")
    private String imageAddress;

    @Column(name = "price",columnDefinition = "number")
    private Long price;

    @Column(name = "price_by_discount",columnDefinition = "number")
    private Long priceByDisCount;

    @Column(name = "cnt",columnDefinition = "number(3)")
    private Long cnt;

    @Column(name = "sold_cnt",columnDefinition = "number(3)")
    private Long soldCnt;

    @OneToMany(mappedBy = "product")
    private List<Image> imageList;

    @Column(name = "category_title",columnDefinition = "nvarchar2(50)")
    private String categoryTitle;

    @Column(name = "favourite",columnDefinition = "number")
    private Long favourite;

    @Transient
    private String base64Image;

    public Product() {
    }


    public Product(String title, byte[] image, String imageAddress, Long price, Long priceByDisCount, Long cnt, Long soldCnt, List<Image> imageList, String categoryTitle, Long favourite, String base64Image) {
        this.title = title;
        this.image = image;
        this.imageAddress = imageAddress;
        this.price = price;
        this.priceByDisCount = priceByDisCount;
        this.cnt = cnt;
        this.soldCnt = soldCnt;
        this.imageList = imageList;
        this.categoryTitle = categoryTitle;
        this.favourite = favourite;
        this.base64Image = base64Image;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getPriceByDisCount() {
        return priceByDisCount;
    }

    public void setPriceByDisCount(Long priceByDisCount) {
        this.priceByDisCount = priceByDisCount;
    }

    public Long getCnt() {
        return cnt;
    }

    public void setCnt(Long cnt) {
        this.cnt = cnt;
    }

    public Long getSoldCnt() {
        return soldCnt;
    }

    public void setSoldCnt(Long soldCnt) {
        this.soldCnt = soldCnt;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public Long getFavourite() {
        return favourite;
    }

    public void setFavourite(Long favourite) {
        this.favourite = favourite;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
}
