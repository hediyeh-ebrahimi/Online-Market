package com.tuturial.onlinemarket.model.service;

import com.tuturial.onlinemarket.model.entity.Image;
import com.tuturial.onlinemarket.model.entity.Product;
import com.tuturial.onlinemarket.model.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ImageService {
    private ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Transactional
    public void addNewItem(Image image){
        this.imageRepository.save(image);
    }

    public Image findByProductAndImageAddress(Product product, String imageAddress) {
        return this.imageRepository.findByProductAndImageAddress(product, imageAddress);
    }

    @Transactional
    public void deleteItem(Image image) {
        this.imageRepository.delete(image);
    }

    public List<Image> findAllByProduct(Product product) {
        return this.imageRepository.findAllByProduct(product);
    }
}
