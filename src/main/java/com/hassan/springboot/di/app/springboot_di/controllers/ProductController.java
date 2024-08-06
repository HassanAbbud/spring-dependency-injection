package com.hassan.springboot.di.app.springboot_di.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hassan.springboot.di.app.springboot_di.models.Product;
import com.hassan.springboot.di.app.springboot_di.services.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Product> productsList() {
        return this.productService.findAll();
    }

    @GetMapping("/{id}")
    public Product geProductById(@PathVariable Long id) {
        return this.productService.findById(id);
    }
    
}
