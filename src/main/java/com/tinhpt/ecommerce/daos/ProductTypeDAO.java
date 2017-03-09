package com.tinhpt.ecommerce.daos;

import com.tinhpt.ecommerce.entities.ProductType;

import java.util.List;

public interface ProductTypeDAO {
    ProductType findByCode(String code);

    List<ProductType> findAll();
    ProductType findById(Integer id);
}
