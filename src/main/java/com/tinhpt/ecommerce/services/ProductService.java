package com.tinhpt.ecommerce.services;

import com.tinhpt.ecommerce.models.ProductDetailInfo;

import java.util.List;

/**
 * Created by tinhpt on 2/24/17.
 */
public interface ProductService {
    List<ProductDetailInfo> findAll();

    ProductDetailInfo findByProductCode(String code);

    List<ProductDetailInfo> findByBrandCode(String code);

    List<ProductDetailInfo> findByMadeInCode(String code);

    List<ProductDetailInfo> findByProductTypeCode(String code);
}
