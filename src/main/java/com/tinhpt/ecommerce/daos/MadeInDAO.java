package com.tinhpt.ecommerce.daos;

import com.tinhpt.ecommerce.entities.MadeIn;

import java.util.List;

public interface MadeInDAO {
    MadeIn findByCode(String code);

    List<MadeIn> findAll();
    MadeIn findById(Integer id);
}
