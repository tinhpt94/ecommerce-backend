package com.tinhpt.ecommerce.daos;

import com.tinhpt.ecommerce.entities.Brand;

public interface BrandDAO {
    Brand findByCode(String code);

    Brand findById(Integer id);
}
