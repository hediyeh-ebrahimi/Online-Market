package com.tuturial.onlinemarket.model.repository;

import com.tuturial.onlinemarket.model.entity.Image;
import com.tuturial.onlinemarket.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    Image findByProductAndImageAddress(Product product, String imageAddress);

    List<Image> findAllByProduct(Product product);
}
