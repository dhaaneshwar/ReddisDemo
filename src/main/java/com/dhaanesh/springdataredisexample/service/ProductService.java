package com.dhaanesh.springdataredisexample.service;

import com.dhaanesh.springdataredisexample.entity.Product;
import com.dhaanesh.springdataredisexample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product save(Product product) {
        return repository.save(product);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id);
    }

    public String deleteProductById(int id) {
        return repository.deleteById(id);
    }
}
