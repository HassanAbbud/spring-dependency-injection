package com.hassan.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import com.hassan.springboot.di.app.springboot_di.models.Product;

public class ProductRepository {
    
    private List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
            new Product(1L, "DellXPS", 2000L),
            new Product(2L, "Asus Zephyrus", 2500L),
            new Product(3L, "Alienware M17", 2300L),
            new Product(4L, "Razer", 3200L)
        );
    }

    public List<Product> findAll(){
        return data;
    }

    public Product findById(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
