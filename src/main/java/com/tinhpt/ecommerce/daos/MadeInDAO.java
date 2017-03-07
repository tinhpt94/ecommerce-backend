package com.tinhpt.ecommerce.daos;

import com.tinhpt.ecommerce.entities.MadeIn;

public interface MadeInDAO {
    MadeIn findByCode(String code);

    MadeIn findById(Integer id);
}
