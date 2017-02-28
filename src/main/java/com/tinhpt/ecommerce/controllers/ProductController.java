package com.tinhpt.ecommerce.controllers;

import com.tinhpt.ecommerce.models.ProductDetail;
import com.tinhpt.ecommerce.models.ProductModal;
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
    ProductService productService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<ProductModal> findAll() {
        return productService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity findById(@PathVariable(value = "id") int id) {
        ProductDetail productDetail = productService.findById(id);
        if (productDetail == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(productDetail);
        }
    }
}
