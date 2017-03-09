package com.tinhpt.ecommerce.models;

import java.util.List;

public class Menu {
    private List<BrandModel> brands;
    private List<MadeInModel> madeIns;
    private List<ProductTypeModel> productTypes;

    public Menu(List<BrandModel> brands, List<MadeInModel> madeIns, List<ProductTypeModel> productTypes) {
        this.brands = brands;
        this.madeIns = madeIns;
        this.productTypes = productTypes;
    }

    public List<BrandModel> getBrands() {
        return brands;
    }

    public void setBrands(List<BrandModel> brands) {
        this.brands = brands;
    }

    public List<MadeInModel> getMadeIns() {
        return madeIns;
    }

    public void setMadeIns(List<MadeInModel> madeIns) {
        this.madeIns = madeIns;
    }

    public List<ProductTypeModel> getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(List<ProductTypeModel> productTypes) {
        this.productTypes = productTypes;
    }
}
