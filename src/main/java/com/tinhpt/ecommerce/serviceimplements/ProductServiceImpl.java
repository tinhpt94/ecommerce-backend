package com.tinhpt.ecommerce.serviceimplements;

import com.tinhpt.ecommerce.daos.ProductDAO;
import com.tinhpt.ecommerce.entities.Product;
import com.tinhpt.ecommerce.models.ProductDetail;
import com.tinhpt.ecommerce.models.ProductModal;
import com.tinhpt.ecommerce.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tinhpt on 2/24/17.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO productDAO;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<ProductModal> findAll() {
        List<ProductModal> result = new ArrayList<>();
        List<Product> products = productDAO.findAll();
        if (products.size() == 0) return null;
        else {
            for (Product product : products) {
                ProductModal productModal = modelMapper.map(product, ProductModal.class);
                result.add(productModal);
            }
            return result;
        }
    }

    @Override
    public ProductDetail findById(Integer id) {
        Product product = productDAO.findById(id);
        if (product == null) return null;
        else return modelMapper.map(product, ProductDetail.class);
    }
}
