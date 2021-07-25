package com.tuturial.onlinemarket.model.repository;

import com.tuturial.onlinemarket.model.entity.Product;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSearchRepository  extends CrudRepository<Product,Long> , JpaSpecificationExecutor<Product> {
}
