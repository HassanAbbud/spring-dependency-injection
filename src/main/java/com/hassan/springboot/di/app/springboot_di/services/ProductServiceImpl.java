package com.hassan.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hassan.springboot.di.app.springboot_di.models.Product;
import com.hassan.springboot.di.app.springboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository repository;
    //inject from AppConfig.Java
    @Value("${config.price.tax}")
    private Double tax;

    public ProductServiceImpl(@Qualifier("productList") ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
            Double taxedPrice = p.getPrice() * tax;
            // Product newProduct = new Product(p.getId(), p.getName(), newPrice.longValue());
            //Immutable Product object
            Product newProduct = (Product) p.clone();
            newProduct.setPrice(taxedPrice.longValue());
            return newProduct;
            //Mutable Product object from model
            // p.setPrice(taxedPrice.longValue());
            // return p;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id){
        return repository.findById(id);
    }

}
