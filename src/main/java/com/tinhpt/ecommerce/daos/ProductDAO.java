package com.tinhpt.ecommerce.daos;

import com.tinhpt.ecommerce.entities.Product;

import java.util.List;

/**
 * Created by tinhpt on 2/24/17.
 */
public interface ProductDAO {
    List<Product> findAll();
}
