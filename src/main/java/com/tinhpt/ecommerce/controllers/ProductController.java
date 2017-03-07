package com.tinhpt.ecommerce.controllers;

import com.tinhpt.ecommerce.models.ProductDetailInfo;
import com.tinhpt.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tinhpt on 2/24/17.
 */
@CrossOrigin
@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDetailInfo> findAll() {
        return productService.findAll();
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public ResponseEntity findById(@PathVariable(value = "code") String code) {
        ProductDetailInfo productDetailInfo = productService.findByProductCode(code);
        if (productDetailInfo == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(productDetailInfo);
        }
    }
}
