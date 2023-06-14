package com.rsfrancisco.course.services;

import com.rsfrancisco.course.entities.Product;
import com.rsfrancisco.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository _productRepository;

    public List<Product> findAll() {
        return _productRepository.findAll();
    }

    public Product findById(Long productId) {
        return _productRepository.findById(productId).get();
    }
}
