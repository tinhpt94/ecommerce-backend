package com.tinhpt.ecommerce.daos;

import com.tinhpt.ecommerce.entities.ProductType;

public interface ProductTypeDAO {
    ProductType findByCode(String code);

    ProductType findById(Integer id);
}
