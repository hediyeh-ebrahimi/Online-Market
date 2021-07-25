package com.tuturial.onlinemarket.controller.dto;

public class ProductSearchDTO {
    private String categoryTitle;
    private String title;
    private Long minPriceValue;
    private Long maxPriceValue;
    private Long mostSold;
    private Long newestProduct;
    private Boolean favouriteProduct;
    private Long highestPrice;
    private Long lowestPrice;

    public ProductSearchDTO() {
    }

    public ProductSearchDTO(String categoryTitle, String title, Long minPriceValue, Long maxPriceValue, Long mostSold, Long newestProduct, Boolean favouriteProduct, Long highestPrice, Long lowestPrice) {
        this.categoryTitle = categoryTitle;
        this.title = title;
        this.minPriceValue = minPriceValue;
        this.maxPriceValue = maxPriceValue;
        this.mostSold = mostSold;
        this.newestProduct = newestProduct;
        this.favouriteProduct = favouriteProduct;
        this.highestPrice = highestPrice;
        this.lowestPrice = lowestPrice;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getMinPriceValue() {
        return minPriceValue;
    }

    public void setMinPriceValue(Long minPriceValue) {
        this.minPriceValue = minPriceValue;
    }

    public Long getMaxPriceValue() {
        return maxPriceValue;
    }

    public void setMaxPriceValue(Long maxPriceValue) {
        this.maxPriceValue = maxPriceValue;
    }

    public Long getMostSold() {
        return mostSold;
    }

    public void setMostSold(Long mostSold) {
        this.mostSold = mostSold;
    }

    public Long getNewestProduct() {
        return newestProduct;
    }

    public void setNewestProduct(Long newestProduct) {
        this.newestProduct = newestProduct;
    }

    public Boolean getFavouriteProduct() {
        return favouriteProduct;
    }

    public void setFavouriteProduct(Boolean favouriteProduct) {
        this.favouriteProduct = favouriteProduct;
    }

    public Long getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(Long highestPrice) {
        this.highestPrice = highestPrice;
    }

    public Long getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(Long lowestPrice) {
        this.lowestPrice = lowestPrice;
    }
}
