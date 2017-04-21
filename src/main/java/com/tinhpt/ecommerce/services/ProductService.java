package com.tinhpt.ecommerce.services;

import com.tinhpt.ecommerce.models.*;

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

    CommentResponse create(CommentRequest commentRequest);

    List<CommentResponse> fetchCommentsByProductId(int productId);
}
