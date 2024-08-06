package com.hassan.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hassan.springboot.di.app.springboot_di.models.Product;
import com.hassan.springboot.di.app.springboot_di.repositories.ProductRepositoryImpl;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired 
    private ProductRepositoryImpl repository;
    
    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
            Double taxedPrice = p.getPrice() * 1.16d;
            // Product newProduct = new Product(p.getId(), p.getName(), newPrice.longValue());
            Product newProduct = (Product) p.clone();
            newProduct.setPrice(taxedPrice.longValue());
            return newProduct;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id){
        return repository.findById(id);
    }

}
