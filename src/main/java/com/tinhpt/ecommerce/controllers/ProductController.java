package com.tinhpt.ecommerce.controllers;

import com.tinhpt.ecommerce.models.ProductModal;
import com.tinhpt.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
}
