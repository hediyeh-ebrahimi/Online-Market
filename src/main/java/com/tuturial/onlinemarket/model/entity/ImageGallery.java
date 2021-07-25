package com.tuturial.onlinemarket.model.entity;

import org.springframework.http.codec.multipart.Part;

public class ImageGallery {
    private Long productId;
    private Part[] file;

    public ImageGallery() {
    }

    public ImageGallery(Long productId, Part[] file) {
        this.productId = productId;
        this.file = file;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Part[] getFiles() {
        return file;
    }

    public void setFiles(Part[] file) {
        this.file = file;
    }
}
