package com.hassan.springboot.di.app.springboot_di.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.hassan.springboot.di.app.springboot_di.models.Product;

@Primary
@Repository
public class ProductRepositoryFoo implements ProductRepository{

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Acer Predator 27", 500L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(id, "Acer Predator 27", 500L);
    }


}
