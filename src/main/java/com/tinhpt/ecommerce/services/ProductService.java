package com.tinhpt.ecommerce.services;

import com.tinhpt.ecommerce.models.Menu;
import com.tinhpt.ecommerce.models.ProductDetailInfo;
import com.tinhpt.ecommerce.models.ProductRequest;

import java.util.List;

public interface ProductService {
    List<ProductDetailInfo> findAll();
    ProductDetailInfo findByProductCode(String code);
    List<ProductDetailInfo> findByBrandCode(String code);
    List<ProductDetailInfo> findByMadeInCode(String code);
    List<ProductDetailInfo> findByProductTypeCode(String code);

    ProductDetailInfo findById(int id);
    void create(ProductRequest productRequest);

    void update(ProductRequest productRequest);

    void delete(ProductRequest productRequest);
    Menu fetchMenuItem();
}
