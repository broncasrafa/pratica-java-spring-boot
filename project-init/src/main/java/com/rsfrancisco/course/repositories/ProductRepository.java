package com.rsfrancisco.course.repositories;

import com.rsfrancisco.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
