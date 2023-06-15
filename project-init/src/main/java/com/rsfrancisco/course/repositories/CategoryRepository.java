package com.rsfrancisco.course.repositories;

import com.rsfrancisco.course.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
