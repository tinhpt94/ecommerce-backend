package com.tinhpt.ecommerce.controllers;

import com.tinhpt.ecommerce.models.ProductDetailInfo;
import com.tinhpt.ecommerce.models.ProductRequest;
import com.tinhpt.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(productDetailInfo);
        }
    }

    @RequestMapping(value = "/brand/{code}", method = RequestMethod.GET)
    public ResponseEntity findByBrandCode(@PathVariable(value = "code") String code) {
        List<ProductDetailInfo> productDetailInfos = productService.findByBrandCode(code);
        return ResponseEntity.ok(productDetailInfos);
    }

    @RequestMapping(value = "/made-in/{code}", method = RequestMethod.GET)
    public ResponseEntity findByMadeInCode(@PathVariable(value = "code") String code) {
        List<ProductDetailInfo> productDetailInfos = productService.findByMadeInCode(code);
        return ResponseEntity.ok(productDetailInfos);
    }

    @RequestMapping(value = "/product-type/{code}", method = RequestMethod.GET)
    public ResponseEntity findByProductTypeCode(@PathVariable(value = "code") String code) {
        List<ProductDetailInfo> productDetailInfos = productService.findByProductTypeCode(code);
        return ResponseEntity.ok(productDetailInfos);
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public ResponseEntity fetchBrands() {
        return ResponseEntity.ok(productService.fetchMenuItem());
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody ProductRequest productRequest) {
        try {
            productService.create(productRequest);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody ProductRequest productRequest) {
        try {
            productService.update(productRequest);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResponseEntity delete(@RequestBody ProductRequest productRequest) {
        try {
            productService.delete(productRequest);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
