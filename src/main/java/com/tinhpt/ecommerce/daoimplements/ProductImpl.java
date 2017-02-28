package com.tinhpt.ecommerce.daoimplements;

import com.tinhpt.ecommerce.daos.ProductDAO;
import com.tinhpt.ecommerce.entities.Product;
import org.springframework.stereotype.Repository;

/**
 * Created by tinhpt on 2/24/17.
 */
@Repository("productDAO")
public class ProductImpl extends AbstractDAO<Product, Integer> implements ProductDAO {

}
