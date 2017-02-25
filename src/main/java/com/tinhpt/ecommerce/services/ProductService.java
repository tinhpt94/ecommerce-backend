package com.tinhpt.ecommerce.services;

import com.tinhpt.ecommerce.models.ProductModal;

import java.util.List;

/**
 * Created by tinhpt on 2/24/17.
 */
public interface ProductService {
    List<ProductModal> findAll();
}
