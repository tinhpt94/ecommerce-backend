package com.tinhpt.ecommerce.daos;

import com.tinhpt.ecommerce.entities.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findAll();
    Product findByCode(String code);
    List<Product> findByBrandCode(String code);
    List<Product> findByProductTypeCode(String code);
    List<Product> findByMadeInCode(String code);

    Product findById(Integer id);
    Integer save(Product product);
    void update(Product product);

    void delete(Product product);
}
