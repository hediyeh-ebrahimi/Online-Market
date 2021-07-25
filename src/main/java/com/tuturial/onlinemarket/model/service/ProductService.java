package com.tuturial.onlinemarket.model.service;

import com.tuturial.onlinemarket.controller.dto.ProductSearchDTO;
import com.tuturial.onlinemarket.model.entity.Product;
import com.tuturial.onlinemarket.model.repository.ProductRepository;
import com.tuturial.onlinemarket.model.repository.ProductSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private ProductSearchRepository productSearchRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductSearchRepository productSearchRepository) {
        this.productRepository = productRepository;
        this.productSearchRepository = productSearchRepository;
    }

    @Transactional
    public void addNewItem(Product product) {
        this.productRepository.save(product);
    }

    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    public Product findById(Long productId) {
        return this.productRepository.getById(productId);
    }

    public List<Product> search(ProductSearchDTO productSearchDTO) {

        List<Order> orders = new ArrayList<Order>();
//        Pageable pageable= new PageRequest(25, products.size() / 25, new Sort(orders));
//        Pageable pageable = new PageRequest(0,25,orders);


        List<Product> products = this.productSearchRepository.findAll(new Specification<Product>() {
            @Override
            public Predicate toPredicate(
                    Root<Product> root,
                    CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> predicates = new ArrayList<Predicate>();

                if (productSearchDTO.getCategoryTitle() != null && !productSearchDTO.getCategoryTitle().trim().isEmpty()) {
                    predicates.add(cb.like(root.get("categoryTitle"), "%" + productSearchDTO.getCategoryTitle() + "%"));
                }
                if (productSearchDTO.getTitle() != null && !productSearchDTO.getTitle().trim().isEmpty()) {
                    predicates.add(cb.like(root.get("title"), "%" + productSearchDTO.getTitle() + "%"));
                }

                if (productSearchDTO.getMinPriceValue() != null && productSearchDTO.getMinPriceValue() >= 0) {
                    predicates.add(cb.greaterThanOrEqualTo(root.get("price"), productSearchDTO.getMinPriceValue()));
                }

                if (productSearchDTO.getMaxPriceValue() != null && productSearchDTO.getMaxPriceValue() >= 0) {
                    predicates.add(cb.lessThanOrEqualTo(root.get("price"), productSearchDTO.getMaxPriceValue()));
                }

                System.out.println("--------------69--------------" + productSearchDTO.getFavouriteProduct());
                if (productSearchDTO.getFavouriteProduct() != null && productSearchDTO.getFavouriteProduct()) {
                    predicates.add(cb.equal(root.get("favourite"), 1));
                }
                System.out.println("-------------73----------" + productSearchDTO.getNewestProduct());

                List<String> orderingColumns = new ArrayList<>();
                if (productSearchDTO.getNewestProduct() != null) {
                    orderingColumns.add("productId-desc");
//                    query.orderBy(cb.desc(root.get("productId")));
//                    orders.add(new Sort.Order(Sort.Direction.DESC, "productId"));
                    orders.add(cb.desc(root.get("productId")));
                }

                if (productSearchDTO.getMostSold() != null) {
                    orderingColumns.add("soldCnt-desc");
//                    query.orderBy(cb.desc(root.get("soldCnt")));
//                    orders.add(new Sort.Order(Sort.Direction.DESC, "soldCnt"));
                    orders.add(cb.desc(root.get("soldCnt")));


                }

                if (productSearchDTO.getHighestPrice() != null) {
                    orderingColumns.add("price-desc");
//                    query.orderBy(cb.desc(root.get("price")));
//                    orders.add(new Sort.Order(Sort.Direction.DESC, "price"));
                    orders.add(cb.desc(root.get("price")));


                }

                if (productSearchDTO.getLowestPrice() != null) {
                    orderingColumns.add("price-asc");
//                    query.orderBy(cb.asc(root.get("price")));
//                    orders.add(new Sort.Order(Sort.Direction.ASC, "price"));
                    orders.add(cb.asc(root.get("price")));


                }

                if (orderingColumns.size() > 1) {
//
                    for (String orderCol : orderingColumns) {
                        String[] split = orderCol.split("-");
//                        System.out.println("---------------98-------------"+split[0]);
//                        System.out.println("---------------99-------------"+split[1]);
//                        if(split[0].equals("asc")) query.orderBy(cb.asc(root.get(split[0])));
//                        else query.orderBy(cb.desc(root.get(split[0])));
//
//                        if(split[0].equals("asc")) query.orderBy(cb.asc(root.get(split[0])));
//                        predicates.sort(Sort.Order.asc(split[0]));
//                        else query.orderBy(cb.desc(root.get(split[0])));

//                        query.orderBy(
//                                cb.desc(root.get(split[0]).as(Integer.class)),
//                                cb.desc(root.get("id").as(Integer.class))
//                        );
                    }
//                    query.orderBy(
//                            orderByItems
//                    );
//                    query.orderBy( orderingColumns.stream(st)cb.asc(root.get("itemName")), cb.desc(root.get("itemPrice")));
                }
//                else if (orderingColumns.size() ==1){
//                    String[] split = orderingColumns.get(0).split("-");
//                    System.out.println("---------------100-------------"+split[0]);
//                    System.out.println("---------------101-------------"+split[1]);
//                    if(split[0].equals("asc")) query.orderBy(cb.asc(root.get(split[0])));
//                    else query.orderBy(cb.desc(root.get(split[0])));
//                }

//                query.orderBy(cb.asc(root.get("productId")), cb.desc(root.get("price")));
                query.orderBy(orders);

                System.out.println("-----------144-------------------");
//                query.orderBy();
                return cb.and(predicates.toArray(new Predicate[]{}));
            }
        });

        System.out.println("-------------150-------------"+orders.size());
//        for (Sort.Order order : orders) {
//            System.out.println("--------151---------"+order.toString());
//        }
        return products;
    }

}
