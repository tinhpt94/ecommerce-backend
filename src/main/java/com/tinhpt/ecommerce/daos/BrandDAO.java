package com.tinhpt.ecommerce.daos;

import com.tinhpt.ecommerce.entities.Brand;

import java.util.List;

public interface BrandDAO {
    Brand findByCode(String code);
    Brand findById(Integer id);

    List<Brand> findAll();
}
