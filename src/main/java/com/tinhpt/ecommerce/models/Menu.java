package com.tinhpt.ecommerce.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Menu {
    private List<BrandModel> brands;
    private List<MadeInModel> madeIns;
    private List<ProductTypeModel> productTypes;
}
