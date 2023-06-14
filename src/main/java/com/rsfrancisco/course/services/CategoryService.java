package com.rsfrancisco.course.services;

import com.rsfrancisco.course.entities.Category;
import com.rsfrancisco.course.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository _categoryRepository;

    public List<Category> findAll() {
        return _categoryRepository.findAll();
    }

    public Category findById(Long idCategory) {
        Optional<Category> obj = _categoryRepository.findById(idCategory);
        return obj.get();
    }
}
