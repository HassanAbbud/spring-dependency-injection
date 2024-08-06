package com.hassan.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hassan.springboot.di.app.springboot_di.models.Product;
import com.hassan.springboot.di.app.springboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository repository;

    public ProductServiceImpl(@Qualifier("productList") ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
            Double taxedPrice = p.getPrice() * 1.16d;
            // Product newProduct = new Product(p.getId(), p.getName(), newPrice.longValue());
            //Product newProduct = (Product) p.clone();
            // newProduct.setPrice(taxedPrice.longValue());
            // return newProduct;
            p.setPrice(taxedPrice.longValue());
            return p;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id){
        return repository.findById(id);
    }

}
