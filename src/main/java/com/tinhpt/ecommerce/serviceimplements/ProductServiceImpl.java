package com.tinhpt.ecommerce.serviceimplements;

import com.tinhpt.ecommerce.daos.BrandDAO;
import com.tinhpt.ecommerce.daos.MadeInDAO;
import com.tinhpt.ecommerce.daos.ProductDAO;
import com.tinhpt.ecommerce.daos.ProductTypeDAO;
import com.tinhpt.ecommerce.entities.Brand;
import com.tinhpt.ecommerce.entities.MadeIn;
import com.tinhpt.ecommerce.entities.Product;
import com.tinhpt.ecommerce.entities.ProductType;
import com.tinhpt.ecommerce.models.*;
import com.tinhpt.ecommerce.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private BrandDAO brandDAO;

    @Autowired
    private ProductTypeDAO productTypeDAO;

    @Autowired
    private MadeInDAO madeInDAO;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<ProductDetailInfo> findAll() {
        List<ProductDetailInfo> result = new ArrayList<>();
        List<Product> products = productDAO.findAll();
        if (products.size() == 0) return null;
        else {
            for (Product product : products) {
                result.add(mapEntityToModel(product));
            }
            return result;
        }
    }

    @Override
    public ProductDetailInfo findByProductCode(String code) {
        Product product = productDAO.findByCode(code);
        if (product == null) {
            return null;
        } else {
            return mapEntityToModel(product);
        }
    }

    @Override
    public List<ProductDetailInfo> findByBrandCode(String code) {
        List<ProductDetailInfo> result = new ArrayList<>();
        List<Product> products = productDAO.findByBrandCode(code);
        if (products.size() == 0) return null;
        else {
            for (Product product : products) {
                result.add(mapEntityToModel(product));
            }
            return result;
        }
    }

    @Override
    public List<ProductDetailInfo> findByMadeInCode(String code) {
        List<ProductDetailInfo> result = new ArrayList<>();
        List<Product> products = productDAO.findByMadeInCode(code);
        if (products.size() == 0) return null;
        else {
            for (Product product : products) {
                result.add(mapEntityToModel(product));
            }
            return result;
        }
    }

    @Override
    public List<ProductDetailInfo> findByProductTypeCode(String code) {
        List<ProductDetailInfo> result = new ArrayList<>();
        List<Product> products = productDAO.findByProductTypeCode(code);
        if (products.size() == 0) return null;
        else {
            for (Product product : products) {
                result.add(mapEntityToModel(product));
            }
            return result;
        }
    }

    private ProductDetailInfo mapEntityToModel(Product product) {
        BrandModel brand = modelMapper.map(brandDAO.findById(product.getBrand()), BrandModel.class);
        ProductTypeModel productType = modelMapper.map(productTypeDAO.findById(product.getProductType()), ProductTypeModel.class);
        MadeInModel madeIn = modelMapper.map(madeInDAO.findById(product.getMadeIn()), MadeInModel.class);
        ProductDetailInfo productDetailInfo = modelMapper.map(product, ProductDetailInfo.class);
        productDetailInfo.setBrand(brand);
        productDetailInfo.setMadeIn(madeIn);
        productDetailInfo.setProductType(productType);
        return productDetailInfo;
    }

    @Override
    public Menu fetchMenuItem() {
        List<BrandModel> resultBrands = new ArrayList<>();
        List<Brand> brands = brandDAO.findAll();
        for (Brand brand : brands) {
            resultBrands.add(modelMapper.map(brand, BrandModel.class));
        }

        List<ProductTypeModel> resultProductTypes = new ArrayList<>();
        List<ProductType> productTypes = productTypeDAO.findAll();
        for (ProductType productType : productTypes) {
            resultProductTypes.add(modelMapper.map(productType, ProductTypeModel.class));
        }

        List<MadeInModel> resultMadeIns = new ArrayList<>();
        List<MadeIn> madeIns = madeInDAO.findAll();
        for (MadeIn madeIn : madeIns) {
            resultMadeIns.add(modelMapper.map(madeIn, MadeInModel.class));
        }

        return new Menu(resultBrands, resultMadeIns, resultProductTypes);
    }
}
