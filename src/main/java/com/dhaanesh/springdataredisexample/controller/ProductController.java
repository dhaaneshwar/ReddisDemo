package com.dhaanesh.springdataredisexample.controller;

import com.dhaanesh.springdataredisexample.entity.Product;
import com.dhaanesh.springdataredisexample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@EnableCaching
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/add")
    public Product save(@RequestBody Product product) {
        return service.save(product);
    }

    @GetMapping("/get")
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/getById/{id}")
    @Cacheable(key="#id", value="Product")
    public Product getProductById(@PathVariable("id") int id){
        return service.getProductById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    @CacheEvict(key="#id", value="Product")
    public String deleteProductById(@PathVariable("id") int id){
        return service.deleteProductById(id);
    }
}
